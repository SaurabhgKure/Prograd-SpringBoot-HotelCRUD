package com.HotelManagement.HotelManagement.Config;



import com.HotelManagement.HotelManagement.Security.CustomerDetailSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerDetailSecurity customerDetailSecurity;
    @Override
    protected void configure(HttpSecurity http) throws Exception {




        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET).hasAnyAuthority("ADMIN","EMPLOYEE","CUSTOMER")
                .antMatchers(HttpMethod.POST).hasAnyAuthority("ADMIN","EMPLOYEE")
                .antMatchers(HttpMethod.PUT).hasAnyAuthority("ADMIN","EMPLOYEE")
                .antMatchers(HttpMethod.DELETE).hasAnyAuthority("ADMIN")
                .and().httpBasic();

        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerDetailSecurity).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


}
