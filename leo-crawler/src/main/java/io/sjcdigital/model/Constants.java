package io.sjcdigital.model;

import java.util.Map;
import static java.util.Map.entry; 

public class Constants {
	
	public static final Map<String, String> STATES = Map.ofEntries(
			entry("acre","Acre"),
			entry("alagoas","Alagoas"),
			entry("amapa","Amapá"),
			entry("amazonas","Amazonas"),
			entry("bahia","Bahia"),
			entry("ceara","Ceará"),
			entry("distrito_federal","Distrito Federal"),
			entry("espirito_santo","Espírito Santo"),
			entry("goias","Goiás"),
			entry("maranhao","Maranhão"),
			entry("mato_grosso","Mato Grosso"),
			entry("mato_grosso_do_sul","Mato Grosso do Sul"),
			entry("minas_gerais","Minas Gerais"),
			entry("para","Pará"),
			entry("paraiba","Paraíba"),
			entry("parana","Paraná"),
			entry("pernambuco","Pernambuco"),
			entry("piaui","Piauí"),
			entry("rio_de_janeiro","Rio de Janeiro"),
			entry("rio_grande_do_norte","Rio Grande do Norte"),
			entry("rio_grande_do_sul","Rio Grande do Sul"),
			entry("rondonia","Rondônia"),
			entry("roraima","Roraima"),
			entry("santa_catarina","Santa Catarina"),
			entry("sao_paulo","São Paulo"),
			entry("sergipe","Sergipe"),
			entry("tocantins","Tocantins") );
	
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

}
