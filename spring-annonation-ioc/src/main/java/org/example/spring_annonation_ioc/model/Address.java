package org.example.spring_annonation_ioc.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
	@Value("${address.addressline1}")
	private String addreLine1;
	@Value("${address.addressline2}")
	private String addressLine2;
	public Address() {
		super();
	}
	public String getAddreLine1() {
		return addreLine1;
	}
	public void setAddreLine1(String addreLine1) {
		this.addreLine1 = addreLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	@Override
	public String toString() {
		return "Address [addreLine1=" + addreLine1 + ", addressLine2=" + addressLine2 + "]";
	}

}
