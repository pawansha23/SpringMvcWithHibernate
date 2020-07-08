package com.pack.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Documents")
public class Documents {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "docId")
	int docId;
	
	@Column(name = "doc")
	Blob doc;

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public Blob getDoc() {
		return doc;
	}

	public void setDoc(Blob doc) {
		this.doc = doc;
	}
}
