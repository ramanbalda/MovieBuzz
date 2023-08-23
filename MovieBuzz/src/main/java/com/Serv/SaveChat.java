package com.Serv;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBhandler.DbHandler;
import com.module.QuestionAns;

/**
 * Servlet implementation class SaveChat
 */
@WebServlet("/SaveChat")
public class SaveChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveChat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession httpSession=request.getSession(false);
		int id=(int) httpSession.getAttribute("id");
		String msg=request.getParameter("message");
		
		DbHandler dbHandler=new DbHandler();

		
		
		QuestionAns ans=new QuestionAns();
		ans.setQnaId(dbHandler.getnewId("questionans", "qnaid"));
		ans.setAdmin(0);
		ans.setMessage(msg);
		ans.setDateTime(LocalDateTime.now());
		ans.setSenderId(id);
		dbHandler.saveintoqna(ans);
		
		response.sendRedirect(request.getContextPath()+"/Chat.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
