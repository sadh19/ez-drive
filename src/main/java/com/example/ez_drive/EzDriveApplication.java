package com.example.ez_drive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:/Users/sadh19/var/ez-drive/ez-drive.properties")
public class EzDriveApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzDriveApplication.class, args);
	}

}
