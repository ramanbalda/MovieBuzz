package com.Serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBhandler.DbHandler;
import com.module.Usertbl;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
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
		DbHandler db= new DbHandler();
		
		
		String Eml=request.getParameter("logemail");
		String Pwd=request.getParameter("logpass");
		
		
	    Boolean b=db.isValidUserByEmailidAndPwd(Eml, Pwd);
		
	
	if(b) {
		Usertbl usr= db.getUserbyEmlandPwd(Eml, Pwd);
		HttpSession ss= request.getSession();
		ss.setAttribute("id", usr.getUserid());
		
		if(usr.getType()==1){
			response.sendRedirect(request.getContextPath()+"/inputmovie.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/allmovies.jsp?id="+usr.getUserid());	
		}
		
		
	}
	else {
		response.sendRedirect(request.getContextPath()+"/ErrorPage");

		
	}
	
		
		
	
	}

}
