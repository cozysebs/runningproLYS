package com.lys.runningpro_lys.repository;

import com.lys.runningpro_lys.entity.Routes;
import com.lys.runningpro_lys.repository.search.RouteSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<Routes, Long>, RouteSearch {

//    @Query("select r from Routes r where r.id=:id")
//    Optional<Routes> findRoutesById(Long id);
}
