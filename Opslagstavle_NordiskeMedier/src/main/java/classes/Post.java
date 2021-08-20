package classes;
import java.time.LocalDateTime;

public class Post {
    private String title;
    private int ID;
    private String author;
    private LocalDateTime created;
    private boolean isNew;
    private LocalDateTime lastSeen;
    private String message;


    public Post(int ID, String title, String name, String message, LocalDateTime created, LocalDateTime lastSeen, boolean isNew) {
    	this.ID = ID;
        this.title = title;
        this.author = name;
        this.message = message;
        this.created = created;
        this.isNew = true;
        this.lastSeen = lastSeen;
        this.isNew = isNew;
    }

    public int getID() {
        return ID;
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }
    
    public void setLastSeen(LocalDateTime value) {
    	this.lastSeen = value;
    }
    
    public String getMessage() {
        return message;
    }

    public boolean isNew() {
        return isNew;
    }
    
    public void setIsNew(boolean value) {
    	this.isNew = value;
    }
}
