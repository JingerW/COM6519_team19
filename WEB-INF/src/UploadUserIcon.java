

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadUserIcon
 */
@WebServlet("/UploadUserIcon")
@MultipartConfig
public class UploadUserIcon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadUserIcon() {
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

		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("userid");
		InputStream input;
		System.out.println("stage 1");

		Part im = request.getPart("userIconUpload");

		if (im != null) {
			System.out.println("stage 2");
			input = im.getInputStream();

			Connection con = MyConnection.connect();
			PreparedStatement stmt = null;
			try {
				String query = "UPDATE user SET uicon=? WHERE id=?";
				stmt = con.prepareStatement(query);

				stmt.setBlob(1, input);
				stmt.setInt(2, user_id);
				System.out.println(stmt);

				int rs = stmt.executeUpdate();
				if (rs >0) {
					System.out.println("success");
					response.sendRedirect("user.jsp");
				}
				else {
					System.out.println("something wrong");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("null image");
		}
	}

}
