package DiscordBOT.Shimakaze;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import util.Regexs;
import util.Tiempo;

public class App
{
    public static void main( String[] args )
    {
    
        Shimakaze.getObjectActions();
    	/*Pattern p = Pattern.compile(Regexs.getRegexs().getRegex("horaLocal"));
		Matcher mat = p.matcher("horaLocal-Venezuela-12:00");
		mat.matches();
		System.out.println(mat.group("hora"));*/
  
    }
    
    
    
}
