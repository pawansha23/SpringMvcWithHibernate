package com.pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.CountryDao;
import com.pack.model.Country;
import com.pack.vo.CountryVO;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDao countryDao;
	
	@Transactional
	public void addCountry(CountryVO countryVO) {
		Country country = new Country();
		BeanUtils.copyProperties(countryVO, country);
		countryDao.addCountry(country);
		
	}

	@Transactional
	public List<CountryVO> getAllCountries() {
		List<CountryVO> countryVOs = null;
		List<Country> countries = countryDao.getAllCountries();
		
		if (countries != null && !countries.isEmpty()) {
			countryVOs = new ArrayList<CountryVO>();
			
			for (Country country : countries) {
				CountryVO countryVO = new CountryVO();
				BeanUtils.copyProperties(country, countryVO);
				countryVOs.add(countryVO);
			}
		}
		return countryVOs;
	}

	@Transactional
	public CountryVO getCountry(int cid) {
		CountryVO countryVO = new CountryVO();
		Country country = countryDao.getCountry(cid);
		BeanUtils.copyProperties(country, countryVO);
		return countryVO;
	}

	@Transactional
	public void changeCountry(CountryVO countryVO) {
		Country country = new Country();
		BeanUtils.copyProperties(countryVO, country);
		countryDao.changeCountry(country);
	}

	@Transactional
	public String deleteCountry(CountryVO countryVO,int cid) {
		Country country = new Country();
		BeanUtils.copyProperties(countryVO, country);
		return countryDao.deleteCountry(country,cid);
		
	}

}
