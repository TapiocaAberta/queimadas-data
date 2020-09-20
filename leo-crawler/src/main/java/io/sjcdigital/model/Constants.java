package io.sjcdigital.model;

import java.util.Map;
import static java.util.Map.entry; 

public class Constants {
	
	public static final String TYPE = "TYPE";

	public static final String SEPARATOR = ",";
	
	public static final String HEADER = String.join( SEPARATOR,
					 								  "ANO",
					 								  "JANEIRO",	
					 								  "FEVEREIRO",	
					 								  "MARÇO",	
					 								  "ABRIL",	
					 								  "MAIO",	
					 								  "JUNHO",	
					 								  "JULHO",	
					 								  "AGOSTO",	
					 								  "SETEMBRO",	
					 								  "OUTUBRO",	
					 								  "NOVEMBRO",	
					 								  "DEZEMBRO",
					 								  TYPE,
					 								  "LAT",
					 								  "LONG");
	
	public static final Map<String, String> STATES = Map.ofEntries(
			entry("acre","Acre"),
			entry("alagoas","Alagoas"),
			entry("amapa","Amapá"),
			entry("amazonas", "Amazonas")
											  , entry("bahia","Bahia"), entry("ceara","Ceará"),
											  entry("distrito_federal","Distrito Federal"),
											  entry("espirito_santo","Espírito Santo"), entry("goias","Goiás"),
											  entry("maranhao","Maranhão"), entry("mato_grosso","Mato Grosso"),
											  entry("mato_grosso_do_sul","Mato Grosso do Sul"),
											  entry("minas_gerais","Minas Gerais"), entry("para","Pará"),
											  entry("paraiba","Paraíba"), entry("parana","Paraná"),
											  entry("pernambuco","Pernambuco"), entry("piaui","Piauí"),
											  entry("rio_de_janeiro","Rio de Janeiro"),
											  entry("rio_grande_do_norte","Rio Grande do Norte"),
											  entry("rio_grande_do_sul","Rio Grande do Sul"),
											  entry("rondonia","Rondônia"), entry("roraima","Roraima"),
											  entry("santa_catarina","Santa Catarina"), entry("sao_paulo","São Paulo"),
											  entry("sergipe","Sergipe"), entry("tocantins","Tocantins")
											  );
	
	public static final Map<String, String> STATE_LAT = Map.ofEntries(
			entry("acre","-8.77"),
			entry("alagoas","-9.71"),
			entry("amapa","1.41"),
			entry("amazonas", "-3.07"), 
			entry("bahia","-12.96"), 
			entry("ceara","-3.71"),
			entry("distrito_federal","-15.83"),
			entry("espirito_santo","-19.19"), 
			entry("goias","-16.64"),
			entry("maranhao","-2.55"), 
			entry("mato_grosso","-12.64"),
			entry("mato_grosso_do_sul","-20.51"),
			entry("minas_gerais","-18.1"), 
			entry("para","-5.53"),
			entry("paraiba","-7.06"), 
			entry("parana","-24.89"),
		    entry("pernambuco","-8.28"),
            entry("piaui","-8.28"),
			entry("rio_de_janeiro","-22.84"),
			entry("rio_grande_do_norte","-5.22"),
			entry("rio_grande_do_sul","-30.01"),
			entry("rondonia","-11.22"), 
			entry("roraima","1.89"),
			entry("santa_catarina","-27.33"), 
			entry("sao_paulo","-23.55"),
			entry("sergipe","-10.9"), 
			entry("tocantins","-10.25") );
	
	public static final Map<String, String> STATE_LONG = Map.ofEntries(
			entry("acre","-70.55"),
			entry("alagoas","-35.73"),
			entry("amapa","-51.77"),
			entry("amazonas", "-61.66"), 
			entry("bahia","-38.51"), 
			entry("ceara","-38.54"),
			entry("distrito_federal"," -47.86"),
			entry("espirito_santo","-40.34"), 
			entry("goias","-49.31"),
			entry("maranhao","-44.3"), 
			entry("mato_grosso","-55.42"),
			entry("mato_grosso_do_sul","-54.54"),
			entry("minas_gerais","-44.38"), 
			entry("para","-52.29"),
			entry("paraiba","-35.55"), 
			entry("parana","-51.55"),
		    entry("pernambuco","-35.07"),
            entry("piaui","-43.68"),
			entry("rio_de_janeiro","-43.15"),
			entry("rio_grande_do_norte","-36.52"),
			entry("rio_grande_do_sul","-51.22"),
			entry("rondonia","-62.8"), 
			entry("roraima","-61.22"),
			entry("santa_catarina","-49.44"), 
			entry("sao_paulo","-46.64"),
			entry("sergipe","-37.07"), 
			entry("tocantins","-48.25"));
	
	public static final Map<String, String> REGIONS = Map.ofEntries(
			entry("norte","Norte"),
			entry("nordeste","Nordeste"),
			entry("centro-oeste","Centro-Oeste"),
			entry("sul","Sul"),
			entry("sudeste","Sudeste"),
			entry("amazonia_legal","Amazônia Legal"),
			entry("vale_do_paraiba","Vale do Paraíba"),
			entry("map","MAP") );
	
	public static final Map<String, String> REGIONS_LAT = Map.ofEntries(
			entry("norte","-4.1870469"),
			entry("nordeste","-9.6512517"),
			entry("centro-oeste","-15.6517991"),
			entry("sul","-28.0509141"),
			entry("sudeste","-19.7064653"),
			entry("amazonia_legal","0"),
			entry("vale_do_paraiba","0"),
			entry("map","0") );
	
	public static final Map<String, String> REGIONS_LONG = Map.ofEntries(
			entry("norte","-64.3391907"),
			entry("nordeste","45.0683922"),
			entry("centro-oeste","-58.264065"),
			entry("sul","-57.3268427"),
			entry("sudeste","45.4661952"),
			entry("amazonia_legal","0"),
			entry("vale_do_paraiba","0"),
			entry("map","0") );
	
	public static final Map<String, String> BIOMES = Map.ofEntries(
			entry("caatinga","Caatinga"),
			entry("cerrado","Cerrado"),
			entry("pantanal","Pantanal"),
			entry("pampa","Pampa"),
			entry("amazonia","Amazônia"),
			entry("mata_atlantica","Mata Atlântica") );
	
	public static final Map<String, String> BIOMES_LAT = Map.ofEntries(
			entry("caatinga","0"),
			entry("cerrado","0"),
			entry("pantanal","0"),
			entry("pampa","0"),
			entry("amazonia","0"),
			entry("mata_atlantica","0") );
	
	public static final Map<String, String> BIOMES_LONG = Map.ofEntries(
			entry("caatinga","0"),
			entry("cerrado","0"),
			entry("pantanal","0"),
			entry("pampa","0"),
			entry("amazonia","0"),
			entry("mata_atlantica","0") );
}
