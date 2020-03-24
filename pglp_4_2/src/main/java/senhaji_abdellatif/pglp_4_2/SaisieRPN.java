package senhaji_abdellatif.pglp_4_2;

import java.util.Scanner;
import java.util.Stack;

import senhaji_abdellatif.pglp_4_2.command.generic.Undo;


public class SaisieRPN {
	
	private MoteurRPN moteur;
	
	private Interpreteur interprete;
	
	private Stack<Double> pile;
	
	private Scanner s;
	
	public SaisieRPN() {
		pile = new Stack<Double>();
		Undo u = new Undo(pile);
		u.alertChange();
		moteur = MoteurRPN.init(pile, u);
		interprete = Interpreteur.init(u);
	}
	
	public double calcul() throws Exception {
		s = new Scanner(System.in);
		double d;
		boolean continuer = true;
		String line = "";
		System.out.print("cmd passe : \n"
		+ "- un nombre séparée d'une virgule\n"
		+ "- opération {+,-,*,/}\n"
		+ "- \"undo\" pour revenir \n"
		+ "- \"quit\" quitter\n>");
		while (continuer) {
			try {
				d = s.nextDouble();
				moteur.addOperande(d);
			} catch (java.util.InputMismatchException e) {
				line = s.nextLine();
				try { 
					moteur.executeCommand(line);
				} catch (Exception m) {
					try {
						
						interprete.executeCommand(line);
					} catch (Exception i) {
						System.err.println(
						"resaisi bien la cmd/"
						+ "reconnue");
					}
				}
			}
			if (line.equalsIgnoreCase("quit")) {
				continuer = false;
			} else {
				System.out.print(
				"\nExpression : " + pile + "\n>");
				
			}
		}
		s.close();
		
		if (pile.size() != 1) {
			System.err.println(
			"L'expression a un seul nbr");
			throw new Exception();
		}
		
		System.out.println("rst : " + pile);
		return pile.pop();
	}
}
