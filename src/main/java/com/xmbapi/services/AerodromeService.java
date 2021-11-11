package com.xmbapi.services;

import com.xmbapi.model.Aerodrome;
import com.xmbapi.repository.AerodromeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerodromeService {

    @Autowired
    AerodromeRepository aerodromeRepository;

    public Aerodrome createAerodrome(Aerodrome aerodrome){
        return this.aerodromeRepository.save(aerodrome);
    }

    public List<Aerodrome> getAerodromes(){
        return this.aerodromeRepository.findAll();
    }
}