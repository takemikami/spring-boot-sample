package hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.DispatcherType;
import java.util.EnumSet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class WebConfig {

  @Bean
  public FilterRegistrationBean objectifyFilter() {
      FilterRegistrationBean registration = new FilterRegistrationBean();
      registration.setFilter(new com.googlecode.objectify.ObjectifyFilter());
      registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
      registration.addUrlPatterns("/*");
      return registration;
  }

}