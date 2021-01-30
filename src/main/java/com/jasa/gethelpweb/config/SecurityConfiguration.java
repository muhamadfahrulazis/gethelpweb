package com.jasa.gethelpweb.config;

import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.repository.PetugasRepository;
import com.jasa.gethelpweb.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private PetugasService petugasService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(
                "/",
                "/registrationForm**",
                "/register",
                "/getclean",
                "/getmassage",
                "/getbeauty",
                "/faq",
                "/cms/registration**",
                "/assets/**",
                "/assets-cms/**").permitAll()
                .antMatchers("/cms/list_verifikasi").hasAnyAuthority("Verifier", "Supervisor")
                .antMatchers("/cms/list_training").hasAnyAuthority("Trainer", "Supervisor")
                .antMatchers("/cms/list_onboarding").hasAnyAuthority("Admin", "Supervisor")
                .antMatchers("/cms/list_petugas").hasAnyAuthority("Supervisor")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/cms/login")
                .permitAll()
                .defaultSuccessUrl("/cms", true)
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/cms/login?logout")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(petugasService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
