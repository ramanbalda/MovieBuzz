package com.Serv;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.DBhandler.DbHandler;
import com.module.Movie;
import com.module.Seatbooked;
/**
 * Servlet implementation class AddMovie
 */
@WebServlet("/AddMovie")
@javax.servlet.annotation.MultipartConfig(fileSizeThreshold =1024, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class AddMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static final String SAVE_DIR="images";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	private String extractFileName(Part part) {
	      String contentDisp = part.getHeader("content-disposition");
	      String[] items = contentDisp.split(";");
	      for (String s : items) {
	          if (s.trim().startsWith("filename")) {
	              return s.substring(s.indexOf("=") + 2, s.length()-1);
	          }
	      }
	      return "";
	  }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		
		DbHandler db= new DbHandler();
		String  
		TITLE 
		,DESCRIPTION                                                                                
		,SLOT_9TO12=null              
		,SLOT_12TO15=null               
		,SLOT_15TO18=null                
		,SLOT_18TO21=null                
		;
		String LANGUAGE;
		int GOLD_PRIZE = 0;
		int SILVER_PRIZE; 
		int RATING;
		 java.util.Date START_DATE;
		try {
			START_DATE = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Start_Date"));
		
			 java.util.Date END_DATE= new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("End_Date"));
		     java.sql.Date eDate = new java.sql.Date(END_DATE.getTime());
		     java.sql.Date sDate = new java.sql.Date(START_DATE.getTime());
		
	    
		DESCRIPTION=request.getParameter("txtDesc");
		TITLE=request.getParameter("Movie_Name");
		LANGUAGE=request.getParameter("lang");
		RATING=Integer.parseInt(request.getParameter("rate"));
		SLOT_9TO12=request.getParameter("9to12");
		SLOT_12TO15=request.getParameter("12to15");
		SLOT_15TO18=request.getParameter("15to18");
		SLOT_18TO21=request.getParameter("18to21");
SILVER_PRIZE = Integer.parseInt(request.getParameter("SilverSeatPrize"));
Boolean isAdult =Boolean.parseBoolean(request.getParameter("isAdult"));
		GOLD_PRIZE =Integer.parseInt(request.getParameter("GoldPrize"));
		Part image = request.getPart("image");
		  String savePath = getServletContext().getRealPath("/")+File.separator + SAVE_DIR;
		  File fileSaveDir=new File(savePath);
          if(!fileSaveDir.exists()){
          	
              fileSaveDir.mkdir();
          }
          String fileName=extractFileName(image);
          image.write(savePath + File.separator + fileName);
          String filePath= savePath + File.separator + fileName ;
          
          System.out.println(filePath);
          
   
		int movieid=db.getnewId("Movie", "movieid");
	
	
		
		
	Movie mov= new Movie(movieid, TITLE, DESCRIPTION, START_DATE.getYear(), LANGUAGE, RATING, sDate, eDate, SLOT_9TO12, SLOT_12TO15, SLOT_15TO18, SLOT_18TO21, SILVER_PRIZE, GOLD_PRIZE,isAdult,fileName);
	


	db.insertintoMovie(mov);
	
	String 
	GoldSeatsBooked=null
	,SilverSeatsBooked=null
	;
	int GoldAvlSeats=60
	,SlverAvlSeats=60
	,ttlGoldSeats=60
	,ttlSilverSeats=60;
	
	
	List<String> list=new ArrayList<>();
	if(SLOT_9TO12==null) {
		
	}
	else if(SLOT_9TO12.equals("True")) {
		list.add("9to12");
	}
	if(SLOT_12TO15==null) {
		
	}
	else if(SLOT_12TO15.equals("True")) {
		list.add("12to15");
	}
	if(SLOT_15TO18==null) {
		
	}
	else if(SLOT_15TO18.equals("True")){
		list.add("15to18");
	}
	if(SLOT_18TO21==null) {
		
	}
	else if(SLOT_18TO21.equals("True")) {
		list.add("18to21");
	}
	
	long days = getDateDiff(START_DATE, END_DATE, TimeUnit.DAYS);
	int Seatbookedid;
	 Seatbookedid=db.getnewId("Seatbooked", "SeatBookedid");
	
	int j;
	Date DateToShow=sDate;
	for(j=0;j<=days;j++)
		
	{
		for (String SlotsOfShow : list)
		 { 
			Seatbooked stbkd=new Seatbooked(Seatbookedid, mov, ttlSilverSeats, ttlGoldSeats, SilverSeatsBooked, GoldSeatsBooked, DateToShow, SlverAvlSeats, GoldAvlSeats, SlotsOfShow);
			
			db.insertintoSeatbooked(stbkd);
			   Seatbookedid=Seatbookedid+1;
		}
		 DateToShow = addDays(sDate,1);
	       
	} 
	
	
	
	
	
	
	
		 

		
		
		
	response.sendRedirect(request.getContextPath()+"/inputmovie.jsp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static long getDateDiff(java.util.Date START_DATE, java.util.Date END_DATE, TimeUnit timeunit) {
	    {
	        long diffInDate = END_DATE.getTime()-START_DATE.getTime();
	         
	        return timeunit.convert(diffInDate, TimeUnit.MILLISECONDS);
	    }
	} 
	
	public static Date addDays(Date d, int days)
    {
        d.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
        return d;
    }

}
