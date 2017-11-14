package tiger.frame;

import Temp.*;
import Tree.*;
import Util.BoolList;
import Assem.InstrList;

public abstract class Frame implements TempMap {
    public Label name;
    public AccessList formals;

    static final Label error = new Label("error");

    public static Label getError() { return error; }

    abstract public Frame newFrame(Label name, BoolList formals);
    abstract public Access allocLocal(boolean escape);
    abstract public Temp FP();
    abstract public Temp SP();
    abstract public Temp RA();
    abstract public Temp RV();
    abstract public TempList registers();
    abstract public String tempMap(Temp temp);
    abstract public int wordSize();
    abstract public AbsExp externalCall(String func, ExpList args);
    abstract public String string(Label lab, String lit);
    abstract public Stm procEntryExit1(Stm body);
    abstract public InstrList procEntryExit2(InstrList body);
    abstract public Proc procEntryExit3(InstrList body);
    abstract public InstrList codegen(Stm stm);
    //abstract public static String programTail();
}