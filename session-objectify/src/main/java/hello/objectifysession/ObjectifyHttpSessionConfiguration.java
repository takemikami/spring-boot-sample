package hello.objectifysession;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.MapSession;
import org.springframework.session.config.annotation.web.http.SpringHttpSessionConfiguration;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.util.StringValueResolver;

import com.googlecode.objectify.ObjectifyService;

/**
 * see. org.springframework.session.jdbc.config.annotation.web.http.JdbcHttpSessionConfiguration
 */
@Configuration
@EnableScheduling
public class ObjectifyHttpSessionConfiguration extends SpringHttpSessionConfiguration {

	@Bean
	public ObjectifyOperationsSessionRespository sessionRepository() {
		// ObjectifyService.register(SessionInfo.class);
		ObjectifyOperationsSessionRespository sessionRepository = new ObjectifyOperationsSessionRespository();
		return sessionRepository;
	}

}
