package com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
