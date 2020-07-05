package com.pack.dao;

import java.util.List;

import com.pack.model.Country;

public interface CountryDao {

	public void addCountry(Country country);

	public List<Country> getAllCountries();

	public Country getCountry(int cid);
	
	public void changeCountry(Country country);
	
	public String deleteCountry(Country country,int cid);
}
