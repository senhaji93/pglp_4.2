package senhaji_abdellatif.pglp_4_2;
import senhaji_abdellatif.pglp_4_2.command.generic.GenericCommand;
import senhaji_abdellatif.pglp_4_2.command.generic.Quit;
import senhaji_abdellatif.pglp_4_2.command.generic.Undo;
import java.util.HashMap;
import java.util.Map;


public final class Interpreteur {
	
	private Map<String, GenericCommand> commands;
	
	private Interpreteur() {
		commands = new HashMap<String, GenericCommand>();
	}
	
	public void addCommand(final String name,
	final GenericCommand command) {
		this.commands.put(name, command);
	}
	
	public void executeCommand(final String name) throws Exception {
		if (commands.containsKey(name)) {
			try {
				commands.get(name).opp();
			} catch (Exception e) {
				System.err.println("La commande mal passer");
			}
		} else {
			throw new Exception();
		}
	}	
	public static Interpreteur init(final Undo u) {
		Interpreteur i = new Interpreteur();
		i.addCommand("undo", u);
		i.addCommand("quit", new Quit());
		return i;
	}
}
