package io.sjcdigital;

import picocli.CommandLine;

@CommandLine.Command
public class Command  implements Runnable {

	@CommandLine.Option(names = {"-n", "--name"}, description = "Who will we greet?", defaultValue = "World")
    String name;
	
	@Override
	public void run() {
		System.err.println(name);
		
	}

}
