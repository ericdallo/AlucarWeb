package com.alucarweb.aws;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.alucarweb.util.AlucarConfig;
import com.alucarweb.util.AlucarConfig.Property;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

@ApplicationScoped
public class AWSProducer {

	private AWSCredentials credentials;

	@PostConstruct
	public void setUp() {
		credentials = new BasicAWSCredentials(
				AlucarConfig.get(Property.AWS_ACCESS_KEY_ID),
				AlucarConfig.get(Property.AWS_SECRET_ACCESS_KEY)
			);
	}

	@Produces
	public AWSCredentials produce() {
		return this.credentials;
	}

}
