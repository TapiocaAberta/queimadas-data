package io.sjcdigital;

import javax.inject.Inject;
import javax.inject.Named;

import io.sjcdigital.service.FileService;
import picocli.CommandLine;

@CommandLine.Command(mixinStandardHelpOptions = true, name="demo")
public class Main  implements Runnable {

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
	
	@Override
	public void run() {
		stateService.run();
		//regionService.getFileFromInpe();
	}

}
