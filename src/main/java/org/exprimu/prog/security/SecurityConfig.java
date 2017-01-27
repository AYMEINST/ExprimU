package org.exprimu.prog.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // declaring configuration
@EnableWebSecurity // for activing web secutity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Override // authetification test
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("Admin").password("123456").roles("admin");
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT  email as  principal, password as  credentials ,statue_compte FROM utilisateur WHERE email=?")//user query
		.authoritiesByUsernameQuery("SELECT u.email as principal, r.libelle_role role ,r.id_role FROM role_utilisateur ru JOIN utilisateur u ON u.id_utilisateur = ru.id_utilisateur JOIN roles r ON r.id_role = ru.id_role WHERE u.email=? ")
		.rolePrefix("ROLE_") // role  prefix 
		//.passwordEncoder(new Md5PasswordEncoder())
		;// role  query
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/css/**","/js/**","/images/**","/angular/**").permitAll()
		.anyRequest().authenticated().and()
		.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/Index/Forum")
		.and()
		.logout().invalidateHttpSession(true).logoutUrl("/logout")
		.permitAll()
		;
	}

}
