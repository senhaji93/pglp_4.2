package senhaji_abdellatif.pglp_4_2;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Test;

public class CalculatriceRPNTest {
	
	InputStream stdin = System.in;
	
	@After
	public void tearDown() throws Exception {
		System.setIn(stdin);
	}
	
	
}
