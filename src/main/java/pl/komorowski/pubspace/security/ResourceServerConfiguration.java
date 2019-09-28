package pl.komorowski.pubspace.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.validation.constraints.NotNull;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(@NotNull HttpSecurity http) throws Exception {

        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/callback", "/login", "/webjars/**", "/error**").permitAll()
                .antMatchers(HttpMethod.GET,"/pubs").permitAll()
                .antMatchers(HttpMethod.GET, "/pubs/last10").permitAll()
                .antMatchers(HttpMethod.GET, "/pubs/latest/**").permitAll()
                .anyRequest().authenticated();

    }
}
