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
	
	public static final Map<String, String> REGIONS = Map.ofEntries(
			entry("norte","Norte"),
			entry("nordeste","Nordeste"),
			entry("centro-oeste","Centro-Oeste"),
			entry("sul","Sul"),
			entry("sudeste","Sudeste"),
			entry("amazonia_legal","Amazônia Legal"),
			entry("vale_do_paraiba","Vale do Paraíba"),
			entry("map","MAP") );
	
	public static final Map<String, String> BIOMES = Map.ofEntries(
			entry("caatinga","Caatinga"),
			entry("cerrado","Cerrado"),
			entry("pantanal","Pantanal"),
			entry("pampa","Pampa"),
			entry("amazonia","Amazônia"),
			entry("mata_atlantica","Mata Atlântica") );
	
	public static final Map<String, String> STATE_LAT = Map.ofEntries(
			entry("acre","0.0"),
			entry("alagoas","0.0"),
			entry("amapa","0.0"),
			entry("amazonas", "0.0")
											  , entry("bahia","0.0"), entry("ceara","0.0"),
											  entry("distrito_federal","0.0"),
											  entry("espirito_santo","0.0"), entry("goias","0.0"),
											  entry("maranhao","0.0"), entry("mato_grosso","0.0"),
											  entry("mato_grosso_do_sul","0.0"),
											  entry("minas_gerais","0.0"), entry("para","0.0"),
											  entry("paraiba","0.0"), entry("parana","0.0"),
											  entry("pernambuco","0.0"), entry("piaui","0.0"),
											  entry("rio_de_janeiro","0.0"),
											  entry("rio_grande_do_norte","0.0"),
											  entry("rio_grande_do_sul","0.0"),
											  entry("rondonia","0.0"), entry("roraima","0.0"),
											  entry("santa_catarina","0.0"), entry("sao_paulo","0.0"),
											  entry("sergipe","0.0"), entry("tocantins","0.0")
											  );
	
	public static final Map<String, String> STATE_LONG = Map.ofEntries(
			entry("acre","0.0"),
			entry("alagoas","0.0"),
			entry("amapa","0.0"),
			entry("amazonas", "0.0")
											  , entry("bahia","0.0"), entry("ceara","0.0"),
											  entry("distrito_federal","0.0"),
											  entry("espirito_santo","0.0"), entry("goias","0.0"),
											  entry("maranhao","0.0"), entry("mato_grosso","0.0"),
											  entry("mato_grosso_do_sul","0.0"),
											  entry("minas_gerais","0.0"), entry("para","0.0"),
											  entry("paraiba","0.0"), entry("parana","0.0"),
											  entry("pernambuco","0.0"), entry("piaui","0.0"),
											  entry("rio_de_janeiro","0.0"),
											  entry("rio_grande_do_norte","0.0"),
											  entry("rio_grande_do_sul","0.0"),
											  entry("rondonia","0.0"), entry("roraima","0.0"),
											  entry("santa_catarina","0.0"), entry("sao_paulo","0.0"),
											  entry("sergipe","0.0"), entry("tocantins","0.0")
											  );

}
