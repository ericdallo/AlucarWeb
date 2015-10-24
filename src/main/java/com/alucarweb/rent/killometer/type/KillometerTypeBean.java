package com.alucarweb.rent.killometer.type;

import java.util.Arrays;
import java.util.List;

public class KillometerTypeBean {
	
	public List<KillometerType> getList() {
		return Arrays.asList(KillometerType.values());
	}
	
}
