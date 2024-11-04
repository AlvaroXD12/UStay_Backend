package com.ustay.ustay_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiservidor")
public class ConfigServerController 
{
	@GetMapping("/alta")
	public String alta()
	{
		return "Servidor de configuraciones levantado";
	}
}


