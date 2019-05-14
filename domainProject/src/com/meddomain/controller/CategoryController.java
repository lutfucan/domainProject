package com.meddomain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.meddomain.entity.DomainCategory;
import com.meddomain.service.ApplicationService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ApplicationService service;

	@RequestMapping("/list")
	public String showCategoryList(Model model) {
		List<DomainCategory> categoryList = service.getCategoryList();
		model.addAttribute("theCategoryList", categoryList);
		return "category-list";
	}

	@RequestMapping("/add")
	public String showCategoryForm(Model model) {
		model.addAttribute("category", new DomainCategory());
		return "add-category";
	}

	@PostMapping(value = "/addCategory")
	public String addDomain(@ModelAttribute(name = "category") DomainCategory domainCategory) {		
		service.merge(domainCategory);
		return "redirect:/category/list";
	}

}