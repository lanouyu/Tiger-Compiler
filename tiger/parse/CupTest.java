package tiger.parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import Absyn.Exp;
import Absyn.Print;
import tiger.errormsg.ErrorMsg;

public class CupTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//String filename1 = "testcases/test";
		String filename1 = "testcases/More/Good/test";
		String filename3 = ".tig";
		for (int i = 1; i < 59; ++i) {
			String filename = filename1 + String.valueOf(i) + filename3;
			ErrorMsg errorMsg = new ErrorMsg(filename);
			InputStream inp = new FileInputStream(filename);
			Yylex lexer = new Yylex(inp, errorMsg);
			parser p = new parser(lexer,errorMsg);
			try {
				System.out.println();
				System.out.println(filename);
				p.parse();
				Exp Abs = p.parseResult;
				new Print(System.out).prExp(Abs, 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
