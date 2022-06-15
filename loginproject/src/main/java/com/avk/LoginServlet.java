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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String u = request.getParameter("uname");
		
		int i = Integer.parseInt(u);
		
		String password = request.getParameter("pwd");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/servlets","root","root");
			
			
			String sql="select * from login where userid=? and password=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, i);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("success.html");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("failure.html");
				rd.forward(request, response);
			}
			
			/*	
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Insert title here</title>");
			out.println("</head>\r\n"
					+ "<body>");
			if(rs.next()) {
				
			out.println("<h1>Thrilled to have logged in!!!!</h1>");
			}
			else {
				out.println("<h1>sorry, login again!!!!</h1>\r\n"
						+ "<a href=\"index.jsp\"/>Click here to login</a>");
			}
			out.println("</body>");
			out.println("</html>");
		*/	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
