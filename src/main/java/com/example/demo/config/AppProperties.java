package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class AppProperties {

    private String mongodbDatabase;
    private String mongodbUri;
    private int apiPort;

    // Getters and Setters

    public String getMongodbDatabase() {
        return mongodbDatabase;
    }

    public void setMongodbDatabase(String mongodbDatabase) {
        this.mongodbDatabase = mongodbDatabase;
    }

    public String getMongodbUri() {
        return mongodbUri;
    }

    public void setMongodbUri(String mongodbUri) {
        this.mongodbUri = mongodbUri;
    }

    public int getApiPort() {
        return apiPort;
    }

    public void setApiPort(int apiPort) {
        this.apiPort = apiPort;
    }
}
