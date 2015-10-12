package com.alucarweb.car.images;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import com.alucarweb.aws.AlucarS3;
import com.alucarweb.car.Car;

import br.com.caelum.vraptor.observer.upload.UploadedFile;

public class Images {

	private static final String SUFIX = "-";

	@Inject
	private ServletContext context;
	@Inject
	private AlucarS3 alucarS3;

	public void save(Car car, UploadedFile uploadedFile) {

		// String path = "/home/kali/github/AlucarWeb/";

		File imageFile = new File(context.getRealPath("images"), uploadedFile.getFileName());

		car.setImage(AlucarS3.IMAGES_URL + car.getId() + SUFIX + uploadedFile.getFileName());

		try {
			uploadedFile.writeTo(imageFile);
			alucarS3.send(imageFile, car.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
