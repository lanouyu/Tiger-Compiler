package Tree;
import Temp.Temp;
import Temp.Label;
public class EXP extends Stm {
  public AbsExp exp; 
  public EXP(AbsExp e) {exp=e;}
  public ExpList kids() {return new ExpList(exp,null);}
  public Stm build(ExpList kids) {
    return new EXP(kids.head);
  }
}

