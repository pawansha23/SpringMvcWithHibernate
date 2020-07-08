package com.pack.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class AccountVO {

	@NotNull
	private int accno;

	@NotNull
	@Size(min = 2, max = 7)
	private String accName;

	@NotNull
	private float balance;

	@Min(18)
	@Max(100)
	private int age;

	private MultipartFile image;

	private String dbImage;

	private MultipartFile customerDoc;
	
	private String dbDoc;

	public String getDbDoc() {
		return dbDoc;
	}

	public void setDbDoc(String dbDoc) {
		this.dbDoc = dbDoc;
	}

	public MultipartFile getCustomerDoc() {
		return customerDoc;
	}

	public void setCustomerDoc(MultipartFile customerDoc) {
		this.customerDoc = customerDoc;
	}

	public String getDbImage() {
		return dbImage;
	}

	public void setDbImage(String dbImage) {
		this.dbImage = dbImage;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "AccountVO [accno=" + accno + ", accName=" + accName + ", balance=" + balance + ", age=" + age
				+ ", image=" + image + "]";
	}

}
