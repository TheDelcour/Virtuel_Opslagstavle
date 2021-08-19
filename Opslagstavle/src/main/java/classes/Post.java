package classes;
import java.time.LocalDateTime;

public class Post {
    private final String title;
    private final int ID;
    private final String author;
    private final LocalDateTime created;
    private final LocalDateTime lastSeen;
    private final LocalDateTime currentTime;
    private final String message;
    private final boolean isNew;


    public Post(int ID, String title, String name, String message, LocalDateTime created,
                LocalDateTime lastSeen) {
    	this.ID = ID;
        this.title = title;
        this.author = name;
        this.message = message;
        this.created = created;
        this.lastSeen = lastSeen;
        this.currentTime = java.time.LocalDateTime.now();
        this.isNew = currentTime.isAfter(lastSeen);
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

    public String getMessage() {
        return message;
    }

    public boolean isNew() {
        return isNew;
    }
}
