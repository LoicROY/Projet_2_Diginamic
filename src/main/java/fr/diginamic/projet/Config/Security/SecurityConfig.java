package fr.diginamic.projet.Config.Security;

import fr.diginamic.projet.Repository.SalarieRepository;
import fr.diginamic.projet.Utils.Jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SalarieRepository salarieRepository;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username ->
                salarieRepository
                        .findByEmail(username)
                        .orElseThrow(() ->
                                new UsernameNotFoundException(String.format("User: %s, not found", username))))
                .passwordEncoder(encoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http.cors().and().csrf().disable();

        // Set session management to stateless
        // session won't be used to store user's state.
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        // Set permissions
        http
                .authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.POST, "/Salarie/create").permitAll()
                .antMatchers(HttpMethod.POST, "/Administrateur/create").permitAll()
                .antMatchers(HttpMethod.POST, "/Manager/create").permitAll()
                .antMatchers(HttpMethod.GET, "/Departement/getAll").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll();

        // Set unauthorized requests exception handler
        http.exceptionHandling()
                .authenticationEntryPoint((request, response, authErr) ->
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
                );

        // Add JWT token filter
        http.addFilterBefore(
                jwtRequestFilter,
                UsernamePasswordAuthenticationFilter.class
        );
    }

}