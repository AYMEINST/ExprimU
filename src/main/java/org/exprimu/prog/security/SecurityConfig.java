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
		.usersByUsernameQuery("SELECT  email_utilisateur as  principal, motdepasse as  credentials ,statue_compte FROM utilisateur WHERE email_utilisateur=?")//user query
		.authoritiesByUsernameQuery("SELECT  u.email_utilisateur as  principal,u.role ,r.id_role , r.libelle_role as role   FROM utilisateur u , roles r   WHERE r.id_role=u.role and u.email_utilisateur=? ")
		.rolePrefix("roleP_") // role  prefix 
		.passwordEncoder(new Md5PasswordEncoder());// role  query
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/css/**","/js/**","/images/**").permitAll()
		.anyRequest().authenticated().and()
		.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/Index/Forum")
		.and()
		.logout().invalidateHttpSession(true).logoutUrl("/logout")
		.permitAll()
		;
	}

}
