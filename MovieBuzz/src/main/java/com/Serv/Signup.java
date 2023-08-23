package com.Serv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBhandler.DbHandler;
import com.module.Usertbl;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbHandler db= new DbHandler();
		

		String name=request.getParameter("logname");
		String Eml=request.getParameter("logemail");
		String Pwd=request.getParameter("logpass");
		
		
		int id=db.getnewId("Usertbl", "Userid");
	    List<Usertbl> usertbls=db.getalluser();
	    System.out.println("2");
	    List<Usertbl> usertbllst = new ArrayList<>();
	    
	    for(Usertbl usertbl : usertbls) {
	    	System.out.println("1");
	    	if(Eml.equalsIgnoreCase(usertbl.getEmail())) {
	    		System.out.println("3");
	    		usertbllst.add(usertbl);
	    	}
	    	
	    }
		if(usertbllst.isEmpty()) { 
		
		Usertbl u= new Usertbl(id, name, Pwd, Eml, 2);
		
		db.insertintotbluser(u);
		response.sendRedirect(request.getContextPath()+"/allmovies.jsp?usrid="+id);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/ErrorPage");
	}

}
}
