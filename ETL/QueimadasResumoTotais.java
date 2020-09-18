import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.apache.commons:commons-csv:1.8
//JAVA 11

public class QueimadasResumoTotais {

    // Files
    private static final String OUT_DIR = "../dashboard_data/";
    private static final String INPUT_DIR = "../csv-data/";
    private static final String[] INPUT_FILES = { "bioma_sumarized.csv", "regiao_sumarized.csv",
            "estado_sumarized.csv" };

    // CSV
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final CSVFormat CSV_TYPE = CSVFormat.DEFAULT.withFirstRecordAsHeader();
    private static final CSVFormat OUT_CSV_TYPE = CSVFormat.DEFAULT.withFirstRecordAsHeader()
            .withQuoteMode(QuoteMode.ALL);

    // Input Columns information
    private static final String CL_ANO = "ANO";
    private static final String CL_TYPE = "TYPE";
    private static final String CL_LAT = "LAT";
    private static final String CL_LONG = "LONG";

    private static final String[] CL_MONTHS = { "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO",
            "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" };

    // Output columns information

    private static final List<String> OUT_COLUMNS = List.of("ANO", "MÊS", "VALOR", "TYPE", "LAT", "LONG");

    public static void main(String... args) throws Exception {
        System.out.println("Starting Transformation...");
        var inputDir = Paths.get(INPUT_DIR);
        var outputDir = Paths.get(OUT_DIR);
        outputDir.toFile().mkdirs();
        if (inputDir.toFile().exists()) {
            for (String inputFileName : INPUT_FILES) {
                var inputFile = inputDir.resolve(inputFileName);
                if (inputFile.toFile().exists()) {
                    var outName = inputFile.getFileName().toString().replaceAll(".csv", "") + "_db.csv";
                    var outFile = outputDir.resolve(outName);
                    System.out.println("Processing " + inputFile);
                    generateOutCSV(inputFile, outFile);
                    System.out.println("Generated " + outFile);
                } else {
                    System.out.println("File does not exist, skipping: " + inputFileName);
                }

            }

        } else {
            System.out.println("Input directory does not exist.");
        }
        System.out.println("Finished!");
    }

    private static void generateOutCSV(Path inputFile, Path destination) throws IOException {
        var parser = CSVParser.parse(inputFile, CHARSET, CSV_TYPE);
        var records = parser.getRecords();

        Files.deleteIfExists(destination);
        Files.createFile(destination);

        var outPrinter = OUT_CSV_TYPE.print(destination, CHARSET);
        printTo(outPrinter, OUT_COLUMNS);

        records.forEach(record -> {
            var ano = record.get(CL_ANO);
            var type = record.get(CL_TYPE);
            var lat = record.get(CL_LAT).trim();
            var longi = record.get(CL_LONG).trim();
            for (String month : CL_MONTHS) {
                printTo(outPrinter, List.of(ano, month, record.get(month), type, lat, longi));
            }
        });
        outPrinter.close();
    }

    private static void printTo(CSVPrinter printer, List<String> values) {
        try {
            printer.printRecord(values);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
