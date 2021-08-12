/*
package net.mkaminski.autoManagerBackend.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Configuration
public class dbConfig {
    String URL = "";
    String USERNAME = "";
    String PASSWORD = "";
    String DRIVER_CLASS_NAME = "";

    @Bean
    public DataSource getDataSource() {
        getCredentials();
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(URL);
        dataSourceBuilder.username(USERNAME);
        dataSourceBuilder.password(PASSWORD);
        dataSourceBuilder.driverClassName(DRIVER_CLASS_NAME);
        return dataSourceBuilder.build();
    }

    private void getCredentials() {

        File file = new File("src/main/resources/DBCredentials.txt");
        try {
            Scanner scanner = new Scanner(file);
            URL = scanner.nextLine();
            USERNAME = scanner.nextLine();
            PASSWORD = scanner.nextLine();
            DRIVER_CLASS_NAME = scanner.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }
}
*/
