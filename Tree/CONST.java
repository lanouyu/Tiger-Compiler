package Tree;
import Temp.Temp;
import Temp.Label;
public class CONST extends AbsExp {
  public int value;
  public CONST(int v) {value=v;}
  public ExpList kids() {return null;}
  public AbsExp build(ExpList kids) {return this;}
}

