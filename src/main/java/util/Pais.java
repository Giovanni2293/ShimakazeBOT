package util;

public class Pais {

	private int UTC;
	private String nombre;
	
	
	
	public Pais(int uTC, String nombre) {
		UTC = uTC;
		this.nombre = nombre.toUpperCase();
	}
	
	public int getUTC() {
		return UTC;
	}
	public void setUTC(int uTC) {
		UTC = uTC;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
	
	
	
}
