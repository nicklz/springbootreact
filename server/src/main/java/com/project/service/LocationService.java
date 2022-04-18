package com.project.service;

import com.project.domain.Location;
import com.project.repository.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> list(Long startDate, Long endDate) {
        return locationRepository.findByStartDateAfterAndEndDateBefore(startDate, endDate);
    }

    public Location save(Location location) {
        return locationRepository.save(location);
    }

    public void save(List<Location> locations) {
        locationRepository.saveAll(locations);
    }
}
