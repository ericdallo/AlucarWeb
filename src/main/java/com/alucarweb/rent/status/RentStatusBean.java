package com.alucarweb.rent.status;

import java.util.Arrays;
import java.util.List;

public class RentStatusBean {

	public List<RentStatus> getList() {
		return Arrays.asList(RentStatus.values());
	}
}
