package com.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.domain.Location;
import com.project.service.LocationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProjectApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(LocationService locationService) {
    return args -> {
      // read JSON and load json
      ObjectMapper mapper = new ObjectMapper();
      TypeReference<List<Location>> typeReference = new TypeReference<List<Location>>() {
      };
      InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");
      try {
        List<Location> locations = mapper.readValue(inputStream, typeReference);
        locationService.save(locations);
        System.out.println("Location Saved!");
      } catch (IOException e) {
        System.out.println("Unable to save locations: " + e.getMessage());
      }
    };
  }
}
