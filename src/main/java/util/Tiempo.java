package util;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Tiempo {

	
	public static String restarHora(int hora,int minuto,int restHora,int restMin){
		Calendar c = Calendar.getInstance();
    	DateTime dt = new DateTime(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH),hora,minuto);
    	dt=dt.plusHours(restHora);
    	dt=dt.minusMinutes(restMin);
    	DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm");
    	String horaFormateada = dt.toString(dtf);
    	return horaFormateada;
	}
}
