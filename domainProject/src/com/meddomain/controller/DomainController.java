package com.meddomain.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meddomain.entity.Domain;
import com.meddomain.entity.DomainCategory;
import com.meddomain.entity.DomainStatus;
import com.meddomain.entity.Registrar;
import com.meddomain.service.ApplicationService;

@Controller
@RequestMapping("/domain")
public class DomainController {

	@Autowired
	private ApplicationService service;

	@RequestMapping("/list")
	public String showDomainList(Model model) {
		List<Domain> domainsList = service.getDomainsList();
		model.addAttribute("theDomainsList", domainsList);
		return "domain-list";
	}

	@RequestMapping("/add")
	public String showDomainForm(Model model) {
		model.addAttribute("registrarList", service.getRegistrarList());
		model.addAttribute("statusList", service.getStatusList());
		model.addAttribute("categoryList", service.getCategoryList());

		model.addAttribute("domain", new Domain());
		return "add-domain";
	}

	@PostMapping(value = "/addDomain")
	public String addDomain(@ModelAttribute(name = "domain") Domain domain,
			@RequestParam("registrar") Integer registrarId, 
			@RequestParam("status") Integer statusId,
			@RequestParam("categories") Integer[] categoriesId) {

		Registrar registrar = service.getRegistrar(Registrar.class, registrarId);
		DomainStatus status = service.getStatus(DomainStatus.class, statusId);
		List<DomainCategory> categoriesList = new ArrayList<>();

		for (Integer categoryId : categoriesId) {
			categoriesList.add(service.getCategory(DomainCategory.class, categoryId));
		}

		domain.setRegistrar(registrar);
		domain.setStatus(status);
		domain.setCategories(categoriesList);

		service.merge(domain);
		service.merge(registrar);
		service.merge(status);
		
		for(DomainCategory domCategory : categoriesList) {
			service.merge(domCategory);
		}

		return "redirect:/domain/list";
	}

}