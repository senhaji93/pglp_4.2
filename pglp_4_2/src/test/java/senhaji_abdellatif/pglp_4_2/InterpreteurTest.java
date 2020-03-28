package senhaji_abdellatif.pglp_4_2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

import senhaji_abdellatif.pglp_4_2.command.generic.Undo;

public class InterpreteurTest {

	@Test
	public void testInit() {
		Interpreteur i = Interpreteur.init(new Undo(new Stack<Double>()));
	}

	@Test
	public void testCommand() throws Exception {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		Interpreteur i = Interpreteur.init(u);
		i.executeCommand("undo");
	}
	

}
