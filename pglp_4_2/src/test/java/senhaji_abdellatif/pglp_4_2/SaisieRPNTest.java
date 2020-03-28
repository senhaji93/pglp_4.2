package senhaji_abdellatif.pglp_4_2;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Test;

public class SaisieRPNTest {

	InputStream stdin = System.in;
	
	@After
	public void tearDown() throws Exception {
		System.setIn(stdin);
	}
	

	
	@Test
	public void testEchecCalcul() throws Exception {
		String expression = "8\n4\n15\n12\n2\n+\n-\n*\n/\n+\nquit\n";
		System.setIn(new ByteArrayInputStream(expression.getBytes()));
		SaisieRPN s = new SaisieRPN();
		s.calcul();
	}
	
	
}
