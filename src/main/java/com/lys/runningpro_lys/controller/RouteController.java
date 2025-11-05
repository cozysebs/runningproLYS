package com.lys.runningpro_lys.controller;


import com.lys.runningpro_lys.dto.PageRequestDTO;
import com.lys.runningpro_lys.dto.PageResponseDTO;
import com.lys.runningpro_lys.dto.RoutesDTO;
import com.lys.runningpro_lys.service.RouteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<RoutesDTO> responseDTO = routeService.getList(pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
    }

    @GetMapping({"read", "modify"})
    public void readRoute(Long id, Integer mode, PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("route", routeService.findRouteById(id,mode));
    }

    @PostMapping("modify")
    public String modifyRoute(RoutesDTO routesDTO, RedirectAttributes redirectAttributes) {
        routeService.updateRoute(routesDTO);
        redirectAttributes.addAttribute("id", routesDTO.getId());
        redirectAttributes.addAttribute("mode", 1);
        return "redirect:/route/read";
    }

    @GetMapping("remove")
    public String removeRoute(Long id) {
        routeService.deleteRoute(id);
        return "redirect:/route/list";
    }
}
