package com.module;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Ticket")
public class Ticket {

	@Id
	private int Ticketid;
	@ManyToOne
	private Seatbooked seatbookedid;
	@ManyToOne
	private Usertbl usrid;
	private String SilverSeat;
	private String GoldSeat;
	private int TotalPrize;
	public int getTicketid() {
		return Ticketid;
	}
	public void setTicketid(int ticketid) {
		Ticketid = ticketid;
	}
	public Seatbooked getSeatbookedid() {
		return seatbookedid;
	}
	public void setSeatbookedid(Seatbooked seatbookedid) {
		this.seatbookedid = seatbookedid;
	}
	public Usertbl getUsrid() {
		return usrid;
	}
	public void setUsrid(Usertbl usrid) {
		this.usrid = usrid;
	}
	public String getSilverSeat() {
		return SilverSeat;
	}
	public void setSilverSeat(String silverSeat) {
		SilverSeat = silverSeat;
	}
	public String getGoldSeat() {
		return GoldSeat;
	}
	public void setGoldSeat(String goldSeat) {
		GoldSeat = goldSeat;
	}
	public int getTotalPrize() {
		return TotalPrize;
	}
	public void setTotalPrize(int totalPrize) {
		TotalPrize = totalPrize;
	}
	@Override
	public String toString() {
		return "Ticket [Ticketid=" + Ticketid + ", seatbookedid=" + seatbookedid.getSeatBookedid() + ", usrid=" + usrid.getUserid() + ", SilverSeat="
				+ SilverSeat + ", GoldSeat=" + GoldSeat + ", TotalPrize=" + TotalPrize + "]";
	}
	public Ticket(int ticketid, Seatbooked seatbookedid, Usertbl usrid, String silverSeat, String goldSeat,
			int totalPrize) {
		super();
		Ticketid = ticketid;
		this.seatbookedid = seatbookedid;
		this.usrid = usrid;
		SilverSeat = silverSeat;
		GoldSeat = goldSeat;
		TotalPrize = totalPrize;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
