package com.project.controller;

import com.project.domain.Location;
import com.project.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "http://localhost:1337", maxAge = 3600)
public class LocationsController {

    private LocationService locationService;

    public LocationsController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/list")
    public Iterable<Location> list(
      @RequestParam() Long startDate,
      @RequestParam() Long endDate
    ) {
        return locationService.list(startDate, endDate);
    }

}
