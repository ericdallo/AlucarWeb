package com.alucarweb.aws;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;

@ApplicationScoped
public class AWSProducer {

	private AWSCredentials credentials;

	@PostConstruct
	public void setUp() {
		credentials = new ProfileCredentialsProvider().getCredentials();
	}

	@Produces
	public AWSCredentials produce() {
		return this.credentials;
	}

}
