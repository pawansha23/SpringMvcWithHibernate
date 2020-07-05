package com.pack.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pack.service.AccountService;
import com.pack.vo.AccountVO;

@Controller
public class AccountController {

//	private Map<String, AccountVO> accountVO = null;
//
//	public AccountController() {
//		accountVO = new HashMap<String, AccountVO>();
//	}

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/addnewAccount", method = RequestMethod.GET)
	public String saveAccountPage(Model model) {
		model.addAttribute("accountVO", new AccountVO());
		return "newAccount";
	}

	@ModelAttribute("accountVO")
	public AccountVO loadEmptyModelBean() {
		System.out.println("Testing Model");

		return new AccountVO();
	}

	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public String addAccount(@Valid AccountVO accountVO, BindingResult result) {
		MultipartFile mf = accountVO.getImage();
		byte[] targetImg = null;
		
		MultipartFile multDoc = accountVO.getCustomerDoc();
		byte[] targetDoc = null;
		
		try {
			targetImg = IOUtils.toByteArray(mf.getInputStream());
			targetDoc = IOUtils.toByteArray(multDoc.getInputStream());
			System.out.println(mf.getOriginalFilename() + " ------ " + targetImg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(accountVO);

		if (result.hasErrors()) {
			return "newAccount";
		}
		accountService.addAccount(accountVO, targetImg, targetDoc);
		
		return "redirect:/showAccounts";
	}

	@RequestMapping(value = "/showAccounts", method = RequestMethod.GET)
	public ModelAndView getAllAccounts() {
		for (AccountVO accountVO : accountService.showAccounts()) {
			System.out.println(accountVO);
		}
		Map<String, List<AccountVO>> data = new HashMap();
		data.put("accounts", accountService.showAccounts());
		return new ModelAndView("accountList", data);
	}
	
	@RequestMapping(value = "/showPdf/{accno}", method = RequestMethod.GET)
	public ModelAndView getPdf(@PathVariable("accno") String accno) {
        
		int tempAccNo = Integer.valueOf(accno);
		System.out.print(accno);
		Map<String, AccountVO> data = new HashMap();
		data.put("accounts", accountService.getAccount(tempAccNo));
		return new ModelAndView("showPdf", data);
	}
	
	
	@RequestMapping(value = "/showAllPdf", method = RequestMethod.GET)
	public ModelAndView getAllPdf() {
		for (AccountVO accountVO : accountService.showAccounts()) {
			System.out.println(accountVO);
		}
		Map<String, List<AccountVO>> data = new HashMap();
		data.put("accounts", accountService.showAccounts());
		return new ModelAndView("showPdf", data);
	}
}
