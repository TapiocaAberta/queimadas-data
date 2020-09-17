package io.sjcdigital.service;

import static io.sjcdigital.model.Constants.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Named("region")
public class RegionFileService extends FileService {

private static final Logger LOGGER = LoggerFactory.getLogger(RegionFileService.class);
	
	@Inject
	@ConfigProperty(name = "url.region")
	String urlRegion;

	
	public RegionFileService( ) {
		this.values = REGIONS;
	}

	@Override
	public String getType() {
		LOGGER.info("Getting regions");
		return urlRegion;
	}

}
