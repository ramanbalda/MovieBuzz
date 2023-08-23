package com.Serv;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBhandler.DbHandler;
import com.module.Seatbooked;

/**
 * Servlet implementation class Getseatbooked
 */
@WebServlet("/Getseatbooked")
public class Getseatbooked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getseatbooked() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DbHandler db= new DbHandler();
		 java.util.Date SDATE = null;
	
			try {
				SDATE = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dt"));
				System.out.println(SDATE);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
		  java.sql.Date datel = new java.sql.Date(SDATE.getTime());
		  System.out.println(datel);
		  String tim =request.getParameter("time");
		  String sloat=null;
		  if(tim.equals("9Am")){
		  sloat="9to12";
		  }
		  else if(tim.equals("12Noon")){
		  sloat="12to15";
		  }
		  else if(tim.equals("3Pm")){
		  	sloat="15to18";
		  	}
		  else if(tim.equals("6Pm")){
		  		sloat="18to21";
		  	}
		  
		  HttpSession se=request.getSession(false);
		  int movieid=(int)se.getAttribute("movid");
		 

		  Seatbooked sb=db.getseatbookedbydatesloat(movieid,datel, sloat);
		  
		
		  se.setAttribute("sbid", sb.getSeatBookedid());
		  
			response.sendRedirect(request.getContextPath()+"/Seats.jsp");
		
	}

}
