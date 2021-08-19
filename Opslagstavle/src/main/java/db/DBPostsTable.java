package db;

import classes.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DBPostsTable {
    private static String query = null;
    private static PreparedStatement st = null;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    public static LinkedList<Post> getPosts(int limit) {
	        LinkedList<Post> posts = new LinkedList<>();

	        try {
	            // Initialize the database
	            Connection con = DBConnection.getConnection();

	            // SQL query
	            query = "SELECT * FROM posts ORDER BY postID";
	            st = con.prepareStatement(query);
	            //st.setInt(1, limit);

	            ResultSet rs = st.executeQuery();

	            // Go through every result in set, create Post object and add it to linked list
	            while (rs.next()) {
	                assert false;
	                Post post = new Post(
	                		rs.getInt("postID"),
	                        rs.getString("author"),
	                        rs.getString("message"),
	                        rs.getString("title"),
	                        LocalDateTime.now(),
	                        LocalDateTime.now()
	                        );
	                posts.add(post);
	            }

	            // Close all connections
	            rs.close();
	            st.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       
	        return posts;
	    }

	
	public static Post createPost(String title, String author, String message) {
        Post post = null;

        try {
            if (title.equals("") || author.equals("") || message.equals(""))
                return null;

            // Initialize the database
            Connection con = DBConnection.getConnection();

            // SQL query
            query = "INSERT INTO posts (title, author, message) values(?, ?, ?)";
            st = con.prepareStatement(query);
            st.setString(1, title);
            st.setString(2, author);
            st.setString(3, message);

            // Execute the insert command using executeUpdate() to make changes in database
            st.executeUpdate();
            
            // Close all the connections
            st.close();
            con.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }

        return post;
    }
}
