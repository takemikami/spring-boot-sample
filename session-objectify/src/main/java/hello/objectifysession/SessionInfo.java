package hello.objectifysession;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
public class SessionInfo {

    @Id
    String id = null;
    String primaryKey = null;
    Long creationTime;
    Long lastAccessedTime;
    int maxInactiveInterval;
    public Map<String, String> attributes = new HashMap<String, String>();

    public SessionInfo() {}
    public SessionInfo(String id) {
        this.id = id;
    }

    public String getId() {return this.id;}
    public void setId(String id) {this.id = id;}

    public String getPrimaryKey() { return this.primaryKey; }
    public void setPrimaryKey(String primaryKey) { this.primaryKey = primaryKey; }

    public Long getCreationTime() { return this.creationTime; }
    public void setCreationTime(Long creationTime) { this.creationTime = creationTime; }

    public Long getLastAccessedTime() { return this.lastAccessedTime; }
    public void setLastAccessedTime(Long lastAccessedTime) { this.lastAccessedTime = lastAccessedTime; }

    public int getMaxInactiveInterval() { return this.maxInactiveInterval; }
    public void setMaxInactiveInterval(int maxInactivateInterval) { this.maxInactiveInterval = maxInactiveInterval; }

}

