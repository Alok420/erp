package com.opamg.erp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ErpApplication extends ServletInitializer {

   static Logger log = LoggerFactory.getLogger(ErpApplication.class);

   public static void main(String[] args) {
      SpringApplication.run(ErpApplication.class, args);
   }

   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(ErpApplication.class);
   }
}
