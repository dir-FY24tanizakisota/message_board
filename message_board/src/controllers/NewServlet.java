package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import utils.DBUtil;


@WebServlet("/new")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    //CSRF対策
	    request.setAttribute("token", request.getSession().getId());
	   
	    //おまじないとしてのインスタンスを生成
	    request.setAttribute("message", new Message());
	    
	    var rd = request.getRequestDispatcher("/WEB-INF/views/messages/new.jsp");
	    rd.forward(request, response);
	}
}