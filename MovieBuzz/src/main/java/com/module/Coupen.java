package com.module;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupen {
	
	@Id
	private String coupencode;
	
	private int discountpercentage;

	public String getCoupencode() {
		return coupencode;
	}

	public void setCoupencode(String coupencode) {
		this.coupencode = coupencode;
	}

	public int getDiscountpercentage() {
		return discountpercentage;
	}

	public void setDiscountpercentage(int discountpercentage) {
		this.discountpercentage = discountpercentage;
	}

	public Coupen(String coupencode, int discountpercentage) {
		super();
		this.coupencode = coupencode;
		this.discountpercentage = discountpercentage;
	}

	public Coupen() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Coupen [coupencode=" + coupencode + ", discountpercentage=" + discountpercentage + "]";
	}
	
	
	
}
