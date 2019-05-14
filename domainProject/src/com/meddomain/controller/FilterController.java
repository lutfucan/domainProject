package com.meddomain.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meddomain.service.FileImportService;
import com.meddomain.util.CollectionConverter;
import com.meddomain.util.CompareTwoLists;

@Controller
@RequestMapping("/filter")
public class FilterController {

	@Autowired
	private FileImportService service;
	@Autowired
	ServletContext servletContext;
	@Autowired
	CompareTwoLists comparer;	
	@Autowired
	CollectionConverter<String> converter;

	@RequestMapping("/main")
	public String showFilteringPage(Model model) {
		String path = servletContext.getRealPath("/");
		HashSet<String> domainsToFilter = service.getGenericListAndReadHashSet(path + "resources/txt/domains.txt");
		HashSet<String> words = service.getGenericListAndReadHashSet(path + "resources/txt/turkce.txt");
		HashSet<String> blackWords = service.getGenericListAndReadHashSet(path + "resources/txt/karaliste.txt");
		
		model.addAttribute("domainsToFilter",converter.getFirstXMembers(domainsToFilter, 10));
		model.addAttribute("words", converter.getFirstXMembers(words, 10));
		model.addAttribute("blackWords", converter.getFirstXMembers(blackWords, 10));
//		model.addAttribute("filtered", comparer.compareStartsWith(domainsToFilter, words, blackWords));
		return "import-domains";
	}
	
	@PostMapping("/filter")
	public String startFiltering(Model model) {
		String path = servletContext.getRealPath("/");
		HashSet<String> domainsToFilter = service.getGenericListAndReadHashSet(path + "resources/txt/domains.txt");
		HashSet<String> words = service.getGenericListAndReadHashSet(path + "resources/txt/turkce.txt");
		HashSet<String> blackWords = service.getGenericListAndReadHashSet(path + "resources/txt/karaliste.txt");
		
		model.addAttribute("domainsToFilter",converter.getFirstXMembers(domainsToFilter, 10));
		model.addAttribute("words", converter.getFirstXMembers(words, 10));
		model.addAttribute("blackWords", converter.getFirstXMembers(blackWords, 10));
		model.addAttribute("filtered", comparer.compareStartsWith(domainsToFilter, words, blackWords));
		return "import-domains";
	}

	@RequestMapping("/import")
	public String importDomainList(Model model, @RequestParam("domainText") File file) {
		model.addAttribute("arrayList", new ArrayList<>());
//		System.out.println(service.getImportedDomains(file));
		System.out.println(file);

		return "import-domains";
	}

}