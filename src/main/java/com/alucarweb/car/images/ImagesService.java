package com.alucarweb.car.images;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alucarweb.aws.AlucarS3;
import com.alucarweb.car.Car;
import com.alucarweb.util.AlucarConfig;
import com.alucarweb.util.AlucarConfig.Property;

import br.com.caelum.vraptor.observer.upload.UploadedFile;

public class ImagesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ImagesService.class);
	private static final String SUFIX = "-";

	@Inject
	private ServletContext context;

	@Inject
	private AlucarS3 alucarS3;

	public void save(Car car, UploadedFile uploadedFile) {

		File imageFile = new File(context.getRealPath("images"), uploadedFile.getFileName());

		car.setImage(AlucarConfig.get(Property.IMAGES_URL) + car.getId() + SUFIX + uploadedFile.getFileName());

		try {
			uploadedFile.writeTo(imageFile);
			alucarS3.send(imageFile, car.getId());
		} catch (IOException e) {
			LOGGER.error("Failed to convert UploadedImage to File witg car id {}.", car.getId(), e);
		}
	}
}
