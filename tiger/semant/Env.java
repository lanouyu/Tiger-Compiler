package tiger.semant;

import com.sun.glass.ui.Window.Level;

import Symbol.*;
import tiger.errormsg.ErrorMsg;
import Types.*;
import Temp.*;
import Util.BoolList;

class Env{
	public Table tEnv = null;
	public Table vEnv = null;
	public ErrorMsg errorMsg = null;
	public Level root = null;
	
	
	Env(Level r, ErrorMsg errorMsg) {
		this.errorMsg =errorMsg;
		this.root = r;
		init_tEnv();				// initial tEnv
		init_vEnv();				// initial vEnv
	}
	
	void init_tEnv() {
		tEnv = new Table();
		tEnv.put(Symbol.symbol("int"), new Types.INT());
		tEnv.put(Symbol.symbol("string"), new Types.STRING());
	}
	
	void init_vEnv() {
		vEnv = new Table();
		
		RECORD formals;
		Type reterntype;
		Label label;
		Level level;
		
		// add standard library
		// function print(s:string)
		formals = new Types.RECORD(Symbol.symbol("s"), (Types.STRING)tEnv.get(Symbol.symbol("string")), null);
		reterntype = new Types.VOID();
		label = new Label();
		vEnv.put(Symbol.symbol("print"), new StdFuncEntry(level, label, formals, reterntype));
		
		// function printi(i:int)
		formals = new Types.RECORD(Symbol.symbol("i"), (Types.INT)tEnv.get(Symbol.symbol("int")), null);
		reterntype = new Types.VOID();
		vEnv.put(Symbol.symbol("printi"), new StdFuncEntry(formals, reterntype));
		
		// function flush()
		formals = null;
		reterntype = new Types.VOID();
		vEnv.put(Symbol.symbol("flush"), new StdFuncEntry(formals, reterntype));
		
		// function getchar():string
		formals = null;
		reterntype = new Types.STRING();
		vEnv.put(Symbol.symbol("getchar"), new StdFuncEntry(formals, reterntype));
		
		// function ord(s:string):int
		formals = new Types.RECORD(Symbol.symbol("s"), (Types.STRING)tEnv.get(Symbol.symbol("string")), null);
		reterntype = new Types.INT();
		vEnv.put(Symbol.symbol("ord"), new StdFuncEntry(formals, reterntype));
		
		// function chr(i:int):string
		formals = new Types.RECORD(Symbol.symbol("i"), (Types.INT)tEnv.get(Symbol.symbol("int")), null);
		reterntype = new Types.STRING();
		vEnv.put(Symbol.symbol("chr"), new StdFuncEntry(formals, reterntype));
		
		// function size(s:string):int
		formals = new Types.RECORD(Symbol.symbol("s"), (Types.STRING)tEnv.get(Symbol.symbol("string")), null);
		reterntype = new Types.INT();
		vEnv.put(Symbol.symbol("size"), new StdFuncEntry(formals, reterntype));
		
		// function substring(s:string, f:int, n:int):string
		formals = new Types.RECORD(Symbol.symbol("s"), (Types.STRING)tEnv.get(Symbol.symbol("string")), 
					new Types.RECORD(Symbol.symbol("f"), new Types.INT(), 
						new Types.RECORD(Symbol.symbol("n"), new Types.INT(), null)));
		reterntype = new Types.STRING();
		vEnv.put(Symbol.symbol("substring"), new StdFuncEntry(formals, reterntype));
		
		// function concat(s1:string, s2:string):string
		formals = new Types.RECORD(Symbol.symbol("s1"), (Types.STRING)tEnv.get(Symbol.symbol("string")), 
					new Types.RECORD(Symbol.symbol("s2"), (Types.STRING)tEnv.get(Symbol.symbol("string")), null));
		reterntype = new Types.STRING();
		vEnv.put(Symbol.symbol("concat"), new StdFuncEntry(formals, reterntype));
		
		// function not(i:int):int
		formals = new Types.RECORD(Symbol.symbol("i"), (Types.INT)tEnv.get(Symbol.symbol("int")), null);
		reterntype = new Types.INT();
		vEnv.put(Symbol.symbol("not"), new StdFuncEntry(formals, reterntype));
		
		// function exit(i:int)
		formals = new Types.RECORD(Symbol.symbol("i"), (Types.INT)tEnv.get(Symbol.symbol("int")), null);
		reterntype = new Types.INT();
		vEnv.put(Symbol.symbol("exit"), new StdFuncEntry(formals, reterntype));
	}
}