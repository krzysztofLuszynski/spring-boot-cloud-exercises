package kluszynski.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PhonesAndPersonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonesAndPersonsApplication.class, args);
	}
}
