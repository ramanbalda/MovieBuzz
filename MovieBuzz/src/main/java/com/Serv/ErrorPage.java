package com.Serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorPage
 */
@WebServlet("/ErrorPage")
public class ErrorPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head> <link rel='stylesheet' href='er.css'> <link rel='preconnect' href='https://fonts.googleapis.com'><link rel='preconnect' href='https://fonts.gstatic.com' crossorigin><link href='https://fonts.googleapis.com/css2?family=Rubik+Gemstones&display=swap' rel='stylesheet'><title>Inbox</title></head><body>");
	out.println("<section class='page_404'>");
	out.println("<div class='container'>");
out.println("<div class='row'>");
out.println("<div class='col-sm-12'>");
out.println("<div class='col-sm-10 col-sm-offset-1  text-center'>");
out.println("<div class='four_zero_four_bg'>");
out.println("<h1 class='text-center '>404</h1>");
out.println("</div>");
out.println("<div class='contant_box_404'>");
out.println("<h3 class='h2'>You have entered wrong details</h3>");
out.println("<p>Invalid Username and password</p>");
out.println("<a href='login.jsp' class='link_404'>Go to Home</a>");
out.println("</div></div></div></div></div>");
out.println("</section>");


		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
