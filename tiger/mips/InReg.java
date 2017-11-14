package tiger.mips;

import Tree.AbsExp;
import Tree.TEMP;
import Temp.*;

public class InReg extends tiger.frame.Access {
	Temp temp;
	
	public InReg() {
		temp = new Temp();
	}
	
	public AbsExp exp(AbsExp fp) {
		return new TEMP(temp);
	}
	
}