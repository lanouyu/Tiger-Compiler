package Tree;
import Temp.Temp;
import Temp.Label;
public class MEM extends AbsExp {
  public AbsExp exp;
  public MEM(AbsExp e) {exp=e;}
  public ExpList kids() {return new ExpList(exp,null);}
  public AbsExp build(ExpList kids) {
    return new MEM(kids.head);
  }
}

