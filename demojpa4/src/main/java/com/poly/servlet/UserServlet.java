package com.poly.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.jasper.compiler.NewlineReductionServletWriter;
import org.apache.taglibs.standard.lang.jstl.DivideOperator;

import com.poly.dao.DaoUserss;
import com.poly.model.Userss;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/UserServlet/create", "/UserServlet/update", "/UserServlet/delete", "/UserServlet/reset",
		"/UserServlet/edit" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		Userss userss = null;
		if (url.contains("delete")) {
			delete(request, response);
            userss = new Userss();
            request.setAttribute("userss", userss);
		} else if (url.contains("edit")) {
           edit(request, response);
		} else if (url.contains("reset")) {
			 userss = new Userss();
	         request.setAttribute("userss", userss);
		}
	findAll(request, response);
	count(request, response);
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if (url.contains("create")) {
			insert(request, response);
		} else if (url.contains("delete")) {
            delete(request, response);
            request.setAttribute("userss",new Userss());
		} else if (url.contains("update")) {
             update(request, response);
		}  else if (url.contains("reset")) {
			Userss userss = new Userss();
	         request.setAttribute("userss", userss);
		}
		findAll(request, response);
		count(request, response);
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Userss userss = new Userss();
			BeanUtils.populate(userss, request.getParameterMap());

			DaoUserss daoUserss = new DaoUserss();
			daoUserss.insertUser(userss);
			request.setAttribute("message", "User inserted!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Userss userss = new Userss();
			BeanUtils.populate(userss, request.getParameterMap());

			DaoUserss daoUserss = new DaoUserss();
			daoUserss.updatetUser(userss);
			request.setAttribute("user", userss);
			request.setAttribute("message", "User inserted!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userid = request.getParameter("userid");
			DaoUserss daoUserss = new DaoUserss();
			Userss userss = daoUserss.findByIdUser(userid);
			
			request.setAttribute("user", userss);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DaoUserss daoUserss = new DaoUserss();
			List<Userss> list = daoUserss.findAll();
			
			request.setAttribute("List_User", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userid = request.getParameter("userid");
			DaoUserss daoUserss = new DaoUserss();
			daoUserss.deleteUser(userid);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	protected void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			DaoUserss daoUserss = new DaoUserss();
			int number = daoUserss.count();
			request.setAttribute("Count", number);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

}
