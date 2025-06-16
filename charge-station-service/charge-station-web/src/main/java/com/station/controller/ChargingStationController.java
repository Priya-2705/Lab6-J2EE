package com.station.controller;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.charge.station.ejb.model.ChargingStation;
import org.charge.station.ejb.service.ChargingStationServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChargingStationController {

private ChargingStationServiceRemote chargingStationService;

@GetMapping("/stations")
public ModelAndView getAllStations() {
    List<ChargingStation> stations = chargingStationService.getAllStations();
    return new ModelAndView("all", "stations", stations);
}

@GetMapping("/stations/available")
public ModelAndView getAvailableStations() {
    List<ChargingStation> stations = chargingStationService.getAvailableStations();
    return new ModelAndView("available", "stations", stations);
}

@GetMapping("/stations/unavailable")
public String getUnavailableStations(Model model) {
    List<ChargingStation> stations = chargingStationService.getUnavailableStations();
    model.addAttribute("stations", stations);
    model.addAttribute("count", stations.size());
    return "unavailable";
}
}