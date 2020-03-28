package command.specific;

import static org.junit.Assert.*;

import org.junit.Test;

import senhaji_abdellatif.pglp_4_2.command.specific.Multiplication;

public class MultiplicationTest {

	@Test
	public void test() {
		Multiplication a = new Multiplication();
		assertTrue(a.opp(1.0, 1.0) == 1.0);
	}
}
