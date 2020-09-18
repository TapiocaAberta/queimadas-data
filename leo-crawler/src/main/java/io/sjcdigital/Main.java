package io.sjcdigital;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.sjcdigital.service.FileService;
import picocli.CommandLine;

@CommandLine.Command(mixinStandardHelpOptions = true, name="demo")
public class Main  implements Runnable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	@CommandLine.Option(names = {"-a", "--all"}, description = "Get state data", defaultValue = "false")
    Boolean all;
	
	@CommandLine.Option(names = {"-s", "--state"}, description = "Get state data", defaultValue = "false")
    Boolean state;
	
	@CommandLine.Option(names = {"-r", "--region"}, description = "Get region data", defaultValue = "false")
    Boolean region;
	
	@CommandLine.Option(names = {"-b", "--biome"}, description = "Get biome data", defaultValue = "false")
    Boolean biome;
	
	@Inject
	@Named("state")
	FileService stateService;
	
	@Inject
	@Named("region")
	FileService regionService;
	
	@Inject
	@Named("biome")
	FileService biomeService;
	
	@Override
	public void run() {
		
		
		if(all) {
			
			LOGGER.info("Getting all");
			
			stateService.run();
			regionService.run();
			biomeService.run();
			
		} else {
			
			if(state) { 
				LOGGER.info("Getting State");
				stateService.run(); 
			}
			
			if(region) { 
				LOGGER.info("Getting Region");
				regionService.run(); 
			}
			
			if(biome) { 
				LOGGER.info("Getting Biome");
				biomeService.run(); 
			}
			
		}
	}

}
