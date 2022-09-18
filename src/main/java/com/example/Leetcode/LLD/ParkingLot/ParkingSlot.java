package com.example.Leetcode.LLD.ParkingLot;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ParkingSlot {
	String name;

	boolean isAvailable = true;
	Vehicle vehicle;
	ParkingSlotType parkingSlotType;

	public ParkingSlot(String name, ParkingSlotType parkingSlotType) {
		this.name = name;
		this.parkingSlotType = parkingSlotType;
	}

	protected void addVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.isAvailable = false;
	}

	protected void removeVehicle(Vehicle vehicle) {
		this.vehicle = null;
		this.isAvailable = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSlotType getParkingSlotType() {
		return parkingSlotType;
	}

	public void setParkingSlotType(ParkingSlotType parkingSlotType) {
		this.parkingSlotType = parkingSlotType;
	}

}
