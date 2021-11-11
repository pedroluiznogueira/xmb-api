package com.xmbapi.repository;

import com.xmbapi.model.Aerodrome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerodromeRepository extends JpaRepository<Aerodrome, Long> {
}