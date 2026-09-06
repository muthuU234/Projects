//package com.image.image.config;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http)
//            throws Exception {
//
//        http
//            .cors(cors -> {})
//            
//            .csrf(csrf -> csrf
//                .ignoringRequestMatchers("/ws/**")
//            )
//
//            .authorizeHttpRequests(auth -> auth
//
//                // WebSocket / SockJS
//                .requestMatchers("/ws/**").permitAll()
//
//                // Your other public endpoints
//                // .requestMatchers(...).permitAll()
//
//                .anyRequest().authenticated()
//            );
//
//        return http.build();
//    }
//
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//
//        CorsConfiguration configuration =
//                new CorsConfiguration();
//
//        configuration.setAllowedOriginPatterns(
//                List.of("*")
//        );
//
//        configuration.setAllowedMethods(
//                List.of(
//                    "GET",
//                    "POST",
//                    "PUT",
//                    "DELETE",
//                    "OPTIONS"
//                )
//        );
//
//        configuration.setAllowedHeaders(
//                List.of("*")
//        );
//
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source =
//                new UrlBasedCorsConfigurationSource();
//
//        source.registerCorsConfiguration(
//                "/**",
//                configuration
//        );
//
//        return source;
//    }
//}