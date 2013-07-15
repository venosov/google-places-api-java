package com.claygregory.api.google.places;

import java.util.HashMap;

import com.claygregory.common.data.geo.GeoLocation;
import com.claygregory.common.util.StringUtil;

import static org.junit.Assert.*;

public class AutocompleteQueryOptions extends HashMap<String, String> {

	private static final long serialVersionUID = -7290974229881633926L;
	private static final String LOCATION = "location";
	private static final String RADIUS = "radius";
	private static final String TYPES = "types";

	public AutocompleteQueryOptions() {
		super();
	}

	public AutocompleteQueryOptions(GeoLocation location) {
		super();
		assertNotNull(location);
		this.put(LOCATION, location.getLatitude() + "," + location.getLongitude());
		Integer radius = location.getAccuracy();
		this.put(RADIUS, radius != null ? String.valueOf(radius) : null);
	}

	public void setTypes(String... types) {
		this.put(TYPES, StringUtil.join("|", types));
	}
	
	public String getLocation() {
		return this.get(LOCATION);
	}
	
	public String getRadius() {
		return this.get(RADIUS);
	}
	
	public String getTypes() {
		return this.get(TYPES);
	}
}
