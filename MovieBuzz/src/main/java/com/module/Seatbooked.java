package com.module;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity(name = "Seatbooked")
public class Seatbooked {
	@Id
	private int SeatBookedid;
    @ManyToOne
	private Movie movieid;
	private int ttlSilverSeats;
	private int ttlGoldSeats;
	private String SilverSeatsBooked;
	private String GoldSeatsBooked;
	private Date DateToShow;
	private int SlverAvlSeats;
	private int GoldAvlSeats;
	private String SlotsOfShow;
	public int getSeatBookedid() {
		return SeatBookedid;
	}
	public void setSeatBookedid(int seatBookedid) {
		SeatBookedid = seatBookedid;
	}


	public Movie getMovieid() {
		return movieid;
	}
	public void setMovieid(Movie movieid) {
		this.movieid = movieid;
	}
	public int getTtlSilverSeats() {
		return ttlSilverSeats;
	}
	public void setTtlSilverSeats(int ttlSilverSeats) {
		this.ttlSilverSeats = ttlSilverSeats;
	}
	public int getTtlGoldSeats() {
		return ttlGoldSeats;
	}
	public void setTtlGoldSeats(int ttlGoldSeats) {
		this.ttlGoldSeats = ttlGoldSeats;
	}
	public String getSilverSeatsBooked() {
		return SilverSeatsBooked;
	}
	public void setSilverSeatsBooked(String silverSeatsBooked) {
		SilverSeatsBooked = silverSeatsBooked;
	}
	public String getGoldSeatsBooked() {
		return GoldSeatsBooked;
	}
	public void setGoldSeatsBooked(String goldSeatsBooked) {
		GoldSeatsBooked = goldSeatsBooked;
	}
	public Date getDateToShow() {
		return DateToShow;
	}
	public void setDateToShow(Date dateToShow) {
		DateToShow = dateToShow;
	}
	public int getSlverAvlSeats() {
		return SlverAvlSeats;
	}
	public void setSlverAvlSeats(int slverAvlSeats) {
		SlverAvlSeats = slverAvlSeats;
	}
	public int getGoldAvlSeats() {
		return GoldAvlSeats;
	}
	public void setGoldAvlSeats(int goldAvlSeats) {
		GoldAvlSeats = goldAvlSeats;
	}
	public String getSlotsOfShow() {
		return SlotsOfShow;
	}
	public void setSlotsOfShow(String slotsOfShow) {
		SlotsOfShow = slotsOfShow;
	}

	@Override
	public String toString() {
		return "Seatbooked [SeatBookedid=" + SeatBookedid + ", movieid=" + movieid + ", ttlSilverSeats="
				+ ttlSilverSeats + ", ttlGoldSeats=" + ttlGoldSeats + ", SilverSeatsBooked=" + SilverSeatsBooked
				+ ", GoldSeatsBooked=" + GoldSeatsBooked + ", DateToShow=" + DateToShow + ", SlverAvlSeats="
				+ SlverAvlSeats + ", GoldAvlSeats=" + GoldAvlSeats + ", SlotsOfShow=" + SlotsOfShow + "]";
	}
	
	public Seatbooked(int seatBookedid, Movie movieid, int ttlSilverSeats, int ttlGoldSeats, String silverSeatsBooked,
			String goldSeatsBooked, Date dateToShow, int slverAvlSeats, int goldAvlSeats, String slotsOfShow) {
		super();
		SeatBookedid = seatBookedid;
		this.movieid = movieid;
		this.ttlSilverSeats = ttlSilverSeats;
		this.ttlGoldSeats = ttlGoldSeats;
		SilverSeatsBooked = silverSeatsBooked;
		GoldSeatsBooked = goldSeatsBooked;
		DateToShow = dateToShow;
		SlverAvlSeats = slverAvlSeats;
		GoldAvlSeats = goldAvlSeats;
		SlotsOfShow = slotsOfShow;
	}
	public Seatbooked() {
		super();
		}
	

	
}
