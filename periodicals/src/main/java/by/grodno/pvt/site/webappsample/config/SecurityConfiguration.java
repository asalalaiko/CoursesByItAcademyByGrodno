package by.grodno.pvt.site.webappsample.config;

import by.grodno.pvt.site.webappsample.repo.UserRepo;
import by.grodno.pvt.site.webappsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	@Autowired
	private UserService userService;



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/", "/home", "/register", "/register/**", "/activate/**", "/webjars/**").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/")
			.and()
		.logout()
			.permitAll();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder noop() {
		return NoOpPasswordEncoder.getInstance();
	}
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//				User.withDefaultPasswordEncoder()
//						.username("a")
//						.password("a")
//						.roles("ADMIN")
//						.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}

	
}
