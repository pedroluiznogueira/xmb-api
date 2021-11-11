package com.xmbapi.controller;

import com.xmbapi.model.Runway;
import com.xmbapi.services.RunwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runway")
@CrossOrigin("*")
public class RunwayController {

    @Autowired
    RunwayService runwayService;

    @PostMapping("create")
    public Runway createRunway(@RequestBody Runway runway){
        return this.runwayService.createRunway(runway);
    }

    @GetMapping("get-all")
    public List<Runway> getRunways(){
        return this.runwayService.getRunways();
    }

}
