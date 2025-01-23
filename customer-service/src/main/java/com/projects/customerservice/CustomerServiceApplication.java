package com.projects.customerservice;

import com.projects.customerservice.config.CustomerConfigParams;
import com.projects.customerservice.entities.Customer;
import com.projects.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder()
							.name("Mohamed").email("Mohamed@gmail.com")
							.build());
			customerRepository.save(Customer.builder()
							.name("Sara").email("Sara@gmail.com")
							.build());
			customerRepository.save(Customer.builder()
							.name("Oussama").email("Oussama@gmail.com")
							.build());
//			customerRepository.save(new Customer("Mohamed", "med@gmail.com"));
//			customerRepository.save(new Customer("Imane", "imane@gmail.com"));
//			customerRepository.save(new Customer("Yassine", "yassine@gmail.com"));
			customerRepository.findAll().forEach(c -> {
				System.out.println("=======================");
				System.out.println(c.getId());
				System.out.println(c.getName());
				System.out.println(c.getEmail());
				System.out.println("=======================");
			});
		};
	}

}
