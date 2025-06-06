package com.example.spring6restmvc.services;

import com.example.spring6restmvc.models.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> getBeers();

    Beer getBeerById(UUID id);
}
