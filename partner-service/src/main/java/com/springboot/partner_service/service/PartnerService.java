package com.springboot.partner_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.partner_service.entity.Partner;
import com.springboot.partner_service.repository.PartnerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PartnerService {
	@Autowired
	PartnerRepository partnerRepository;
	
	public List<Partner> findAll() {
		return partnerRepository.findAll();
	}
	
	public void save(Partner partner) {
		partnerRepository.save(partner);
	}
	
	public Optional<Partner> findById(int id) {
		return partnerRepository.findById(id);
	}
	
	public void delete(int id) {
		partnerRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return partnerRepository.existsById(id);
	}
	
	public void update(int id, Partner updatedPartner) {
		Optional<Partner> optionalPartner = partnerRepository.findById(id);
		if (optionalPartner.isPresent()) {
			Partner partner = optionalPartner.get();
			partner.setNombreEmpresa(updatedPartner.getNombreEmpresa());
			partner.setRuc(updatedPartner.getRuc());
			partner.setDireccionEmpresa(updatedPartner.getDireccionEmpresa());
			partner.setCorreoEmpresa(updatedPartner.getCorreoEmpresa());
			partnerRepository.save(partner);
		}
	}
}
