package com.alucarweb.killometer;

import java.util.Arrays;
import java.util.List;

public class KillometerTypeBean {
	
	public List<KillometerType> getList() {
		return Arrays.asList(KillometerType.values());
	}
	
}
