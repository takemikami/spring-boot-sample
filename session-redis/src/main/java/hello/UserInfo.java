package hello;

import org.springframework.stereotype.*;
import org.springframework.context.annotation.*;
import org.springframework.web.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import java.io.Serializable;

@Component
@SessionScope
public class UserInfo implements Serializable {
  String name = null;
  int count = 0;
  
  public String getName() {return this.name;}
  public void setName(String name) {this.name = name;}
  
  public int getCount() {return this.count;}
  public void setCount(int count) {this.count = count;}
}