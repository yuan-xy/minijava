
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import junit.framework.TestCase;
import exception.DuplicateException;
import exception.MismatchException;
import exception.NotDefineException;

public class TypeTest extends TestCase {
	
	public void test1(){
	    try {
	    	parse(".\\test\\error\\1.jav");
	    	fail();
	    }catch(DuplicateException e){
	    	assertTrue(e.getMessage().indexOf("local fac already exsits")!=-1);
	    }
	}
	
	public void test2(){
	    try {
	    	parse(".\\test\\error\\2.jav");
	    	fail();
	    }catch(DuplicateException e){
	    	assertTrue(e.getMessage().indexOf("class Fac already exsits")!=-1);
	    }
	}

	public void test3(){
	    try {
	    	parse(".\\test\\error\\3.jav");
	    	fail();
	    }catch(NotDefineException e){
	    	assertTrue(e.getMessage().indexOf("Fac2 not defined")!=-1);
	    }
	}
	
	public void test4(){
	    try {
	    	parse(".\\test\\error\\4.jav");
	    	fail();
	    }catch(MismatchException e){
	    	assertTrue(e.getMessage().indexOf("type mismatch:int<->boolean")!=-1);
	    }
	}
	
	public void test5(){
	    try {
	    	parse(".\\test\\error\\5.jav");
	    	fail();
	    }catch(MismatchException e){
	    	assertTrue(e.getMessage().indexOf("method ComputeFac argument number mismatch")!=-1);
	    }
	}
	
	private void parse(String file){
	    MiniJava t;
		try {
			t = new MiniJava(new FileInputStream(new File(file)));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		SimpleNode n;
		try {
			n = t.Goal();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		SymbolTableVisitor symbolTable = new SymbolTableVisitor();
		n.jjtAccept(symbolTable, null);
		n.jjtAccept(new TypeCheckVisitor(symbolTable.table), null);
	}
	
}
