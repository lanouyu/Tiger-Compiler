package Tree;
import Temp.Temp;
import Temp.Label;
public class ESEQ extends AbsExp {
  public Stm stm;
  public AbsExp Expr;
  public ESEQ(Stm s, AbsExp e) {stm=s; Expr=e;}
  public ExpList kids() {throw new Error("kids() not applicable to ESEQ");}
  public AbsExp build(ExpList kids) {throw new Error("build() not applicable to ESEQ");}
}

