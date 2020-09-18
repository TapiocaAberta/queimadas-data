package io.sjcdigital.service;

import static io.sjcdigital.model.Constants.BIOMES;
import static io.sjcdigital.model.Constants.BIOMES_LAT;
import static io.sjcdigital.model.Constants.BIOMES_LONG;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
@Named("biome")
public class BiomesFileService extends FileService {

	@ConfigProperty(name = "biome")
	String biome;
	
	@ConfigProperty(name = "url.biome")
	String url;

	
	public BiomesFileService( ) {
		this.values = BIOMES;
		this.latValues = BIOMES_LAT;
		this.longValues = BIOMES_LONG;
	}

	@Override
	public String getType() {
		return biome;
	}

	@Override
	String getURL() {
		return url;
	}
	

}
