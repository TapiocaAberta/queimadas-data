package io.sjcdigital.service;

import static io.sjcdigital.model.Constants.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Named("state")
public class StateFileService extends FileService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StateFileService.class);
	
	@Inject
	@ConfigProperty(name = "url.state")
	String urlState;

	
	public StateFileService( ) {
		this.values = STATES;
		this.latValues = STATE_LAT;
		this.longValues = STATE_LONG;
	}

	@Override
	public String getType() {
		LOGGER.info("Getting state");
		return urlState;
	}

}
