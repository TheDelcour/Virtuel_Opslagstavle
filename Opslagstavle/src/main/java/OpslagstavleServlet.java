

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import classes.Post;
import db.DBPostsTable;

/**
 * Servlet implementation class OpslagstavleServlet
 */
public class OpslagstavleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBPostsTable DBposts = new DBPostsTable();
    /**
     * Default constructor. 
     */
    public OpslagstavleServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			LinkedList<Post> posts = DBPostsTable.getPosts(255);
			request.setAttribute("posts", posts); // Store linked list with posts in request scope.
	        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); // Forward to JSP page
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    // Get all params from request
                    String title = request.getParameter("title");
                    String author = request.getParameter("author");
                    String message = request.getParameter("message");
                    
                    // Create post
                    DBPostsTable.createPost(title, author, message);
                    //response(response, "Opslag slået op!");
                    response.sendRedirect("OpslagstavleServlet");
            }
         
	
		private void response(HttpServletResponse resp, String msg) throws IOException {
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<t1>" + msg + "</t1>");
			out.println("</body>");
			out.println("</html>");
		}
	
	}

