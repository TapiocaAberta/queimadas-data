//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.apache.commons:commons-csv:1.8
//JAVA 11

import static java.lang.System.out;
import static java.net.http.HttpClient.newHttpClient;
import static java.net.http.HttpResponse.BodyHandlers.ofInputStream;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

public class AreaQueimada {

    private static final String CSV_URL = "http://queimadas.dgi.inpe.br/queimadas/aq1km/assets/data/Valores_Pixel_todos_biomas_urbano_2016_valor_1.csv";

    private static final String OUT_DIR = "../csv-data/area_queimada_biomas.csv";

    // CSV
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final CSVFormat CSV_TYPE = CSVFormat.DEFAULT.withFirstRecordAsHeader();
    private static final CSVFormat OUT_CSV_TYPE = CSVFormat.DEFAULT.withFirstRecordAsHeader()
            .withQuoteMode(QuoteMode.ALL);

    public static void main(String... args) throws Exception {
        out.println("Downloading CSV");
        var uri = URI.create(CSV_URL);
        var request = HttpRequest.newBuilder(uri).GET().build();
        var csvContent = newHttpClient().send(request, ofInputStream()).body();

        var parser = CSVParser.parse(csvContent, CHARSET, CSV_TYPE);
        var records = parser.getRecords();

        var outPath = Paths.get(OUT_DIR);
        Files.deleteIfExists(outPath);

        var outPrinter = OUT_CSV_TYPE.print(outPath, CHARSET);
        printTo(outPrinter, parser.getHeaderNames());

        out.println("Removing total values");
        records.stream()
            .filter(r -> !r.get(0).startsWith("Total anual"))
            .map(r -> {
                var row = new ArrayList<String>();
                r.forEach(v -> {
                    if (v.trim().isEmpty()) {
                        row.add("0");
                    } else {
                        row.add(v);
                    }
                });
                return row;
            })
            .forEach(row -> printTo(outPrinter, row));

        out.println("Finishing target CSV");    
        outPrinter.close();
        out.println("Finished!");
    }

    private static void printTo(CSVPrinter printer, Collection<String> values) {
        try {
            printer.printRecord(values);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
