package com.lys.runningpro_lys.repository.search;

import com.lys.runningpro_lys.entity.Routes;
import com.lys.runningpro_lys.entity.fieldenum.Difficulty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RouteSearch {
    //필요한 경우 'String[] types'를 추가.
    Page<Routes> searchAll(String[] types, String keyword, Pageable pageable);
    Page<Routes> searchAllPlus(String[] types, String keyword,
                               Integer distance, Difficulty  difficulty, Pageable pageable);

}
