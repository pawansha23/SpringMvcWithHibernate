package com.pack.service;

import java.util.List;

import com.pack.vo.CountryVO;

public interface CountryService {
	public void addCountry(CountryVO countryVO);

	public List<CountryVO> getAllCountries();

	public CountryVO getCountry(int cid);
	
	public void changeCountry(CountryVO countryVO);
	
	public String deleteCountry(CountryVO countryVO,int cid);

}
