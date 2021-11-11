package com.xmbapi.controller;

import com.xmbapi.model.Aerodrome;
import com.xmbapi.services.AerodromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aerodrome")
@CrossOrigin("*")
public class AerodromeController {

    @Autowired
    AerodromeService aerodromeService;

    @PostMapping("create")
    public Aerodrome createAerodrome(@RequestBody Aerodrome aerodrome){
        return this.aerodromeService.createAerodrome(aerodrome);
    }

    @PostMapping("create-list")
    public String createAerodromes(@RequestBody List<Aerodrome> aerodromes){
        return this.aerodromeService.createAerodromes(aerodromes);
    }

    @GetMapping("get-all")
    public List<Aerodrome> getAerodromes(){
        return this.aerodromeService.getAerodromes();
    }

}
