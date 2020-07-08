package com.pack.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_tbNew")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Acc_no")

	private int accno;

	@Column(name = "Acc_name")

	private String accName;

	@Column(name = "Balance")
	private float balance;

	@Column(name = "Age")
	private int age;

	@Column(name = "Profile_Pic")
	private Blob image;

	@Column(name = "Customer_Doc")
	private Blob customerDoc;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public Blob getCustomerDoc() {
		return customerDoc;
	}

	public void setCustomerDoc(Blob customerDoc) {
		this.customerDoc = customerDoc;
	}

	@Override
	public String toString() {
		return "Account [accno=" + accno + ", accName=" + accName + ", balance=" + balance + ", age=" + age + ", image="
				+ "]";
	}

}
