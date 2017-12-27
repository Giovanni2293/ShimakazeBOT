package objDiscord;

import DiscordBOT.Shimakaze.Shimakaze;
import net.dv8tion.jda.core.entities.Emote;

public abstract class EmoteJD implements Emote {

	private String nombre;
	private String id;
	private Shimakaze shimakaze;

	public EmoteJD(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
		shimakaze = Shimakaze.getObjectActions();
	}

	public String getNombre() {
		return nombre;
	}

	public String getId() {
		return id;
	}

}
