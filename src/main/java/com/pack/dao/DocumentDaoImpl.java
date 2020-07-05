package com.pack.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.model.Documents;

@Repository
public class DocumentDaoImpl implements DocumentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPdf(Documents documents) {
		sessionFactory.getCurrentSession().save(documents);
	}

}
