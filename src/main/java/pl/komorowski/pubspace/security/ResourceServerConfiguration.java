package pl.komorowski.pubspace.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.constraints.NotNull;

@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(@NotNull HttpSecurity http) throws Exception {

        http
                .cors().and()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/callback", "/login", "/webjars/**", "/error**").permitAll()
                .antMatchers(HttpMethod.GET, "/pubs").permitAll()
                .antMatchers(HttpMethod.GET, "/pubs/last10").permitAll()
                .antMatchers(HttpMethod.GET, "/pubs/latest/**").permitAll()
                .antMatchers(HttpMethod.GET, "/user").permitAll()
                .anyRequest().authenticated();

    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS").allowedHeaders("*");

            }
        };
    }
}
