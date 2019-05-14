package com.meddomain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.meddomain.entity.Registrar;
import com.meddomain.service.ApplicationService;

@Controller
@RequestMapping("/registrar")
public class RegistrarController {

	@Autowired
	private ApplicationService service;

	@RequestMapping("/list")
	public String showRegistrarList(Model model) {
		List<Registrar> registrarList = service.getRegistrarList();
		model.addAttribute("theRegistrarList", registrarList);
		return "registrar-list";
	}

	@RequestMapping("/add")
	public String showRegistrarForm(Model model) {
		model.addAttribute("registrar", new Registrar());
		return "add-registrar";
	}

	@PostMapping(value = "/addRegistrar")
	public String addDomain(@ModelAttribute(name = "registrar") Registrar registrar) {		
		service.merge(registrar);
		return "redirect:/registrar/list";
	}

}