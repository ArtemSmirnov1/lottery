package com.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource("classpath:service.properties")
@EnableFeignClients("com.lottery.services")
@EnableJpaRepositories(
    basePackages = "com.lottery.repositories",
    entityManagerFactoryRef = "baseEntityManager",
    transactionManagerRef = "baseTransactionManager")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
