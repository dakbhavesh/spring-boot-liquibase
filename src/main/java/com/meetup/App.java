package com.meetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Application.
 */
@SpringBootApplication
public class App {
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
		app.run(args);
	}
}
