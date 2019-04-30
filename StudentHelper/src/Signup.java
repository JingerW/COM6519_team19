

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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
		doGet(request, response);
		
		String username = request.getParameter("signupUsername");
		String email = request.getParameter("signupEmailAddress");
		String password = request.getParameter("signupPassword");
		String passconfirm = request.getParameter("signupPasswordConfirm");
		System.out.println(username+","+email+","+password+","+passconfirm);
		
		if (!password.equals(passconfirm)) {
			String msg = "password confirmation failed";
			HttpSession session = request.getSession(false);
			session.setAttribute("msg", msg);
			response.sendRedirect("signup.jsp");
			System.out.println("send back alert");
			}
		else {
			
			Connection con = MyConnection.connect();
			Statement stmt = null;

			try {
				stmt = con.createStatement();
				String query = "insert into team19.user(uname, upass, uemail) "
						+ "values('"+username+"','"+password+"','"+email+"')";
				System.out.println(query);
				int rs = stmt.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (stmt != null) { stmt.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			System.out.println("success");
			response.sendRedirect("index.jsp");
		}
		
	}

}
