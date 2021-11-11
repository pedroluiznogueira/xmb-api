package com.xmbapi.services;

import com.xmbapi.model.Runway;
import com.xmbapi.repository.RunwayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunwayService {

    @Autowired
    RunwayRepository runwayRepository;

    public Runway createRunway(Runway runway){
        return this.runwayRepository.save(runway);
    }

    public List<Runway> getRunways(){
        return this.runwayRepository.findAll();
    }
}