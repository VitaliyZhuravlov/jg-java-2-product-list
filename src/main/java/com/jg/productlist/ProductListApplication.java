package com.jg.productlist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class ProductListApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductListApplication.class, args);
	}

}
