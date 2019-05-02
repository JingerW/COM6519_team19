

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

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
	public static final int MYSQL_DUPLICATE_PK = 1062;

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

		int user_id;
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
				String check_username = "SELECT * FROM user WHERE uname='"+username+"';";
				System.out.println(check_username);
				ResultSet rs1 = stmt.executeQuery(check_username);

				if (rs1.next()) {
					String msg = "dulicate username";
					HttpSession session = request.getSession(false);
					session.setAttribute("msg", msg);
					response.sendRedirect("signup.jsp");
					System.out.println("dulicapte username");
				}
				else {
					user_id = generate_random_user_id();
					String insert = "INSERT INTO user (id,uname, upass, uemail) "
							+ "VALUES('"+user_id+"','"+username+"','"+password+"','"+email+"')";
					System.out.println(insert);
					int rs2 = stmt.executeUpdate(insert);

					String query = "SELECT * FROM user WHERE uname = '"+username+"' AND upass = '"+password+"'";
					ResultSet rs3 = stmt.executeQuery(query);

					if (rs3.next()) {
						int balance = rs3.getInt("ubank");
						HttpSession session = request.getSession(true);
						session.setAttribute("userid", user_id);
						session.setAttribute("username", username);
						session.setAttribute("useremail", email);
						session.setAttribute("balance", balance);
						System.out.println("success");
						response.sendRedirect("index.jsp");
					}
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

	private int generate_random_user_id() {
		Random rand = new Random();
		int random_id = rand.nextInt(1000000);
		return random_id;
	}

}
