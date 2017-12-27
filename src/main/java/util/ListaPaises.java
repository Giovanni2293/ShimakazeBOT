package util;

import java.util.HashMap;

public class ListaPaises {

	private HashMap<String,Pais> paises;
	private static ListaPaises listaPaises=null;
	
	private ListaPaises(){
		paises = new HashMap<String, Pais>();
	}
	
	public void agregarPais(String nombre,Pais pais){
		nombre=nombre.toUpperCase();			
		paises.put(nombre, pais);
	}
	
	public void quitarPais(String nombre){
		nombre = nombre.toUpperCase();
		paises.remove(nombre);
	}
	
	public Pais obtenerPais(String nombre){
		nombre = nombre.toUpperCase();
		return paises.get(nombre);
	}
	
	public static ListaPaises obtenerLista(){

		if (listaPaises==null){
			listaPaises=new ListaPaises();
		}
		
		return listaPaises;
		
	}

	public String mapa() {
		// TODO Auto-generated method stub
		return paises.toString();
	}
	
}
