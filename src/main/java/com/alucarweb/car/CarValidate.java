package com.alucarweb.car;

import com.alucarweb.util.NumberUtil;

import br.com.caelum.vraptor.validator.I18nMessage;

public class CarValidate {
	public static boolean checkCarFields(Car car){
		//@Gambiarra - Não deu tempo de configurar o hibernate validator
			if (car.getModel() == null || car.getManufacturer() == null || car.getCity() == null
					|| car.getLicensePlate() == null || car.getChassi() == null || car.getCategory() == null
					|| car.getKm() == null || car.getFreeKm() == null || car.getControlKm() == null) {
				
				validator.add(new I18nMessage("car.error.empty", "car.error.empty"));
				validator.onErrorRedirectTo(this).form();
				return false;
			}
			
			if(!NumberUtil.isDouble(car.getKm())){
				validator.add(new I18nMessage("car.error.km", "car.error.km"));
				validator.onErrorRedirectTo(this).form();
				return;
			}
			
			
			if(!NumberUtil.isDouble(car.getFreeKm())){
				validator.add(new I18nMessage("car.error.freeKm", "car.error.freeKm"));
				validator.onErrorRedirectTo(this).form();
				return;
			}
			
			if(!NumberUtil.isDouble(car.getControlKm())){
				validator.add(new I18nMessage("car.error.controlKm", "car.error.controlKm"));
				validator.onErrorRedirectTo(this).form();
				return;
			}
	}
}
