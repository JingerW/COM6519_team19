

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
 * Servlet implementation class Topup
 */
@WebServlet("/Topup")
public class Topup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Topup() {
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
		int topupAmount = Integer.valueOf(request.getParameter("topupamount"));
		HttpSession session = request.getSession(false);
		int userid = (int) session.getAttribute("userid");
		int balance = (int) session.getAttribute("balance");
		int newBalance = balance + topupAmount;
		
		Connection con = MyConnection.connect();
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
			String query = "update team19.user set ubank = "+newBalance+" where id = '"+userid+"'";
			System.out.println(query);
			int rs = stmt.executeUpdate(query);
			session.setAttribute("balance", newBalance);
			response.sendRedirect("user.jsp");
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
