package tiger.semant;

import Types.*;

public class FuncEntry extends Entry {
	RECORD formals;
	Type reterntype;
	public FuncEntry(RECORD f, Type r) {
		formals = f;
		reterntype = r;
	}
}