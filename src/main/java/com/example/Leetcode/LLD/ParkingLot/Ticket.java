package com.example.Leetcode.LLD.ParkingLot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Ticket {
	String ticketNumber;
	long startTime;
	long endTime;
	Vehicle vehicle;
	ParkingSlot parkingSlot;

	public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
		return Ticket.builder().parkingSlot(parkingSlot).startTime(System.currentTimeMillis()).vehicle(vehicle)
				.ticketNumber(vehicle.getVehicleNumber() + System.currentTimeMillis()).build();
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

}