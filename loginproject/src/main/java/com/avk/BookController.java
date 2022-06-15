package com.avk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
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
		// TODO Auto-generated method stub
		
		String operation = request.getParameter("operation");
		if(operation.equals("addbook")) {
				String bid = request.getParameter("bookid");
				
				int bookid = Integer.parseInt(bid);
				
				String title = request.getParameter("title");
				
				int price = Integer.parseInt(request.getParameter("price"));
				

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/servlets","root","root");
					
					
					String sql="insert into book values(?,?,?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, bookid);
					pstmt.setString(2, title);
					pstmt.setInt(3, price);
					
					int count= pstmt.executeUpdate();
					if(count > 0) {
						RequestDispatcher rd = request.getRequestDispatcher("addbook_success.html");
						rd.forward(request, response);
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("addbook_failure.html");
						rd.forward(request, response);
					}
					
				
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				
		} else if(operation.equals("deletebook")) {
			String bid = request.getParameter("bookid");
			
			int bookid = Integer.parseInt(bid);
			
		

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/servlets","root","root");
				
				
				String sql="delete from book where bookid=?";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, bookid);
				
				
				int count= pstmt.executeUpdate();
				if(count > 0) {
					RequestDispatcher rd = request.getRequestDispatcher("deletebook_success.html");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("deletebook_failure.html");
					rd.forward(request, response);
				}
				
			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
