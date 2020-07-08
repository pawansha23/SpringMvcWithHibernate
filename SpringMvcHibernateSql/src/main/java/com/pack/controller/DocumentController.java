package com.pack.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.service.DocumentService;
import com.pack.vo.DocumentVO;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService docServ;

	@ModelAttribute("documentVO")
	public DocumentVO loadEmptyModelBean() {
		System.out.println("Testing Model");

		return new DocumentVO();
	}

	@RequestMapping(value = "/addNewPdf", method = RequestMethod.GET)
	public String addPdfPage(Model model) {
		model.addAttribute("documentVO", new DocumentVO());
		return "addPdf";
	}
	
	@RequestMapping(value = "/addNewPdfSuccess", method = RequestMethod.GET)
	public String addPdfPageSuccess(Model model) {
		model.addAttribute("documentVO", new DocumentVO());
		model.addAttribute("successMessage", "PDF Saved to Database!");
		return "addPdf";
	}

	@RequestMapping(value = "/createPdf", method = RequestMethod.POST)
	public String addDocument(@Valid DocumentVO documentVO, BindingResult result) {

		if (result.hasErrors()) {
			return "addNewPdf";
		}

		docServ.addPdf(documentVO);
		return "redirect:/addNewPdfSuccess";
	}
	
	

}
