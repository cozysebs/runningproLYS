package com.lys.runningpro_lys.service;

import com.lys.runningpro_lys.dto.PageRequestDTO;
import com.lys.runningpro_lys.dto.PageResponseDTO;
import com.lys.runningpro_lys.dto.RoutesDTO;
import com.lys.runningpro_lys.entity.Routes;

import java.util.List;

public interface RouteService {
    Long insertRoute(RoutesDTO routesDTO);

    List<RoutesDTO> findAllRoutes();

    RoutesDTO findRouteById(Long id, Integer mode);

    void updateRoute(RoutesDTO routesDTO);

    void deleteRoute(Long id);

    PageResponseDTO<RoutesDTO> getList(PageRequestDTO pageRequestDTO);



    //view에서 입력 받기(insert)
    //roouteData와 distance가 추가될 수 있음(kakao)
    default Routes dtoToEntity(RoutesDTO routesDTO) {
        Routes routes = Routes.builder()
                .id(routesDTO.getId())
                .title(routesDTO.getTitle())
                .description(routesDTO.getDescription())
                .difficulty(routesDTO.getDifficulty())
                .durationHr(routesDTO.getDurationHr())
                .durationMin(routesDTO.getDurationMin())
                .durationS(routesDTO.getDurationS())
                .heartRateMax(routesDTO.getHeartRateMax())
                .heartRateAvg(routesDTO.getHeartRateAvg())
                .build();

        return routes;
    }

    //DB에서 출력하기(read)
    //roouteData와 distance가 추가될 수 있음(kakao)
    default RoutesDTO entityToDto(Routes routes) {
        RoutesDTO routesDTO = RoutesDTO.builder()
                .id(routes.getId())
                .title(routes.getTitle())
                .description(routes.getDescription())
                .difficulty(routes.getDifficulty())
                .durationHr(routes.getDurationHr())
                .durationMin(routes.getDurationMin())
                .durationS(routes.getDurationS())
                .heartRateMax(routes.getHeartRateMax())
                .heartRateAvg(routes.getHeartRateAvg())
                .views(routes.getViews())
                .createdDate(routes.getCreatedDate())
                .updatedDate(routes.getUpdatedDate())
                .build();
        return routesDTO;
    }


}



















