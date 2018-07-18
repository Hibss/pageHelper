package com.jfz.pageHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author steven.sheng
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PageHelperApplication {

	public static void main(String[] args) {
		SpringApplication application =new SpringApplication(PageHelperApplication.class);
		application.run(args);
	}

}


