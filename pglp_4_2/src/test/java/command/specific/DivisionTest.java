package command.specific;

import static org.junit.Assert.*;

import org.junit.Test;

import senhaji_abdellatif.pglp_4_2.command.specific.Division;

public class DivisionTest {

	@Test
	public void test() throws Exception {
		Division a = new Division();
		assertTrue(a.opp(6.0, 3.0) == 2.0);
	}
	
	@Test (expected = Exception.class)
	public void testEchec() throws Exception {
		Division a = new Division();
		a.opp(6.0, 0.0);
	}
}
