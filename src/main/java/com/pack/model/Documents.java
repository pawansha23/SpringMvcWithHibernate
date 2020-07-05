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
	private int docId;

	@Column(name = "doc")
	private Blob doc;

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

	@Override
	public String toString() {
		return "Documents [docId=" + docId + ", doc=" + doc + "]";
	}

}
