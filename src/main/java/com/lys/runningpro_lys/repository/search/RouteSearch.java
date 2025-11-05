package com.lys.runningpro_lys.repository.search;

import com.lys.runningpro_lys.entity.Routes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RouteSearch {
    //필요한 경우 'String[] types'를 추가.
    Page<Routes> searchAll(String[] types, String keyword, Pageable pageable);

}
