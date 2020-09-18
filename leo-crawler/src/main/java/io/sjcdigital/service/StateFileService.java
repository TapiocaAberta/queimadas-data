package io.sjcdigital.service;

import static io.sjcdigital.model.Constants.STATES;
import static io.sjcdigital.model.Constants.STATE_LAT;
import static io.sjcdigital.model.Constants.STATE_LONG;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
@Named("state")
public class StateFileService extends FileService {
	
	@ConfigProperty(name = "state")
	String state;
	
	@ConfigProperty(name = "url.state")
	String url;

	
	public StateFileService( ) {
		this.values = STATES;
		this.latValues = STATE_LAT;
		this.longValues = STATE_LONG;
	}

	@Override
	String getType() {
		return state;
	}

	@Override
	String getURL() {
		return url;
	}

}
