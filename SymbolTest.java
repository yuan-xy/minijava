import java.io.File;
import java.io.FileInputStream;

import junit.framework.TestCase;

public class SymbolTest extends TestCase {

	public void test() throws Exception {
		MiniJava t = new MiniJava(new FileInputStream(
				new File(".\\test\\Factorial.java")));
		SimpleNode n = t.Goal();
		SymbolTableVisitor symVisitor = new SymbolTableVisitor();
		n.jjtAccept(symVisitor, null);
		assertEquals(symVisitor.table.classes.size(), 2);
		assertNotNull(symVisitor.table.classes.get("Factorial"));
		assertNotNull(symVisitor.table.classes.get("Fac"));
		assertEquals(symVisitor.table.classes.get("Fac").methods.size(), 2);
		assertNotNull(symVisitor.table.classes.get("Fac").methods.get("test"));
		assertNotNull(symVisitor.table.classes.get("Fac").methods.get("ComputeFac"));
		assertEquals(symVisitor.table.classes.get("Fac").methods.get("test").params.size(), 0);
		assertEquals(symVisitor.table.classes.get("Fac").methods.get("test").locals.size(), 1);
		assertNotNull(symVisitor.table.classes.get("Fac").methods.get("test").locals.get("fac"));
		assertEquals(symVisitor.table.classes.get("Fac").methods.get("ComputeFac").params.size(), 1);
		assertEquals(symVisitor.table.classes.get("Fac").methods.get("ComputeFac").locals.size(), 2);
		assertNotNull(symVisitor.table.classes.get("Fac").methods.get("ComputeFac").locals.get("num_aux"));
		assertNotNull(symVisitor.table.classes.get("Fac").methods.get("ComputeFac").locals.get("j"));
		assertNotNull(symVisitor.table.classes.get("Fac").methods.get("ComputeFac").params.get("num"));
	}
}
