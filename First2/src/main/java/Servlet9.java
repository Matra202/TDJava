import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/Servlet9")
public class Servlet9 extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String str = request.getParameter("uname");
	String str1 = request.getParameter("pname");
	out.println("<html>");
	out.println("<body>");
	out.println("Username is :" + str + "<br/>");
	out.println("Password is :" + str1);
	out.println("</body>");
	out.println("</html>"); }
	
	    /**
     * Default constructor. 
     */
    public Servlet9() {
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

}
