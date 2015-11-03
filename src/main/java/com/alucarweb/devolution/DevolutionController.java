package com.alucarweb.devolution;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.killometer.KillometerType;
import com.alucarweb.rent.Rent;
import com.alucarweb.rent.RentController;
import com.alucarweb.rent.RentDAO;
import com.alucarweb.util.AlucarConfig;
import com.alucarweb.util.AlucarConfig.Property;
import com.alucarweb.util.DateCalc;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class DevolutionController {
	
	@Inject
	private Result result;
	
	@Inject
	private RentDAO rentDAO;

	@Inject
	private DevolutionDAO devolutionDAO;
	
	@TransactionRequired
	@Post("/devolucoes")
	public void save(Devolution devolution){
		Rent rent = rentDAO.findById(devolution.getRent().getId());		
		
		
		//CALCULO DO VALOR BASEADO NOS DIAS
		double totalValue = 0;
		int diasLocacao = DateCalc.daysBetween(rent.getExpectedDate(),rent.getCreatedAt());
		if(rent.getKillometerType() == KillometerType.CONTROLLED){
			totalValue += Double.parseDouble(rent.getCar().getControlKm()) * diasLocacao;
		}else{
			totalValue += Double.parseDouble(rent.getCar().getFreeKm());
		}
		
		//MULTA POR ATRASO DE DIA BASEADO NO VALOR DA LOCAÇÃO
		int diasAtraso = DateCalc.daysBetween(rent.getExpectedDate(),devolution.getDate()); 
		if(diasAtraso > 0){
			diasAtraso = (diasAtraso > 20) ? 20 : diasAtraso;
			double valorAtraso = ((diasAtraso / 100) * totalValue);
			totalValue += valorAtraso;
		}
		
		//MULTA DE AGENCIA DIFERENTE
		System.out.println("Rent agency id: " + rent.getAgency().getId());
		System.out.println("Dev agency id: " + devolution.getAgency().getId());
		if(!rent.getExpectedAgency().getId().equals(devolution.getAgency().getId())){
			if(rent.getAgency().getState() != devolution.getAgency().getState()){
				totalValue += Double.parseDouble(AlucarConfig.get(Property.AGENCY_DISTANCE)) * 4;
			}
			totalValue += 30;
		}
		
		devolution.setTotalValue(totalValue+"");//TODO - trocar o valor para double
		
		devolutionDAO.returnRent(devolution);
		result.redirectTo(RentController.class).rent(devolution.getRent().getId());
	}
	
	@Post("/devolucao/{devolutionId}")
	public void pay(long devolutionId){
		//CALCULAR O PAGAMENTO AQUI
		
		Rent rent = devolutionDAO.findRentByDevolutionId(devolutionId);
		
		result.include("paymentIsEnabled",true);
		result.redirectTo(RentController.class).rent(rent.getId());
	}
	
	
	
}
