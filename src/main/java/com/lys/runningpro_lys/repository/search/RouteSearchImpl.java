package com.lys.runningpro_lys.repository.search;

import com.lys.runningpro_lys.entity.QRoutes;
import com.lys.runningpro_lys.entity.Routes;
import com.lys.runningpro_lys.entity.fieldenum.Difficulty;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class RouteSearchImpl extends QuerydslRepositorySupport implements RouteSearch {
    
    public RouteSearchImpl(){ super(Routes.class); }

    //필요한 경우 types[] 추가하기
    @Override
    public Page<Routes> searchAll(String[] types, String keyword, Pageable pageable) {
        QRoutes qroutes = QRoutes.routes;
        JPQLQuery<Routes> query = from(qroutes);

        if(types!=null && types.length>0 && keyword!=null){
            BooleanBuilder builder = new BooleanBuilder();
            for (String type:types){
                switch (type){
                    case "a":
                        builder.or(qroutes.address.containsIgnoreCase(keyword));
                        break;
                }
            }
            // 주소 검색 코드 수정하기
            // 거리 조건 추가하기
            // 난이도 조건 추가하기
            query.where(builder);
        }
        query.where(qroutes.id.gt(0));
        this.getQuerydsl().applyPagination(pageable, query);
        List<Routes> list = query.fetch();
        long count = query.fetchCount();
        return new PageImpl<>(list, pageable, count);
    }

    @Override
    public Page<Routes> searchAllPlus(String[] types, String keyword,
                                      Integer distance, Difficulty difficulty, Pageable pageable) {
        QRoutes qroutes = QRoutes.routes;
        JPQLQuery<Routes> query = from(qroutes);
        BooleanBuilder builder = new BooleanBuilder();

        // 지역
        if(types!=null && types.length>0 && keyword!=null){
            for (String type:types){
                if (type.equals("a")) {
                    builder.or(qroutes.address.containsIgnoreCase(keyword));
                }
            }
        }

        // 거리
        if(distance!=null){
            switch(distance){
                case 100000     // 10km~
                    : builder.and(qroutes.distance.goe(10_000));
                    break;
                case 5000       // 5~10km
                    : builder.and(qroutes.distance.between(5_000, 9_999));
                    break;
                case 1000       // 1~5km
                    : builder.and(qroutes.distance.between(1_000, 4_999));
                    break;
                default:
            }
        }
        // 난이도
        if(difficulty!=null){
            builder.and(qroutes.difficulty.eq(difficulty));
        }

        query.where(builder);
        query.where(qroutes.id.gt(0));
        this.getQuerydsl().applyPagination(pageable, query);
        List<Routes> list = query.fetch();
        long count = query.fetchCount();
        return new PageImpl<>(list, pageable, count);
    }


}
