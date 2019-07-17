package com.yash.vhub.domain;

import org.springframework.data.rest.core.config.Projection;

@Projection(
		name="LocationSummary",
		types= {
				Location.class
		})
public interface LocationSummary {
	String getCountry();
	String getStateOrProvince();
	String getCity();
	String getZipOrPostcode();
	String getAddressLine1();
	String getAddressLine2();
	String getAddressLine3();
	String getAddressLine4();
}
