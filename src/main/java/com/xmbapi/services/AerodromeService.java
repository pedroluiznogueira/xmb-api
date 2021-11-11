package com.xmbapi.services;

import com.xmbapi.model.Aerodrome;
import com.xmbapi.model.Runway;
import com.xmbapi.repository.AerodromeRepository;
import com.xmbapi.repository.RunwayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AerodromeService {

    @Autowired
    AerodromeRepository aerodromeRepository;

    @Autowired
    RunwayRepository runwayRepository;

    public Aerodrome createAerodrome(Aerodrome aerodrome){

        Optional<List<Runway>> runways = Optional.of(aerodrome.getRunways());

        Aerodrome saveAerodrome = this.aerodromeRepository.save(aerodrome);

        for (Runway runway: aerodrome.getRunways()){
            runway.setAerodrome(saveAerodrome);
            this.runwayRepository.save(runway);
        }

        return saveAerodrome;
    }

    public List<Aerodrome> getAerodromes(){
        return this.aerodromeRepository.findAll();
    }
}