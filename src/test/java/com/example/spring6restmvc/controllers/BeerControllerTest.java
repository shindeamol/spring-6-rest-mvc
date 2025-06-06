package com.example.spring6restmvc.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerControllerTest {
    @Autowired
    BeerController controller;
    @Test
    void getBeerById() {
        System.out.println(controller.getBeerById(UUID.randomUUID()));
    }
}