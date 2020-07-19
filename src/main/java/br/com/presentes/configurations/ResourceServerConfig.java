package br.com.presentes.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "resource_id";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}
	
	@Override
	  public void configure(final HttpSecurity http) throws Exception {
	    // @formatter:off
	    http.csrf().disable().authorizeRequests()
	    // This is needed to enable swagger-ui interface.
	    .antMatchers("/swagger-ui.html","/swagger-resources/**", "/v2/api-docs/**").permitAll()
	    .antMatchers("/**").authenticated();
	  }

	/*
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.anonymous()
		.disable()
		.authorizeRequests()
		.antMatchers("/**")
		.authenticated()
		.and()
		.exceptionHandling()
		.accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
	
	public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        .antMatchers("/v2/api-docs", "/configuration/**", "/swagger-resources/**",  "/swagger-ui.html", "/webjars/**", "/api-docs/**");
    }
    */
	
	/*
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .antMatcher("/**") // this will apply to the entire web server
            .authorizeRequests()
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/**").permitAll() // this should allow swagger to operate
                .anyRequest().hasAuthority("myapp.read"); // everything else requires 'myapp.read' authority
    }
    */
	


}
