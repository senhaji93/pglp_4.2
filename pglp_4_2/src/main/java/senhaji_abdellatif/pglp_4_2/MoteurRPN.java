package senhaji_abdellatif.pglp_4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import senhaji_abdellatif.pglp_4_2.command.generic.Undo;
import senhaji_abdellatif.pglp_4_2.command.specific.Addition;
import senhaji_abdellatif.pglp_4_2.command.specific.Division;
import senhaji_abdellatif.pglp_4_2.command.specific.Multiplication;
import senhaji_abdellatif.pglp_4_2.command.specific.Soustraction;
import senhaji_abdellatif.pglp_4_2.command.specific.SpecificCommand;


public final class MoteurRPN {
	
	private Map<String, SpecificCommand> operations;
	
	private Stack<Double> pile;
	private Undo undo;
	
	private MoteurRPN(final Stack<Double> pileOperandes, final Undo undoP) {
		operations = new HashMap<String, SpecificCommand>();
		pile = pileOperandes;
		undo = undoP;
	}
	
	public void addOperande(final double d) {
		pile.push(d);
		undo.alertChange();
	}
	
	public void addCommand(final String name,
			final SpecificCommand command) {
		this.operations.put(name, command);
	}
	
	public boolean executeCommand(final String name) throws Exception {
		if (operations.containsKey(name)) {
			if (pile.size() < 2) {
				System.err.println("nbr d'opérandes "
						+ "dans l'express invalide");
				return false;
			}
			double operande2 = pile.pop();
			double operande1 = pile.pop();
			try {
				pile.push(operations.get(name)
				.opp(operande1, operande2));
				undo.alertChange();
				return true;
			} catch (Exception e) {
				pile.push(operande1);
				pile.push(operande2);
				return false;
			}
		} else {
			
			throw new Exception();
		}
	}
	
	public static MoteurRPN init(final Stack<Double> pile, final Undo u) {
		MoteurRPN m = new MoteurRPN(pile, u);
		m.addCommand("+", new Addition());
                m.addCommand("*", new Multiplication());
		m.addCommand("/", new Division());
		m.addCommand("-", new Soustraction());
		
		return m;
	}
}
