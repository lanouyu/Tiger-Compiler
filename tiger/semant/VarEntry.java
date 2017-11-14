package tiger.semant;
import Types.*;

public class VarEntry extends Entry {
	Types.Type type;
	VarEntry(Types.Type t) {
		type = t;
	}
}