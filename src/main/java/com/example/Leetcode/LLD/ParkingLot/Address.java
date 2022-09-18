package com.example.Leetcode.LLD.ParkingLot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
    String street;
    String block;
    String city;
    String state;
    String country;
	public Address(String street, String block, String city, String state, String country) {
		super();
		this.street = street;
		this.block = block;
		this.city = city;
		this.state = state;
		this.country = country;
	}
    
    
}
