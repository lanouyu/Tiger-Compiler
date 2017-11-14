package tiger.translate;

import tiger.frame.*;
import Util.BoolList;
public class Level {
	public Frame frame;
	public Level parent;
	public AccessList formals;

	public Access staticLink() {
		return formals.head;
	}
	
	public Level(Level parent, Symbol.Symbol name, BoolList fmls) {
		this.frame = parent.frame.newFrame(new Temp.Label(name), new BoolList(true, fmls));
		this.parent = parent;
		
		for (AccessList f = frame.formals; f != null; f = f.next) {
			this.formals = new AccessList(new Access(this, f.head), this.formals);
		}
	}

	public Level(Frame f) {
		frame = f;
	}

	public Access allocLocal(boolean escape) {
		return new Access(this, frame.allocLocal(escape));
	}

	//public Access allocArguLocal(boolean escape) {
	//	return new Access(this, frame.allocArguLocal(escape));
	//}
}