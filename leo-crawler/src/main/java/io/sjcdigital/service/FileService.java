package io.sjcdigital.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;

import io.sjcdigital.model.Constants;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public abstract class FileService {


    @ConfigProperty(name = "sufix.csv")
    String sufixCSV;

    @ConfigProperty(name = "data.read.path")
    String readDataPath;

    @ConfigProperty(name = "data.path")
    String dataPath;

    Map<String, String> values;
    Map<String, String> latValues;
    Map<String, String> longValues;

    abstract String getType();

    abstract String getURL();

    public void run() {
        getFileFromInpe();
        readLocalFilesAndParseToCsv();
        readLocalFilesAndParseToJson();
    }

    private void readLocalFilesAndParseToCsv() {
        var dataFinal = new StringBuilder(Constants.HEADER);
        dataFinal.append("\n");
        walkFiles((fileName, lines) -> dataFinal.append(createSummarizedCSVFiles(lines,fileName)));

        try {
            Files.write(Paths.get(dataPath + getType() + "_sumarized.csv"), dataFinal.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readLocalFilesAndParseToJson() {
        var dataFinal = new StringBuilder("[");        
        walkFiles((fileName, lines) -> dataFinal.append(createSummarizedJsonFile(lines,fileName) + ","));
        var json = dataFinal.subSequence(0, dataFinal.length() - 1).toString() + "]";
        try {
            Files.write(Paths.get(dataPath + getType() + "_sumarized.json"), json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createSummarizedCSVFiles(Stream<String> lines, String filename) {
        var typeKey = filename.replace(sufixCSV, "");
        var data = new StringBuilder();
        lines.forEach(l -> {
            if (l.matches("^([0-9]{4}).*$")) {
                for (int i = 0; i < l.split(",").length - 1; i++) {
                    var str = l.split(",")[i];
                    str = str.equals("-") ? "0" : str;
                    data.append(str);
                    data.append(Constants.SEPARATOR);
                }

                data.append(values.get(typeKey));
                data.append(Constants.SEPARATOR);
                data.append(latValues.get(typeKey));
                data.append(Constants.SEPARATOR);
                data.append(longValues.get(typeKey));
                data.append("\n");
            }

        });
        return data.toString();
    }

    private String createSummarizedJsonFile(Stream<String> lines, String filename) {
        var typeKey = filename.replace(sufixCSV, "");
        var data = new StringBuilder();
        lines.forEach(l -> {
            if (l.matches("^([0-9]{4}).*$")) {
                data.append("[");
                for (int i = 0; i < l.split(",").length - 1; i++) {
                    var str = l.split(",")[i];
                    str = str.equals("-") ? "0" : str;
                    data.append(toJsonStr(str));
                    data.append(Constants.SEPARATOR);
                }

                data.append(toJsonStr(values.get(typeKey)));
                data.append(Constants.SEPARATOR);
                data.append(toJsonStr(latValues.get(typeKey)));
                data.append(Constants.SEPARATOR);
                data.append(toJsonStr(longValues.get(typeKey)));
                data.append("],");
            }
        });
        return data.subSequence(0, data.length() - 1).toString();
    }

    private void getFileFromInpe() {
        values.forEach((k, v) -> {
            createFiles(getURL() + k + sufixCSV, k + sufixCSV);
        });
    }

    private void createFiles(final String url, final String fileName) {
        try {
            var name = readDataPath + getType() + "/";
            var directory = new File(name);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            var readChannel = Channels.newChannel(new URL(url).openStream());
            var fileOS = new FileOutputStream(name + fileName);
            var writeChannel = fileOS.getChannel();
            writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);

            writeChannel.close();
            readChannel.close();
            fileOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void walkFiles(BiConsumer<String, Stream<String>> action) {
        try (var paths = Files.walk(Paths.get(readDataPath + getType()))) {
            paths.filter(Files::isRegularFile).forEach(
                                                       f -> {
                                                           try (var lines = Files.lines(f)) {
                                                                action.accept(f.getFileName().toString(), lines);
                                                           } catch (IOException e) {
                                                               e.printStackTrace();
                                                           }
                                                       });

        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    private String toJsonStr(Object v) {
        return "\""+v+"\"";
    }
}