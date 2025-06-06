package com.example.spring6restmvc.controllers;

import com.example.spring6restmvc.models.Beer;
import com.example.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @GetMapping("")
    public List<Beer> getAllBeers() {
        log.debug("Getting all beers");
        return beerService.getBeers();
    }

    @GetMapping("/{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID beerId){
        log.debug("Get Beer by Id in controller");

        return beerService.getBeerById(beerId);
    }
}
