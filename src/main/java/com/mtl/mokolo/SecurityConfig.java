package com.mtl.mokolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.mtl.mokolo.jwt.MktJwtUsernamePasswordAuthentificationFilter;
import com.mtl.mokolo.security.MklPermissions;
import com.mtl.mokolo.security.MklRoles;
import com.mtl.mokolo.security.MklUserDetails;
import com.mtl.mokolo.security.MklUserDetailsServices;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PasswordEncoder passwordEncoder ; 
	private final MklUserDetailsServices mklUserDetailServices;
	
	
public SecurityConfig(PasswordEncoder passwordEncoder, MklUserDetailsServices mklUserDetailServices) {
		this.passwordEncoder = passwordEncoder;
		this.mklUserDetailServices = mklUserDetailServices;
	}



//	@Autowired
//	public void globalConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder){
//		try {
//			authenticationManagerBuilder.inMemoryAuthentication()
//										//.passwordEncoder(passwordEncoder)
//										.withUser("admin")
//										.password(passwordEncoder.encode("123"))
//										.roles("ADMIN");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	/*@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		// 1ere Méthode de création sans prendre en compte les permissions
		UserDetails adminF = User
				.builder()
				.username("adminF")
				.password(passwordEncoder.encode("123"))
				.authorities(MklRoles.ADMIN.getGrantedAutorities())
				.build() ; 
		
		
		UserDetails client = User.builder()
				.username("clientF")
				.password(passwordEncoder.encode("123"))
				//.roles(MklRoles.CLIENT.name())
				.authorities(MklRoles.CLIENT.getGrantedAutorities())
				.build() ;
		
		// Methode 2 en se basant sur les permissions
		UserDetails user1 = User.builder()
								.username("user1")
								.password(passwordEncoder.encode("123"))
								.authorities(MklRoles.CLIENT.getGrantedAutorities())
								.build();
		//user2 est admin et student 
		UserDetails user2 = User.builder()
				.username("user2")
				.password(passwordEncoder.encode("123"))
				.authorities(MklRoles.ADMIN.getGrantedAutorities())
				.build();
		
		
		return new InMemoryUserDetailsManager(adminF, client, user1, user2);
	}
	*/
	@Override
	public void configure(HttpSecurity http) throws Exception  {
		//Methode 0 sans role
		http
		/**
		 * 
		.csrf().disable()
		.and()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic() ;
 * 
 */

/**	Methode1 juste à partir des roles
 
 		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/references/**").hasRole(MklRoles.ADMIN.name())
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic() ;
*/
		
		/**
		 Methode 2 avec les permissions
		 .authorizeRequests()
		 ***remplacer ça par preauthrize
		.antMatchers("/references/**").hasRole(MklRoles.ADMIN.name())
		.antMatchers(HttpMethod.DELETE,"/user/**").hasAuthority(MklPermissions.PERSON_WRITE.getPermission())
		.antMatchers(HttpMethod.POST,"/user/**").hasAuthority(MklPermissions.PERSON_WRITE.getPermission())
		.antMatchers(HttpMethod.PUT,"/user/**").hasAuthority(MklPermissions.PERSON_WRITE.getPermission())
		// Le get est accessible pour tous les roles
		.antMatchers(HttpMethod.GET,"/user/**").hasAnyRole(MklRoles.ADMIN.name(), MklRoles.CLIENT.name())
		*/
		
		/**
		 * 
		 *  .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		    .and()
		    .authorizeRequests()
			.antMatchers("/").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic() ;
		 */
		/**
		 * Methode avec Basic Auth
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic() ;
		*/
		
		/** Methode avec page de login personalisée avec tymleaf
		 * 
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/users") ;
		*/
		
		/* Fin d'auh avec form login
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.and()
		.logout()
		.clearAuthentication(true)
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID", "XSRF-TOKEN");
		*/
		
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilter(new MktJwtUsernamePasswordAuthentificationFilter(authenticationManager()))
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.anyRequest()
		.authenticated();
		
		
		
		

	}
	
	/**
	 * Methode avec authentification en BDD
	 */
	
	@Bean
	protected DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(mklUserDetailServices);
		return provider;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthenticationProvider());
	}
	

}
