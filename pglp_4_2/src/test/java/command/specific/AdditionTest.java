package command.specific;

import static org.junit.Assert.*;

import org.junit.Test;

import senhaji_abdellatif.pglp_4_2.command.specific.Addition;

public class AdditionTest {
	@Test
	public void test() {
		Addition a = new Addition();
		assertTrue(a.opp(1.0, 1.0) == 2.0);
	}
}
