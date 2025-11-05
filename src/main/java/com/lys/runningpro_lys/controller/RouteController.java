package com.lys.runningpro_lys.controller;


import com.lys.runningpro_lys.dto.RoutesDTO;
import com.lys.runningpro_lys.service.RouteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteService routeService;

    @GetMapping("register")
    public void registerGet() {
        log.info("-----registerGet-----");
    }

    @PostMapping("register")
    public String registerPost(RoutesDTO routesDTO) {
        log.info("-----registerPost-----");

        Long id = routeService.insertRoute(routesDTO);
        if(id != null) {
            log.info("-----insert route success-----");
            return "redirect:/route/list";
        } else {
            log.info("-----insert route error-----");
            return "redirect:/route/register";
        }
    }
}
