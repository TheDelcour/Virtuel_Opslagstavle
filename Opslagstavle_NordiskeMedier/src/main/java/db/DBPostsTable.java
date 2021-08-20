package db;

import classes.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class DBPostsTable {
    private static String query = null;
    private static PreparedStatement st = null;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    public static LinkedList<Post> getPosts() {
	        LinkedList<Post> posts = new LinkedList<>();

	        try {
	            // Initialize the database
	            Connection con = DBConnection.getConnection();

	            // SQL query
	            query = "SELECT * FROM posts ORDER BY postID";
	            st = con.prepareStatement(query);

	            ResultSet rs = st.executeQuery();

	            // Go through every result in set, create a post object and add it to linked list
	            while (rs.next()) {
	                assert false;
	                Post post = new Post(
	                		rs.getInt("postID"),
	                        rs.getString("author"),
	                        rs.getString("message"),
	                        rs.getString("title"),
	                        LocalDateTime.parse(rs.getString("created"), formatter),
	                        LocalDateTime.parse(rs.getString("lastseen"), formatter),
	                        rs.getBoolean("isnew")
	                        );
	                
	                if(post.isNew() == true && LocalDateTime.now().isAfter(post.getLastSeen())){
	                	// SQL query for updating database 
		                query = "UPDATE posts SET lastseen = ?, isnew = ? WHERE postID = ?";
		                st = con.prepareStatement(query);
		                st.setString(1, formatter.format(LocalDateTime.now()));
		                st.setBoolean(2, false);
		                st.setInt(3, post.getID());		                		                
		                st.executeUpdate();
	                }

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

            // SQL query for inserting into database
            query = "INSERT INTO posts (title, author, message, created, lastseen, isnew) values(?, ?, ?, ?, ?, ? )";
            st = con.prepareStatement(query);
            st.setString(1, title);
            st.setString(2, author);
            st.setString(3, message);
            st.setString(4, formatter.format(LocalDateTime.now()));
            st.setString(5, formatter.format(LocalDateTime.now()));
            st.setBoolean(6, true);
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
