package com.project.repository;

import com.project.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

	Iterable<Location> findByName(String name);
	
	Iterable<Location> findByStartDateAfterAndEndDateBefore(Long startDate, Long endDate);
	
}
