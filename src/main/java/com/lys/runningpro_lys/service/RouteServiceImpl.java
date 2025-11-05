package com.lys.runningpro_lys.service;

import com.lys.runningpro_lys.dto.PageRequestDTO;
import com.lys.runningpro_lys.dto.PageResponseDTO;
import com.lys.runningpro_lys.dto.RoutesDTO;
import com.lys.runningpro_lys.entity.Routes;
import com.lys.runningpro_lys.entity.Users;
import com.lys.runningpro_lys.repository.RouteRepository;
import com.lys.runningpro_lys.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Long insertRoute(RoutesDTO routesDTO) {
        Routes routes = dtoToEntity(routesDTO);
        Users users = userRepository.findByEmail(routesDTO.getEmail());
        routes.setUsers(users);
        Long id = routeRepository.save(routes).getId();
        return id;
    }

    @Override
    public List<RoutesDTO> findAllRoutes() {
        return List.of();
    }

    @Override
    public RoutesDTO findRouteById(Long id, Integer mode) {
        Routes routes = routeRepository.findById(id).orElse(null);
        if (mode == 1) {
            routes.updateViews();
            routeRepository.save(routes);
        }
        RoutesDTO routesDTO = entityToDto(routes);
        //routesDTO.setAuthor(board.getMember().getUsername()); -> 필요할까?
        return routesDTO;
    }

    @Override
    public void updateRoute(RoutesDTO routesDTO) {

    }

    @Override
    public void deleteRoute(Long id) {

    }

    @Override
    public PageResponseDTO<RoutesDTO> getList(PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable("id");
        Page<Routes> result = routeRepository.searchAll(
                pageRequestDTO.getTypes(),
                pageRequestDTO.getKeyword(),
                pageable);
        List<RoutesDTO> dtoList = result.getContent().stream()
                .map(routes -> entityToDto(routes))
                .collect(Collectors.toList());
        int total = (int)result.getTotalElements();
        PageResponseDTO<RoutesDTO> responseDTO = PageResponseDTO.<RoutesDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(total)
                .build();
        return responseDTO;
    }


}
