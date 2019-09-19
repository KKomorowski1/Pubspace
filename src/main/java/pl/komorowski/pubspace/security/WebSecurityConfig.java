package pl.komorowski.pubspace.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().and()
                .csrf().disable()
                .formLogin().disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/callback", "/login**", "/webjars/**", "/error**").permitAll()
                .antMatchers(HttpMethod.GET, "/pubs").anonymous()
                .antMatchers(HttpMethod.GET, "/pubs/last10").anonymous()
                .anyRequest()
                .authenticated();
    }
}
