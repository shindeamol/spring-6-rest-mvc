package com.example.spring6restmvc.services;

import com.example.spring6restmvc.models.Beer;
import com.example.spring6restmvc.models.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    private final Map<UUID, Beer> beers;

    public BeerServiceImpl() {
        this.beers = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Hop House")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12345")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(123)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Hop House")
                .beerStyle(BeerStyle.CIDER)
                .upc("145")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(123)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Hop House")
                .beerStyle(BeerStyle.ALE)
                .upc("1245")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(123)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        beers.put(beer1.getId(), beer1);
        beers.put(beer2.getId(), beer2);
        beers.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> getBeers(){
        return beers.values().stream().toList();
    }

    @Override
    public Beer getBeerById(UUID id) {
        log.debug("Get Beer Id in service was called");

        return beers.get(id);
    }
}
