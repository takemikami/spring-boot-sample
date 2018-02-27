package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @Autowired
    UserInfo userInfo;
    
    @RequestMapping("/hello")
    public String index(Model model) {
      userInfo.setCount(userInfo.getCount() + 1);
      model.addAttribute("userInfo", userInfo);
      return "hello";
    }

}
