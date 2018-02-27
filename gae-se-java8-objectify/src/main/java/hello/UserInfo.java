package hello;

// import org.springframework.stereotype.*;
// import org.springframework.context.annotation.*;
// import org.springframework.web.context.annotation.*;
// import org.springframework.web.context.WebApplicationContext;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import java.io.Serializable;

@Entity
public class UserInfo implements Serializable {
  @Id
  String id = null;
  String name = null;
  int count = 0;
  
  public UserInfo() {}
  public UserInfo(String id, String name, int count) {
    this.id = id;
    this.name = name;
    this.count = count;
  }

  public String getId() {return this.id;}
  public void setId(String id) {this.id = id;}
  
  public String getName() {return this.name;}
  public void setName(String name) {this.name = name;}
  
  public int getCount() {return this.count;}
  public void setCount(int count) {this.count = count;}
}