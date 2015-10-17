package com.alucarweb.aws;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.alucarweb.util.AlucarConfig;
import com.alucarweb.util.AlucarConfig.Property;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@ApplicationScoped
public class AlucarS3 {

	private static final String SUFIX = "-";

	private AmazonS3Client s3Client;

	@Inject
	private AWSCredentials credentials;

	@PostConstruct
	public void setUp() {
		s3Client = new AmazonS3Client(credentials);
	}

	public void send(File savedPicture, Long carId) {

		String fileName = AlucarConfig.get(Property.IMAGES_FOLDER) + carId + SUFIX + savedPicture.getName();

		s3Client.putObject(new PutObjectRequest(AlucarConfig.get(Property.ALUCAR_BUCKET), fileName, savedPicture)
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}
}
