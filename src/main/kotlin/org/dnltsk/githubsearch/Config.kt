package org.dnltsk.githubsearch

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config{

    @Bean
    fun configureObjectMapper(): ObjectMapper{
        return ObjectMapper().findAndRegisterModules()
    }

}