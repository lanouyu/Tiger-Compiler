package Tree;

public class TEMP extends AbsExp {
  public Temp.Temp temp;
  public TEMP(Temp.Temp t) {temp=t;}
  public ExpList kids() {return null;}
  public AbsExp build(ExpList kids) {return this;}
}

