

import java.io.IOException;
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
			LinkedList<Post> posts = DBPostsTable.getPosts();
			request.setAttribute("posts", posts); // Store linked list with posts in request scope.
	        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); // Forward to JSP page
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                    String title = request.getParameter("title");
                    String author = request.getParameter("author");
                    String message = request.getParameter("message");
                    
                    DBPostsTable.createPost(title, author, message);
                    response.sendRedirect("OpslagstavleServlet");
            }
	}

