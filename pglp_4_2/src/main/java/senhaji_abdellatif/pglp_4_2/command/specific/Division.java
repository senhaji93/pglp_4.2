package senhaji_abdellatif.pglp_4_2.command.specific;


public class Division implements SpecificCommand {

	public double opp(final double operande1, final double operande2)
			throws Exception {
		if (operande2 == 0) {
			System.err.println("Div par 0 !!");
			throw new Exception();
		}
		return operande1 / operande2;
	}
}
