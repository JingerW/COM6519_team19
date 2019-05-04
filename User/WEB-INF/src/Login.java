

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
		String db_local ="team19.user";
		String db_cloud ="user";
		String url;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+", "+password);

		Connection con = MyConnection.connect();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			String query = "SELECT * FROM "+db_cloud+" WHERE uname = '"+username+"' AND upass = '"+password+"'";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				int userid = rs.getInt(1);
				String email = rs.getString("uemail");
				int balance = rs.getInt("ubank");
				System.out.println("ok");
				HttpSession session = request.getSession(true);
				url = (String) session.getAttribute("student");
				session.setAttribute("userid", userid);
				session.setAttribute("username", username);
				session.setAttribute("useremail", email);
				session.setAttribute("balance", balance);
				System.out.println("success");
				System.out.println(url+"/index.jsp");
				response.sendRedirect(url+"/index.jsp");
			}
			else {
				HttpSession session = request.getSession(false);
				String msg = "wrong password or username";
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
