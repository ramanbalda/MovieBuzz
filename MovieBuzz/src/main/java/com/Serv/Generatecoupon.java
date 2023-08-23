package com.Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBhandler.DbHandler;
import com.module.Coupen;

/**
 * Servlet implementation class Generatecoupon
 */
@WebServlet("/Generatecoupon")
public class Generatecoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generatecoupon() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int percentofdiscount =Integer.valueOf( request.getParameter("discount"));
		
		  String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        StringBuilder sb = new StringBuilder();
	        Random random = new Random();
	        for (int i = 0; i < 6; i++) {
	            int index = random.nextInt(alphabet.length());
	            char randomChar = alphabet.charAt(index);
	            sb.append(randomChar);
	        }
	        String randomCode = sb.toString();
	       PrintWriter out=response.getWriter();
	        
	        out.println("Random code: " + randomCode+" % Of Discount "+percentofdiscount);
	        
	        DbHandler db=new DbHandler();
	        
	        Coupen coupen=new Coupen(randomCode, percentofdiscount);
	        
		db.insertintocopen(coupen);
		
		
	}

}
