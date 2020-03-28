package senhaji_abdellatif.pglp_4_2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

import senhaji_abdellatif.pglp_4_2.command.generic.Undo;

public class MoteurRPNTest {

	@Test
	public void testInit() {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		MoteurRPN moteur = MoteurRPN.init(p, u);
	}

	@Test
	public void testAjoutOperande() {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		MoteurRPN moteur = MoteurRPN.init(p, u);
		moteur.addOperande(5.2);
		assertTrue(p.pop() == 5.2 && p.isEmpty());
	}
	
	@Test (expected = Exception.class)
	public void testCommandInconnu() throws Exception {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		MoteurRPN moteur = MoteurRPN.init(p, u);
		moteur.addOperande(5.2);
		moteur.addOperande(5.2);
		moteur.executeCommand("p");
	}
	
	@Test
	public void testAddition() throws Exception {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		MoteurRPN moteur = MoteurRPN.init(p, u);
		moteur.addOperande(15.2);
		moteur.addOperande(15.2);
		moteur.executeCommand("+");
		assertTrue(p.pop() == 30.4 && p.isEmpty());
	}
	
	@Test
	public void testEchecCalcul() throws Exception {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		MoteurRPN moteur = MoteurRPN.init(p, u);
		moteur.addOperande(5.2);
		assertFalse(moteur.executeCommand("+"));
	}
	
	
	
	@Test
	public void testMultiplication() throws Exception {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		MoteurRPN moteur = MoteurRPN.init(p, u);
		moteur.addOperande(5);
		moteur.addOperande(5);
		moteur.executeCommand("*");
		assertTrue(p.pop() == 25.0 && p.isEmpty());
	}
	@Test
	public void testDivisionEchec() throws Exception {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		MoteurRPN moteur = MoteurRPN.init(p, u);
		moteur.addOperande(5.2);
		moteur.addOperande(0);
		assertFalse(moteur.executeCommand("/"));
	}
	@Test
	public void testDivision() throws Exception {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		MoteurRPN moteur = MoteurRPN.init(p, u);
		moteur.addOperande(10.2);
		moteur.addOperande(10.2);
		moteur.executeCommand("+");
		assertTrue(p.pop() == 20.4 && p.isEmpty());
	}
	@Test
	public void testSoustraction() throws Exception {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		MoteurRPN moteur = MoteurRPN.init(p, u);
		moteur.addOperande(5.2);
		moteur.addOperande(5.2);
		moteur.executeCommand("-");
		assertTrue(p.pop() == 0.0 && p.isEmpty());
	}
	
}
