package com.pack.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.model.Country;

@Repository
public class CountryDaoImpl implements CountryDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void addCountry(Country country) {
		System.out.println(country);
		sessionFactory.getCurrentSession().save(country);
		
	}


	public List<Country> getAllCountries() {
		return sessionFactory.getCurrentSession().createCriteria(Country.class).list();

	}

	@Override
	public Country getCountry(int cid) {
		return (Country) sessionFactory.getCurrentSession().get(Country.class, cid);
	}


	
	public void changeCountry(Country country) {
            sessionFactory.getCurrentSession().saveOrUpdate(country);	
	}


	@Override
	public String deleteCountry(Country country,int cid) {
		sessionFactory.getCurrentSession().delete(country);
		return null;
		
	}



}
