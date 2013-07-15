/*
 	Copyright (c) 2013 Víctor Martín Molina
 	
 	This file is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This file is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this file.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.claygregory.api.google.places;

import static org.junit.Assert.*;

import org.junit.Test;

import com.claygregory.common.data.geo.GeoLocation;

public class AutocompleteQueryOptionsTests {

	@Test(expected = AssertionError.class)
	public void testAutocompleteQueryOptionsNull() {
		new AutocompleteQueryOptions(null);
	}
	
	@Test
	public void testAutocompleteQueryOptionsDefault() {
		GeoLocation geoLocation = new Place.Location();
		AutocompleteQueryOptions autocompleteQueryOptions = new AutocompleteQueryOptions(geoLocation);
		assertEquals("0.0,0.0", autocompleteQueryOptions.getLocation());	
		assertNull(autocompleteQueryOptions.getRadius());
	}
	
	@Test
	public void testAutocompleteQueryOptions() {
		GeoLocation geoLocation = new GeoLocation() {
			@Override
			public float getLongitude() {
				return 10.1f;
			}
			
			@Override
			public float getLatitude() {
				return 20.2f;
			}
			
			@Override
			public Integer getAccuracy() {
				return 10;
			}
		};
		AutocompleteQueryOptions autocompleteQueryOptions = new AutocompleteQueryOptions(geoLocation);
		assertEquals("20.2,10.1", autocompleteQueryOptions.getLocation());	
		assertEquals("10", autocompleteQueryOptions.getRadius());
	}
	
	@Test
	public void setTypes() {
		AutocompleteQueryOptions autocompleteQueryOptions = new AutocompleteQueryOptions();
		autocompleteQueryOptions.setTypes("a", "b");
		assertEquals("a|b", autocompleteQueryOptions.getTypes());
	}

}
