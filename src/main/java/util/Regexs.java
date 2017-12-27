package util;

import java.util.HashMap;

public class Regexs {
	private static Regexs rgxs=null;
	private HashMap<String,String> mapRegex;
	
	private Regexs(){
		buildMap();
	}
	
	public static Regexs getRegexs(){
		if (rgxs==null){
			rgxs=new Regexs();
		}
		return rgxs;
	}
	
	private void buildMap(){
		mapRegex=new HashMap<String, String>();
		mapRegex.put("agregarPais","(?<comando>./agregarPais)-(?<nombre>[a-zA-Z]+)-(?<numero>((?<signo>[+-]{1})([1-9]|1[012]))|0)");
		mapRegex.put("removerPais","(?<comando>./removerPais)-(?<nombre>[a-zA-Z]+)");
		mapRegex.put("horaLocal","(?<comando>./horaLocal)-(?<nombre>[a-zA-Z]+)-(?<hhmm>(?<hora>0[0-9]|1[0-9]|2[0-3]):(?<minuto>[0-5][0-9]))");
	}
	
	public String getRegex(String nombre){
		return mapRegex.get(nombre);
	}
}
