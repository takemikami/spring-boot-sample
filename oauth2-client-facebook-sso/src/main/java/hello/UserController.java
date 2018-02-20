package hello;

import java.security.Principal;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserController {

    @RequestMapping("/user")
    public Principal user(Principal principal) {
      return principal;
    }

}