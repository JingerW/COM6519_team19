

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
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		String oldpass = request.getParameter("oldpassword");
		String newpass = request.getParameter("newpassword");
		String newpassCon = request.getParameter("newpasswordConfirm");


		if (!newpass.equals(newpassCon)) {
			String msg = "new password confirmation failed";
			HttpSession session = request.getSession(false);
			session.setAttribute("msg", msg);
			response.sendRedirect("change_password.jsp");
			System.out.println("confirmation failed");
		}
		else {

			Connection con = MyConnection.connect();
			Statement stmt = null;
			HttpSession session = request.getSession(false);
			int userid = (int) session.getAttribute("userid");

			try {
				stmt = con.createStatement();
				String check_oldpassword = "SELECT EXISTS(SELECT * FROM user WHERE upass='"+oldpass+"' AND id = '"+userid+"');";
				System.out.println(check_oldpassword);
				ResultSet rs1 = stmt.executeQuery(check_oldpassword);

				if (rs1.next() == false) {
					String msg = "wrong password";
					session.setAttribute("msg", msg);
					response.sendRedirect("change_password.jsp");
					System.out.println("wrong password");
				}
				else {
					String insert = "update user set upass = '"+newpass+"' where id = '"+userid+"'";
					System.out.println(insert);
					int rs2 = stmt.executeUpdate(insert);

					System.out.println("success");
					response.sendRedirect("user.jsp");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (stmt != null) { stmt.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
