package com.javaexample.infrastructure;

import com.javaexample.box.BoxService;
import com.javaexample.box.BoxRepository;
import com.javaexample.data.DatabaseAccess;
import com.javaexample.data.H2DataAccess;
import com.javaexample.box.Box;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean public BoxService boxService(){ return new BoxService(); }
    @Bean public Repository<Box> boxRepository(){
        return new BoxRepository();
    }
    @Bean public DatabaseAccess databaseAccess() { return new H2DataAccess(); }
}
