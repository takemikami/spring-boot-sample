package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {

        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:8080/api/user/1", User.class);

        return "hello: " + user.getName();
    }

}
