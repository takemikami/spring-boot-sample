package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
      
      // UserRepository
      User u = new User();
      u.firstname = "user,";
      userRepository.save(u);
      
      Iterable<User> users = userRepository.findAll();

      StringBuffer buf = new StringBuffer();
      for(User x : users) {
          buf.append(x.firstname);
      }

      return "Greetings from Spring Boot! to " + buf.toString();
    }

}