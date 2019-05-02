

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String username = request.getParameter("loginUsername");
		String password = request.getParameter("loginPassword");
		System.out.println(username+", "+password);
		
		Connection con = MyConnection.connect();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM team19.user WHERE uname = '"+username+"' AND upass = '"+password+"'");
			if (rs.next()) {
				int userid = rs.getInt("id");
				String email = rs.getString("uemail");
				int balance = rs.getInt("ubank");
				HttpSession session = request.getSession(true);
				session.setAttribute("userid", userid);
				session.setAttribute("username", username);
				session.setAttribute("useremail", email);
				session.setAttribute("balance", balance);
				System.out.println("success");
				response.sendRedirect("index.jsp");
			}
			else {
				HttpSession session = request.getSession(false);
				String msg = "wrong password";
				session.setAttribute("msg", msg);
				response.sendRedirect("login.jsp"); 
				System.out.println(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) { stmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
	}

}
