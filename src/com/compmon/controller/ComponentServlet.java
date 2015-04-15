package com.compmon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.compmon.daoimpl.ComponentDaoImpl;
import com.compmon.model.Component;

/**
 * Servlet implementation class ComponentServlet
 */
public class ComponentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	PrintWriter out = null;
	HttpSession session;
	
    public ComponentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("component servlet called...");
		System.out.println("tenant : " 	+ request.getParameter("tenant"));
		System.out.println("env: " 		+ request.getParameter("environment"));
		System.out.println("app: " 		+ request.getParameter("application"));
		
		out = response.getWriter();
		String tenant  		= request.getParameter("tenant");
		String environment 	= request.getParameter("environment");
		String application 	= request.getParameter("application");
		/*String box			= request.getParameter("box");
		String instance		= request.getParameter("instance");*/
		
	   /* Get the details and store in session... */
		ComponentDaoImpl obj = new ComponentDaoImpl();
		ArrayList<Component> allComponents = new ArrayList<Component>();
		allComponents = obj.getAllComponentsByFilter(tenant, environment, application);
		
		session = request.getSession();
		session.setAttribute("ComponentsByFilter", allComponents);
		dispatcher = request.getRequestDispatcher("/compfilter.jsp");
    	dispatcher.forward(request, response);
    	
	}

}
