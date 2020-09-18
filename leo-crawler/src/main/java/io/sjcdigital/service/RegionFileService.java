package io.sjcdigital.service;

import static io.sjcdigital.model.Constants.REGIONS;
import static io.sjcdigital.model.Constants.REGIONS_LAT;
import static io.sjcdigital.model.Constants.REGIONS_LONG;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
@Named("region")
public class RegionFileService extends FileService {
	
	@ConfigProperty(name = "region")
	String region;

	@ConfigProperty(name = "url.region")
	String url;
	
	public RegionFileService( ) {
		this.values = REGIONS;
		this.latValues = REGIONS_LAT;
		this.longValues = REGIONS_LONG;
	}

	@Override
	String getType() {
		return region;
	}

	@Override
	String getURL() {
		return url;
	}

}
