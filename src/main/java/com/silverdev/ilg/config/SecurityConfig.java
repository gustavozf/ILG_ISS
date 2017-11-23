package com.silverdev.ilg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
        private final UserDetailsService userDetailsService;

        @Autowired
        public SecurityConfig(UserDetailsService userDetailsService) {
            this.userDetailsService = userDetailsService;
        }

        @Bean
        public UserDetailsService userDetailsService() {
            InMemoryUserDetailsManager m = new InMemoryUserDetailsManager();
            m.createUser(User.withUsername("admin").password("admin").roles("ADMIN").build());
            return m;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/boleto").permitAll()
                    .antMatchers("/admin", "/admin/**").permitAll()//hasRole("ADMIN")
                    .antMatchers("/aluno","/aluno/**").permitAll()//hasRole("ALUNO")
                    .antMatchers("/ingresso", "/ingresso/**").permitAll()
                    .antMatchers("/ingressante", "/ingressante/**").permitAll() //hasRole("INGRESSANTE")
                    .antMatchers("/funcionario","/funcionario/**").hasRole("SECRETARIA")
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/redirectTipoUsuario", true)
                    .permitAll();
            http
                    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout");
            http
                    .authorizeRequests()
                    .antMatchers("/register", "/js/**", "/css/**", "/img/**",
                            "/jquery/**","/popper/**","/font-awesome/**","/PDFs/**" ,"/register/username")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .csrf()
                    .disable();

        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }


}

