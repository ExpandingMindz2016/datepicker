package datepicker.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().and()
                .logout()
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                // .requiresChannel().anyRequest().requiresSecure()
                // .and()
                .authorizeRequests()
                .antMatchers("/", "/public*//**", "/common*//**", "/api*//**", "/pages*//**", "/auth*//**", "/forgot*//**", "/secure*//**", "/error*//**", "/logout", "/login?logout", "/webjars*//**").permitAll()
                .antMatchers("/admin**").access("hasAuthority('AUTH_ADMIN')")
                .antMatchers("/account*//**", "/account").access("hasAuthority('AUTH_USER') or hasAuthority('AUTH_ADMIN')")
                .anyRequest().authenticated();
    }

}
