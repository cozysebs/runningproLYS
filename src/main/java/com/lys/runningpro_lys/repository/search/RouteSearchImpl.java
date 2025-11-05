package com.lys.runningpro_lys.repository.search;

import com.lys.runningpro_lys.entity.QRoutes;
import com.lys.runningpro_lys.entity.Routes;
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
                    case "t":
                        builder.or(qroutes.title.containsIgnoreCase(keyword));
                        break;
                    // 지역명 추가하기. -> 지역명 데이터를 어떻게 저장하고 불러와야 하나?
                }
            }
            query.where(builder);
        }
        query.where(qroutes.id.gt(0));
        this.getQuerydsl().applyPagination(pageable, query);
        List<Routes> list = query.fetch();
        long count = query.fetchCount();
        return new PageImpl<>(list, pageable, count);
    }
}
