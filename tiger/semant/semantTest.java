package tiger.semant;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import Absyn.*;
import tiger.errormsg.ErrorMsg;
import tiger.parse.*;

public class semantTest {
	public static void main(String[] args) throws FileNotFoundException {
		String filename1 = "testcases/test";
		String filename3 = ".tig";
		for (int i = -1; i < 50; ++i) {
			String filename = filename1 + String.valueOf(i) + filename3;
			ErrorMsg errorMsg = new ErrorMsg(filename);
			InputStream inp = new FileInputStream(filename);
			Yylex lexer = new Yylex(inp, errorMsg);
			parser p = new parser(lexer,errorMsg);
			Semant semant = new Semant(new Env(errorMsg));
			try {
				System.out.println();
				System.out.println(filename);
				p.parse();
				inp.close();
			} catch (Exception e) {
				System.out.println("parse error!");
				//e.printStackTrace();
				continue;
			}
			
			try {
				semant.transExp((Exp)p.parseResult);
			} catch (semantException e) {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
}