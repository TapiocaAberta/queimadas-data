package io.sjcdigital.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.sjcdigital.model.Constants;

@ApplicationScoped
public abstract class FileService {
	
	@ConfigProperty(name = "url")
	String url;
	
	@ConfigProperty(name = "url.csv")
	String urlCsv;
	
	@ConfigProperty(name = "data.read.path")
	String readDataPath;
	
	@ConfigProperty(name = "data.path")
	String dataPath;

    Map<String, String> values;
    Map<String, String> latValues;
    Map<String, String> longValues;
    
    public abstract String getType();

    public void run() {
    	getFileFromInpe();
    	readLocalFilesAndParse();
    }
    
	private void readLocalFilesAndParse() {
		
		StringBuilder dataFinal = new StringBuilder(Constants.HEADER);
		dataFinal.append("\n");

		try (Stream<Path> paths = Files.walk(Paths.get(readDataPath))) {
			
			paths.filter(Files::isRegularFile).forEach(
			f -> {
				
				try (Stream<String> lines = Files.lines(f)) {
					
					dataFinal.append(createSummarizedFiles(lines, f.getFileName().toString()));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
            Files.write(Paths.get(dataPath + getType() + "sumarized.csv"), dataFinal.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	

	private String createSummarizedFiles(Stream<String> lines, String filename) {
		
		String typeKey = filename.replace(urlCsv, "");
		
		StringBuilder data = new StringBuilder();
		
		lines.forEach(l -> {
			
			if(l.matches("^([0-9]{4}).*$")) {
				
				for (int i = 0; i < l.split(",").length -1; i++) {
					String str = l.split(",")[i];
					
					str = str.equals("-") ? "0" : str;
					
					data.append(str);
					data.append(Constants.SEPARATOR);
				}
				
				data.append(values.get(typeKey));
				
				//TODO: voltar pra fazer esquema igual typevalues
				
				data.append(Constants.SEPARATOR);
				data.append(latValues.get(typeKey));
				data.append(Constants.SEPARATOR);
				data.append(longValues.get(typeKey));
				
				data.append("\n");
			}
				
		});
		
		return data.toString();
		
	}

	private void getFileFromInpe() {
		
		values.forEach((k,v) -> {
			createFiles(url + getType() + k + urlCsv, k + urlCsv);
		});
		
	}
	
	private void createFiles(final String url, final String fileName) {
		
		try {
			
			String name = readDataPath + getType().replace("_", "") + "/";
			var directory = new File(name);
	        
	        if (!directory.exists()) {
	            directory.mkdirs();
	        }
			
			ReadableByteChannel readChannel = Channels.newChannel(new URL(url).openStream());
			FileOutputStream fileOS = new FileOutputStream(name + fileName);
			FileChannel writeChannel = fileOS.getChannel();
			writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
			
			writeChannel.close();
			readChannel.close();
			fileOS.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
