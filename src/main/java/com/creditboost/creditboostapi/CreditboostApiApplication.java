package com.creditboost.creditboostapi;

import com.creditboost.creditboostapi.entity.ProfileEntity;
import com.creditboost.creditboostapi.entity.UserEntity;
import com.creditboost.creditboostapi.repository.ProfileRepository;
import com.creditboost.creditboostapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CreditboostApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(CreditboostApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, ProfileRepository profileRepository) {
		return args -> {
			UserEntity userEntity = new UserEntity(
					"userabc","123","abc@gmail.com"
			);
			userRepository.save(userEntity);

			ProfileEntity profileEntity = new ProfileEntity(
					"user","abc", "11-30-2000", "6504493399", "123-222-2222","2222", 332222221, 1229211, "Bank1",
					600, 6000
			);
			profileRepository.save(profileEntity);
		};
	}
}

