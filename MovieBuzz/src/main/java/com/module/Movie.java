package com.module;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Movie")
public class Movie {

    @Id
    private int movieid;
    private String moviename;
    private String Descrip;
    private int ReleaseYear;
    private String AvlLang;
    private int rating;
    private Date START_DATE;
    private Date END_DATE;
    private String slot9to12;
    private String slot12to15;
    private String slot15to18;
    private String slot18to21;
    private int SILVER_PRIZE;
    private int Gold_PRIZE;
    private boolean isAdultMovie;
    private String trailerUrl;
    private String imagePath;



	public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String desc) {
        Descrip = desc;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    public String getAvlLang() {
        return AvlLang;
    }

    public void setAvlLang(String avlLang) {
        AvlLang = avlLang;
    }

    public boolean isAdultMovie() {
        return isAdultMovie;
    }

    public void setAdultMovie(boolean adultMovie) {
        isAdultMovie = adultMovie;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(Date sTART_DATE) {
        START_DATE = sTART_DATE;
    }

    public Date getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(Date eND_DATE) {
        END_DATE = eND_DATE;
    }

    public String getSlot9to12() {
        return slot9to12;
    }

    public void setSlot9to12(String slot9to12) {
        this.slot9to12 = slot9to12;
    }

    public String getSlot12to15() {
        return slot12to15;
    }

    public void setSlot12to15(String slot12to15) {
        this.slot12to15 = slot12to15;
    }

    public String getSlot15to18() {
        return slot15to18;
    }

    public void setSlot15to18(String slot15to18) {
        this.slot15to18 = slot15to18;
    }

    public String getSlot18to21() {
        return slot18to21;
    }

    public void setSlot18to21(String slot18to21) {
        this.slot18to21 = slot18to21;
    }

    public int getSILVER_PRIZE() {
        return SILVER_PRIZE;
    }

    public void setSILVER_PRIZE(int sILVER_PRIZE) {
        SILVER_PRIZE = sILVER_PRIZE;
    }

    public int getGold_PRIZE() {
        return Gold_PRIZE;
    }

    public void setGold_PRIZE(int gold_PRIZE) {
        Gold_PRIZE = gold_PRIZE;
    }

    public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public Movie() {
        super();
    }
	

	public Movie(int movieid, String moviename, String descrip, int releaseYear, String avlLang, int rating, Date sTART_DATE,
                 Date eND_DATE, String slot9to12, String slot12to15, String slot15to18, String slot18to21, int sILVER_PRIZE,
                 int gold_PRIZE) {
        super();
        this.movieid = movieid;
        this.moviename = moviename;
        Descrip = descrip;
        ReleaseYear = releaseYear;
        AvlLang = avlLang;
        this.rating = rating;
        START_DATE = sTART_DATE;
        END_DATE = eND_DATE;
        this.slot9to12 = slot9to12;
        this.slot12to15 = slot12to15;
        this.slot15to18 = slot15to18;
        this.slot18to21 = slot18to21;
        SILVER_PRIZE = sILVER_PRIZE;
        Gold_PRIZE = gold_PRIZE;
    }
    

    public Movie(int movieid, String moviename, String descrip, int releaseYear, String avlLang, int rating,
			Date sTART_DATE, Date eND_DATE, String slot9to12, String slot12to15, String slot15to18, String slot18to21,
			int sILVER_PRIZE, int gold_PRIZE, boolean isAdultMovie) {
		super();
		this.movieid = movieid;
		this.moviename = moviename;
		Descrip = descrip;
		ReleaseYear = releaseYear;
		AvlLang = avlLang;
		this.rating = rating;
		START_DATE = sTART_DATE;
		END_DATE = eND_DATE;
		this.slot9to12 = slot9to12;
		this.slot12to15 = slot12to15;
		this.slot15to18 = slot15to18;
		this.slot18to21 = slot18to21;
		SILVER_PRIZE = sILVER_PRIZE;
		Gold_PRIZE = gold_PRIZE;
		this.isAdultMovie = isAdultMovie;
	}



	public Movie(int movieid, String moviename, String descrip, int releaseYear, String avlLang, int rating,
			Date sTART_DATE, Date eND_DATE, String slot9to12, String slot12to15, String slot15to18, String slot18to21,
			int sILVER_PRIZE, int gold_PRIZE, boolean isAdultMovie, String imagePath) {
		super();
		this.movieid = movieid;
		this.moviename = moviename;
		Descrip = descrip;
		ReleaseYear = releaseYear;
		AvlLang = avlLang;
		this.rating = rating;
		START_DATE = sTART_DATE;
		END_DATE = eND_DATE;
		this.slot9to12 = slot9to12;
		this.slot12to15 = slot12to15;
		this.slot15to18 = slot15to18;
		this.slot18to21 = slot18to21;
		SILVER_PRIZE = sILVER_PRIZE;
		Gold_PRIZE = gold_PRIZE;
		this.isAdultMovie = isAdultMovie;
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", moviename=" + moviename + ", Descrip=" + Descrip + ", ReleaseYear="
				+ ReleaseYear + ", AvlLang=" + AvlLang + ", rating=" + rating + ", START_DATE=" + START_DATE
				+ ", END_DATE=" + END_DATE + ", slot9to12=" + slot9to12 + ", slot12to15=" + slot12to15 + ", slot15to18="
				+ slot15to18 + ", slot18to21=" + slot18to21 + ", SILVER_PRIZE=" + SILVER_PRIZE + ", Gold_PRIZE="
				+ Gold_PRIZE + ", isAdultMovie=" + isAdultMovie + ", trailerUrl=" + trailerUrl + ", imagePath="
				+ imagePath + "]";
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	

}
