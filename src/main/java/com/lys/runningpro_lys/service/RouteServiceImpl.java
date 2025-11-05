package com.lys.runningpro_lys.service;

import com.lys.runningpro_lys.dto.RoutesDTO;
import com.lys.runningpro_lys.entity.Routes;
import com.lys.runningpro_lys.entity.Users;
import com.lys.runningpro_lys.repository.RouteRepository;
import com.lys.runningpro_lys.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public RoutesDTO findRouteById(Long id) {
        return null;
    }

    @Override
    public void updateRoute(RoutesDTO routesDTO) {

    }

    @Override
    public void deleteRoute(Long id) {

    }
}
