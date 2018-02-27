package hello.config;

import com.googlecode.objectify.ObjectifyService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import hello.UserInfo;
import javax.servlet.annotation.WebListener;

@WebListener
public class ObjectifyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
      ObjectifyService.register(UserInfo.class);
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

}