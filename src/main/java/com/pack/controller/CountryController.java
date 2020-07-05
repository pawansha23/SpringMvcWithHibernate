package com.pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pack.exc.MyException;
import com.pack.service.CountryService;
import com.pack.vo.CountryVO;

@Controller
public class CountryController {
	
	@InitBinder
	public void init(WebDataBinder binder) {
		System.out.println("init data !!!");
		//binder.setDisallowedFields(new String[] { "cname" });
	}
	
	@Autowired
	private CountryService countryService;

	@ModelAttribute("countryVO")
	public CountryVO loadEmptyModelBean() {
		return new CountryVO();
	}

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public ModelAndView loadCountryPage() {
		return new ModelAndView("country");
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCountry(@Valid @ModelAttribute(value = "countryVO")  CountryVO countryVO, BindingResult result) {
		System.out.println(countryVO);
		
		if (result.hasErrors()) {
			System.out.println("Testing!!");
			return "ErrorPage";
		}
		System.out.println("testing1");
		if (countryVO.getCname() == null || "".equals(countryVO.getCname()))
//			return "ErrorPage";
//			throw new NullPointerException("----NPE----");
		countryService.addCountry(countryVO);
		return "redirect:/getAllCountries";
	}

	@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET)
	public ModelAndView getAllCountries() {
		for (CountryVO countryVO : countryService.getAllCountries()) {
			System.out.println(countryVO);
		}
		Map<String, List<CountryVO>> data = new HashMap();
		data.put("countries", countryService.getAllCountries());
		return new ModelAndView("countryList", data);
	}

	

	@RequestMapping(value = "getCountryForm")
	public String getCountryForm() {
		return "getCountryForm";
	}
	
	@RequestMapping(value = "/getCountry", method = RequestMethod.GET)
	 @ExceptionHandler(value = MyException.class)
	public ModelAndView getCountry(@RequestParam("cid") int cid) {
		if (cid ==0)
			throw new MyException("planet id can't be zero");
				
		ModelAndView modelAndView = new ModelAndView("viewCountryDetails");
		modelAndView.addObject("country", countryService.getCountry(cid));
		System.out.println(countryService.getCountry(cid));
		return modelAndView;
	}
	
	@RequestMapping(value = "/changeCountry", method = RequestMethod.GET)
	public ModelAndView changeCountryPage() {
		return new ModelAndView("changeCountry");
	}

	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public String changeCountry(@ModelAttribute(value = "countryVO") CountryVO countryVO, BindingResult result) {
		System.out.println(countryVO);
		countryService.changeCountry(countryVO);
		return "redirect:/getAllCountries";
	}
	
	@RequestMapping(value = "/deleteCountry", method = RequestMethod.GET)
	public ModelAndView deleteCountryPage() {
		return new ModelAndView("deleteCountry");
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteCountry(@RequestParam("cid") int cid, CountryVO countryVO) {
		ModelAndView modelAndView = new ModelAndView("deleteCountry");
		 countryService.deleteCountry(countryVO,cid);
	
		return "redirect:/getAllCountries";
	}
	@ExceptionHandler(value = NullPointerException.class)
	public String npeHandler() {
		return "npePage";
	}
	
	 @ExceptionHandler(value = MyException.class)
		 public String meHandler() {
		 return "cexp";
		 }

}
