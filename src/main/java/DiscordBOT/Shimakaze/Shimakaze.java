package DiscordBOT.Shimakaze;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.ListaPaises;
import util.Pais;
import util.Regexs;
import util.Tiempo;

public class Shimakaze extends ListenerAdapter {

	private String commands;
	private Message msg;
	private MessageChannel msgC;
	private User user;
	private static JDA shimakazeBOT;
	private static Shimakaze actions;
	private ListaPaises paises;

	private Shimakaze() throws LoginException, IllegalArgumentException, InterruptedException, RateLimitedException {
		msg = null;
		msgC = null;
		user = null;
		commands = "";
	}

	public synchronized static Shimakaze getObjectActions() {
		if (actions == null) {
			System.out.println("Me creo 1 Vez");
			try {
				actions = new Shimakaze();
				shimakazeBOT = new JDABuilder(AccountType.BOT)
						.setToken("Mzk1Mzc2MjY5NzQ0OTMwODE3.DSR-Xg.zFsBWRGdhqfuUNb5TzycNicYbL4").buildBlocking();
				shimakazeBOT.addEventListener(actions);

			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RateLimitedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return actions;
	}

	public String help() {
		commands = "Escribe Gunthor para una aclaracion especial";
		commands = commands + "\n";
		commands = commands
				+ "Para obtener ayuda sobre como utilizar el mago fuego utiliza el comando !GuiaDeMagoFuego";
		return commands;
	}

	@Override
	public synchronized void onMessageReceived(MessageReceivedEvent e) {

		msg = e.getMessage();
		msgC = e.getChannel();
		user = e.getAuthor();

		String msgString = msg.getContent();
		// agregarPais-Colombia--5
		if (comparar(msgString, Regexs.getRegexs().getRegex("agregarPais"))) {
			String Sn = cadena(msgString,Regexs.getRegexs().getRegex("agregarPais"),"numero");
			String nombre = cadena(msgString,Regexs.getRegexs().getRegex("agregarPais"),"nombre");
			int n = new Integer(Sn);
			Pais p = new Pais(n, nombre);
			ListaPaises.obtenerLista().agregarPais(nombre, p);
			msgC.sendMessage("weee " + user.getAsMention()).queue();

		} else {
			if (comparar(msgString, "./shutdown")) {
				shutDown();
			} else {
				if (comparar(msgString,Regexs.getRegexs().getRegex("horaLocal"))) {
					System.out.println("HoraLocal");
					String horaCompletaServer = cadena(msgString,Regexs.getRegexs().getRegex("horaLocal"),"hhmm");
				    String ShoraServer = cadena(msgString,Regexs.getRegexs().getRegex("horaLocal"),"hora");
				    String SminutoServer = cadena(msgString,Regexs.getRegexs().getRegex("horaLocal"),"minuto");
				    int horaServer,minutoServer;
				    horaServer = new Integer(ShoraServer);
				    minutoServer=new Integer(SminutoServer);
					String paisLocal = cadena(msgString,Regexs.getRegexs().getRegex("horaLocal"),"nombre");
					paisLocal = paisLocal.toUpperCase();
					String horaLocal="";
					Pais pl = ListaPaises.obtenerLista().obtenerPais(paisLocal);
					if (pl!=null)
					{
						horaLocal=Tiempo.restarHora(horaServer, minutoServer,pl.getUTC()-1,0);
						msgC.sendMessage(user.getAsMention()+"La hora de tu pais para las "+horaCompletaServer+" horas server es "+horaLocal).queue();
					}
					else
					{
						msgC.sendMessage("No has agregado el pais").queue();
					}
					
				}
			}
			if (comparar(msgString, "./ayuda")){
				msgC.sendMessage("Ohayou! "+user.getAsMention()+" para poder hablar conmigo puedes usar estos comandos: \n" ).queue();
				msgC.sendMessage("```./agregarPais-nombrePais-utcdetupais ->por ejemplo (./agregarPais-Colombia--5)```").queue();
				msgC.sendMessage("```./horaLocal-nombrePais-horaServer ->por ejemplo (./horaLocal-Colombia-05:30)```").queue();
			}
		}

	}

	public String Cores(int n) {

		String m = "";
		// System.out.println(shimakazeBOT.getRoles());
		// System.out.println(shimakazeBOT.getRoleById("355035179695210507"));
		switch (n) {
		case 1:
			m = " | Firelands Heroic Core #1 - 1:30AM SVT \n" + "Tanks: Argmarh / Gunthor \n"
					+ "Healers: Mæs / Perfume \n" + "DPS:  Akkø / Loki / Pxntera / Sephiroth / Holdias / Casteer \n"
					+ "Traten de llegar y comer antes de la raid. Gambate!! ";
			break;
		case 2:
			m = " | Firelands Heroic Core #2 - 2:00 AM SVT \n" + "Tanks: Brigida / Glandorf \n"
					+ "Healers: Lalaürie / Qwërty \n "
					+ "DPS: Ahagon / Aznag / Cocosette / Sephi / Andromedaa / Crossæter \n"
					+ "Traten de llegar y comer antes de la raid. Gambate!! ";
			break;
		}

		return m;

	}

	public long PingTest() {
		return shimakazeBOT.getPing();
	}

	public void Lagthor() {
		msgC.sendMessage("Did u mean Lagthor " + user.getAsMention() + "?").queue();
	}

	public String mago() {
		return "https://eu.battle.net/forums/es/wow/topic/3225585815";
	}

	public void shutDown() {
		shimakazeBOT.shutdown();
	}

	public static void saludarUNO() {
		// System.out.println(shimakazeBOT.getTextChannels());
		shimakazeBOT.getTextChannelById("354732633193709568").sendMessage(new MessageBuilder()
				.append("!Ohayou Gozaimasu MINA!").append(shimakazeBOT.getEmoteById("355834302656937987")).build())
				.queue();
		// System.out.println(shimakazeBOT.getEmotes());
		// shimakazeBOT.getTextChannelById("354732633193709568").sendMessage(new
		// MessageBuilder().append(shimakazeBOT.getRoleById("355034689708228618")).build()).queue();
	}

	public static void saludarTODOS() {
		List<TextChannel> l = shimakazeBOT.getTextChannels();
		Iterator<TextChannel> i = l.iterator();
		while (i.hasNext()) {
			TextChannel t = i.next();
			shimakazeBOT.getTextChannelById(t.getId()).sendMessage("ohayou gozaimasu Mina!").queue();
		}
	}

	private boolean comparar(String texto, String patron) {
		Pattern p = Pattern.compile(patron);
		Matcher mat = p.matcher(texto);
		return mat.matches();
	}

	private String cadena(String texto, String patron, String segmento) {
		Pattern p = Pattern.compile(patron);
		Matcher mat = p.matcher(texto);
		mat.matches();
		return mat.group(segmento);
	}

}
