package com.Serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBhandler.DbHandler;
import com.module.Movie;

/**
 * Servlet implementation class SaveUrl
 */
@WebServlet("/SaveUrl")
public class SaveUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbHandler dbHandler = new DbHandler();
		int movieID= Integer.parseInt(request.getParameter("movie"));
		String url =request.getParameter("Movie_Url");
		Movie movie=dbHandler.getMoviebyMovieid(movieID);
		movie.setTrailerUrl(url);
		dbHandler.updateMovie(movie);	
		response.sendRedirect(request.getContextPath()+"/AddTrailer.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
