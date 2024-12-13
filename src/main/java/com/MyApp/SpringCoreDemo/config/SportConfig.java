package com.MyApp.SpringCoreDemo.config;

import com.MyApp.SpringCoreDemo.common.Coach;
import com.MyApp.SpringCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// That defines a Spring-managed bean.
// Take existing third-party class and expose as Spring bean.
@Configuration
public class SportConfig {

    //@Bean
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
