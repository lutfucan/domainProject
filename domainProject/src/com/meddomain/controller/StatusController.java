package com.meddomain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.meddomain.entity.DomainStatus;
import com.meddomain.service.ApplicationService;

@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private ApplicationService service;

	@RequestMapping("/list")
	public String showStatusList(Model model) {
		List<DomainStatus> statusList = service.getStatusList();
		model.addAttribute("theStatusList", statusList);
		return "status-list";
	}

	@RequestMapping("/add")
	public String showStatusForm(Model model) {
		model.addAttribute("status", new DomainStatus());
		return "add-status";
	}

	@PostMapping(value = "/addStatus")
	public String addDomain(@ModelAttribute(name = "status") DomainStatus domainStatus) {		
		service.merge(domainStatus);
		return "redirect:/status/list";
	}

}