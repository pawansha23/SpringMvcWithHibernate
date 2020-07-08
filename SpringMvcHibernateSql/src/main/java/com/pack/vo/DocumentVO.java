package com.pack.vo;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class DocumentVO {

	private int docId;

	@NotNull
	private String docContent;

	@NotNull
	private String docName;

	private String dbDoc;

	public String getDbDoc() {
		return dbDoc;
	}

	public void setDbDoc(String dbDoc) {
		this.dbDoc = dbDoc;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}



	public String getDocContent() {
		return docContent;
	}

	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}

	@Override
	public String toString() {
		return "DocumentVO [docId=" + docId + ", docContent=" + docContent + ", docName=" + docName + ", dbDoc=" + dbDoc
				+ "]";
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}
}
