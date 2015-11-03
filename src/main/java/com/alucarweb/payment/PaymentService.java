package com.alucarweb.payment;

import com.alucarweb.devolution.Devolution;
import com.alucarweb.rent.Rent;
import com.alucarweb.util.AlucarConfig;
import com.alucarweb.util.DateUtil;
import com.alucarweb.util.AlucarConfig.Property;

public class PaymentService {

	private static final String AgencyDistance = AlucarConfig.get(Property.AGENCY_DISTANCE);
	private Double totalValue;

	public PaymentService(Double totalValue) {
		this.totalValue = totalValue;
	}

	public void checkFines(Rent rent, Devolution devolution) {
		checkDayFine(rent, devolution);
		checkAgencyFine(rent, devolution);
	}

	private void checkAgencyFine(Rent rent, Devolution devolution) {
		if (rent.getExpectedAgency().getId() != devolution.getAgency().getId()) {

			if (rent.getAgency().getState() != devolution.getAgency().getState()) {
				totalValue += Double.parseDouble(AgencyDistance) * 4;
			}
			totalValue += 30;
		}
	}

	private void checkDayFine(Rent rent, Devolution devolution) {

		int dueDate = DateUtil.daysBetween(rent.getExpectedDate(), devolution.getDate());
		if (dueDate > 0) {
			dueDate = (dueDate > 20) ? 20 : dueDate;
			Double delayedValue = (dueDate / 100) * totalValue;
			totalValue += delayedValue;
		}
	}

}
