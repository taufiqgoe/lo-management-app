package id.taufiq.lomanagementapp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun defaultSecurityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .authorizeHttpRequests { authorize ->
                authorize
                    .anyRequest().authenticated()
            }
            .formLogin(Customizer.withDefaults())
            .logout()
        return http.build()
    }

}