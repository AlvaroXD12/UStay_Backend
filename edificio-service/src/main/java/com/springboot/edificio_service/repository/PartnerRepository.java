package com.springboot.edificio_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.edificio_service.entity.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer>{

}
