package com.alucarweb.aws;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@ApplicationScoped
public class AlucarS3 {

	public static final String IMAGES_URL = "https://s3-us-west-2.amazonaws.com/alucar-tcc-satan/images/car_users/";
	private static final String SUFIX = "-";
	private final String IMAGES_FOLDER = "images/car_users/";
	private final String bucketName = "alucar-tcc-satan";

	private AmazonS3Client s3Client;

	@Inject
	private AWSCredentials credentials;

	@PostConstruct
	public void setUp() {
		s3Client = new AmazonS3Client(credentials);
	}

	public void send(File savedPicture, Long carId) {

		String fileName = IMAGES_FOLDER + carId + SUFIX + savedPicture.getName();

		s3Client.putObject(new PutObjectRequest(bucketName, fileName, savedPicture)
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}
}
