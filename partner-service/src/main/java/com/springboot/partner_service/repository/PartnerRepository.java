package com.springboot.partner_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.partner_service.entity.Partner;


public interface PartnerRepository extends JpaRepository<Partner, Integer> {

}