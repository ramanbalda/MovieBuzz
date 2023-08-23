package com.Serv;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet("/UploadImage")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static final String SAVE_DIR="images";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImage() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	      
		//  PrintWriter out=response.getWriter();
        String savePath = getServletContext().getRealPath("/")+File.separator + SAVE_DIR;
        System.out.println("33--------------------------- "+ savePath);
        	      	        	       

                File fileSaveDir=new File(savePath);
                if(!fileSaveDir.exists()){
                	
                    fileSaveDir.mkdir();
                }
          
            Part part=request.getPart("file");
            String fileName=extractFileName(part);
            part.write(savePath + File.separator + fileName);
                String filePath= savePath + File.separator + fileName ;
		
                
                System.out.println("file name is "+ fileName);
               HttpSession ssn=request.getSession();
                ssn.setAttribute("image", fileName);
		System.out.println("file path = "+filePath);
				System.out.println("image uploaded");		

		
		
		
		
	}

}
