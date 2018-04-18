package com.pendycorp.todo.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

/**
 * Configuration for AWS DynamoDB
 * @author spendyala
 */
@Configuration
@EnableDynamoDBRepositories(basePackages="com.pendycorp.todo")
public class DynamoDBConfig {
	
	@Value("${amazon.dynamodb.endpoint}")
	private String amazonDynamoDBEndpoint;
	
	@Value("${amazon.aws.accesskey}")
	private String amazonAWSAccessKey;
	
	@Value("${amazon.aws.secretkey}")
	private String amazonAWSSecretKey;
	
	/**
	 * Method gets AmazonDynamoDB client
	 * the client returned is defined as a Spring bean and is managed by Spring container
	 * @return AmazonDynamoDB
	 */
	@SuppressWarnings("deprecation")
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		
		@SuppressWarnings("deprecation")
		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(awsCredentials());
		if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }
         
        return amazonDynamoDB;
	}
	
	/**
	 * Method that builds AWSCredentials class based on credentials from properties file
	 * AWSCredentials is defined and Spring Bean and is managed by Spring container
	 * @return AWSCredentials
	 */
	@Bean
	public AWSCredentials awsCredentials() {
		return new BasicAWSCredentials(
				amazonAWSAccessKey, amazonAWSSecretKey);
	}

}
