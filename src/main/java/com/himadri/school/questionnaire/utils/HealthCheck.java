package com.himadri.school.questionnaire.utils;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        int erroCode = check();
        if (erroCode != 0){
            return Health.down()
                    .withDetail("Error code ", erroCode).build();
        }
        return Health.up().build();
    }

    public int check(){
        //todo
        return 0;
    }
}
