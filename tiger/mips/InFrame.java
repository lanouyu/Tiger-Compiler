package tiger.mips;

import Tree.*;

public class InFrame extends tiger.frame.Access {
	int offset;

	InFrame(int off) {
		super();
		offset = off;
	}

	public AbsExp exp(AbsExp framePtr) {
		return new MEM(new BINOP(BINOP.PLUS, framePtr, new CONST(offset)));
	}
}
