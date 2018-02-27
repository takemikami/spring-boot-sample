package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Key;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
      String count = null;
      UserInfo userInfo;
      
      Key<UserInfo> userInfoKey = Key.create(UserInfo.class, "001");
      userInfo = ObjectifyService.ofy().load().key(userInfoKey).now();

      if (userInfo == null) {
        userInfo = new UserInfo("001", "user", 0);
      }
      userInfo.setCount(userInfo.getCount() + 1);

      ObjectifyService.ofy().save().entity(userInfo).now();
      
      count = "" + userInfo.getCount();
      
      //UserService userService = UserServiceFactory.getUserService();
      //User user = userService.getCurrentUser(); // Find out who the user is.
      
      return "Greetings from Spring Boot!" + count;
    }

}
