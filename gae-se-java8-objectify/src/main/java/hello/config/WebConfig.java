package hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.boot.context.embedded.FilterRegistrationBean;
// import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.servlet.DispatcherType;
import java.util.EnumSet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class WebConfig { // extends WebMvcConfigurerAdapter {

  @Bean
  public FilterRegistrationBean objectifyFilter() {
      FilterRegistrationBean registration = new FilterRegistrationBean();
      // registration.setFilter(new ObjectifyListener());
      registration.setFilter(new com.googlecode.objectify.ObjectifyFilter());
      registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
      registration.addUrlPatterns("/*");
      // registration.setFilter(new ShallowEtagHeaderFilter());
      // registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
      // registration.addUrlPatterns("/cue-categories");
      return registration;
  }

    // @Override
    // public void addViewControllers(ViewControllerRegistry registry) {
    //     registry.addViewController("/").setViewName("home");
    //     registry.addViewController("/login").setViewName("login");
    // }

}