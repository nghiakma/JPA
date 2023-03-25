package com.poly.servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.poly.dao.DaoUserss;
import com.poly.model.Userss;

/**
 * Servlet implementation class InsertUserServlet
 */
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Userss entity = new Userss();
	           entity.setUserid("ccccc");
			   entity.setPassword("nghiahien");
			   entity.setFullname("tran nghiahien");
			   entity.setEmail("anhtaauhien@gmail.com");
			   entity.setAdmin(true);
			   
			   DaoUserss daoUserss = new DaoUserss();
			   daoUserss.insertUser(entity);
			   response.getWriter().println("<h1>User saved!<!h1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
