package com.example.demo;

import org.springframework.data.repository.CrudRepository;
public interface StationRepo extends CrudRepository<Station, Integer> {
}