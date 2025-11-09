package com.protik.travel_agency.controllers;

import com.protik.travel_agency.entities.Continent;
import com.protik.travel_agency.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/continent")
public class ContinentController {
    @Autowired
    private ContinentService continentService;

    @GetMapping("/all")
    public List<Continent> getAll() {
        return continentService.findAll();
    }

    @GetMapping("/{id}")
    public Continent getContinentById(@PathVariable String id) {
        return continentService.findById(id);
    }


}
