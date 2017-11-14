package tiger.semant;

import Absyn.*;
import Types.*;
import Symbol.*;
import tiger.errormsg.ErrorMsg;
import java.util.*;

public class Semant {
	Env env;
	Type newINT = new INT();
	Type newSTR = new STRING();
	Type newNIL = new NIL();
	Type newVOID = new VOID();
	Type newNAME = new NAME(null);
	int level = 0;
	
	Semant(Env e) {
		env = e;
	}
	
	public Semant(ErrorMsg err) {
		this(new Env(err));
	}
	
	private boolean typeEqual(Type t1, Type t2) throws semantException {
		if (t2.actual().coerceTo(t1.actual()) && !(t1.actual().coerceTo(newNIL)))
			return true;
		if (t2.actual().coerceTo(newNIL) && t1.actual() instanceof RECORD)
			return true;
		return false;
	}
	
	private void err(int pos, String msg) {
		env.errorMsg.error(pos, msg);
	}
	
	// translate variable
	Expty transVar(Var v) throws semantException {
		if (v instanceof SimpleVar) {
			return transVar((SimpleVar) v);
		}
		if (v instanceof SubscriptVar) {
			return transVar((SubscriptVar) v);
		}
		if (v instanceof FieldVar) {
			return transVar((FieldVar) v);
		}
		
		err(v.pos, "Translate variable error!");
		throw new semantException();
	}
	// translate simple variable
	Expty transVar(SimpleVar v) throws semantException {
		Entry x = (Entry)env.vEnv.get(v.name);
		if (x instanceof VarEntry) {
			VarEntry ve = (VarEntry)x;
			return new Expty(null, ve.type.actual());
		} else {
			err(v.pos, "No such Simple Variable error!");
			throw new semantException();
		}
	}
	// translate subscript variable
	Expty transVar(SubscriptVar v) throws semantException {
		Expty vt = transVar(v.var);
		Expty it = transExp(v.index);
		if (vt.type instanceof ARRAY) {
			if (it.type.actual().coerceTo(newINT)) {
				ARRAY ar = (ARRAY)vt.type;
				return new Expty(null, ar.element.actual());
			} else {
				err(v.pos, "The subscript of ARRAY should be INT error!");
				throw new semantException();
			} 
		} else {
			err(v.pos, "The subscript variable should be ARRAY error!");
			throw new semantException();
		}
	}
	// translate field variable
	Expty transVar(FieldVar v) throws semantException {
		Expty vt = transVar(v.var);
		if (vt.type instanceof RECORD) {
			RECORD r;
			for (r = (RECORD)vt.type; r != null; r = r.tail) {
				if (r.fieldName == v.field) {
					return new Expty(null, r.fieldType.actual());
				}
			}
			err(v.pos, "No such field variable");
			throw new semantException();
		} else {
			err(v.pos, "The field variable should be RECORD error!");
			throw new semantException();
		}
	}
	
	// translate expression
	Expty transExp(Exp e) throws semantException {
		if (e == null) return null;
		if (e instanceof ArrayExp) {
			return transExp((ArrayExp) e);
		}
		if (e instanceof AssignExp) {
			return transExp((AssignExp) e);
		}
		if (e instanceof BreakExp) {
			return transExp((BreakExp) e);
		}
		if (e instanceof CallExp) {
			return transExp((CallExp) e);
		}
		if (e instanceof ForExp) {
			return transExp((ForExp) e);
		}
		if (e instanceof IfExp) {
			return transExp((IfExp) e);
		}
		if (e instanceof IntExp) {
			return transExp((IntExp) e);
		}
		if (e instanceof LetExp) {
			return transExp((LetExp) e);
		}
		if (e instanceof NilExp) {
			return transExp((NilExp) e);
		}
		if (e instanceof OpExp) {
			return transExp((OpExp) e);
		}
		if (e instanceof RecordExp) {
			return transExp((RecordExp) e);
		}
		if (e instanceof SeqExp) {
			return transExp((SeqExp) e);
		}
		if (e instanceof StringExp) {
			return transExp((StringExp) e);
		}
		if (e instanceof VarExp) {
			return transExp((VarExp) e);
		}
		if (e instanceof WhileExp) {
			return transExp((WhileExp) e);
		}
		err(e.pos, "Translate Expression error!");
		throw new semantException();
	}
	// type-id [ expr ] of expr
	Expty transExp(ArrayExp e) throws semantException {
		Type type = (Type)env.tEnv.get(e.typ);
		if (type == null || !(type.actual() instanceof ARRAY)) {
			err(e.pos, "The ARRAY type should be defined first error!");
			throw new semantException();
		}
		
		Expty e1 = transExp(e.size);
		Expty e2 = transExp(e.init);
		if (!(e1.type.actual().coerceTo(newINT))) {
			err(e.pos, "The subscript should be INT error!");
			throw new semantException();
		}
		
		ARRAY a = (ARRAY)type.actual();
		if (!e2.type.actual().coerceTo(a.element)) {
			err(e.pos, "The type is not same error!");
			throw new semantException();
		}
		return new Expty(null, type);
	}
	// lvalue := expr
	Expty transExp(AssignExp e) throws semantException {
		Expty vt = transVar(e.var);
		Expty et = transExp(e.exp);
		if (e.var instanceof SimpleVar && 
			env.vEnv.get(((SimpleVar)e.var).name) instanceof LoopVarEntry) {
			err(e.pos, "Loop variable should not be assigned error!");
			throw new semantException();
		}
		if (vt.type.actual() instanceof VOID || et.type.actual() instanceof VOID) {
			err(e.pos, "ASSIGN operands should not be VOID error!");
			throw new semantException();
		}
		if (!typeEqual(vt.type, et.type)) {
			err(e.pos, "The variable and expression type should be same error!");
			throw new semantException();
		}
		return new Expty(null, newVOID);
	}
	// break
	Expty transExp(BreakExp e) throws semantException {
		if (level == 0) {
			err(e.pos, "BREAK should be used in loop error!");
			throw new semantException();
		} else {
			return new Expty(null, newVOID);
		}
	}
	// id ( expr-list )
	Expty transExp(CallExp e) throws semantException {
		Entry func = (Entry)env.vEnv.get(e.func);
		if (func == null || !(func instanceof FuncEntry)) {
			err(e.pos, "The function should be declared first error!");
			throw new semantException();
		}
		ExpList args = e.args;
		RECORD formals = ((FuncEntry)func).formals;
		for(; args != null; args = args.tail, formals = formals.tail) {
			if (formals == null) {
				err(e.pos, "The formals number error!");
				throw new semantException();
			}
			if (!transExp(args.head).type.actual().coerceTo(formals.fieldType.actual())) {
				err(e.pos, "The formals type error!");
				throw new semantException();
			}
		}
		if (formals != null) {
			err(e.pos, "The formals number error!");
			throw new semantException();
		}
		return new Expty(null, ((FuncEntry)func).reterntype.actual());
	}
	// for id := expr to expr do expr
	Expty transExp(ForExp e) throws semantException {
		env.vEnv.beginScope();
		env.tEnv.beginScope();
		if (!transExp(e.var.init).type.actual().coerceTo(newINT)) {
			err(e.var.pos, "Loop variable should be INT error!");
			throw new semantException();
		}
		env.vEnv.put(e.var.name, new LoopVarEntry(transExp(e.var.init).type.actual()));
		
		if (!transExp(e.hi).type.actual().coerceTo(newINT)) {
			err(e.hi.pos, "Loop variable should be INT error!");
			throw new semantException();
		}
		level = level + 1;
		
		if (!transExp(e.body).type.actual().coerceTo(newVOID)) {
			err(e.body.pos, "FOR should return VOID error!");
			throw new semantException();
		}
		level = level - 1;
		
		env.vEnv.endScope();
		env.tEnv.endScope();
		return new Expty(null, newVOID);
	}
	// if expr then expr (else expr)
	Expty transExp(IfExp e) throws semantException {
		Expty et = transExp(e.test);
		// System.out.println(et);
		// System.out.println(e.test);
		if (!(et.type.actual().coerceTo(newINT))) {
			err(e.test.pos, "The test expression return type should be INT error!");
			throw new semantException();
		}
		if (e.elseclause == null) {
			if (transExp(e.thenclause).type.actual() instanceof VOID) {
				return new Expty(null, newVOID);
			} else {
				err(e.thenclause.pos, "IF THEN should return VOID error!");
				throw new semantException();
			}
		} else {
			if (typeEqual(transExp(e.thenclause).type.actual(), transExp(e.elseclause).type.actual())) {
				return new Expty(null, transExp(e.elseclause).type.actual());
			} else {
				err(e.thenclause.pos, "THEN clause and ELSE clause should return same type");
				throw new semantException();
			}
		}
	}
	// integer-constant
	Expty transExp(IntExp e) throws semantException {
		return new Expty(null, newINT);
	}
	// let declaration-list in expr-seq end
	Expty transExp(LetExp e) throws semantException {
		env.vEnv.beginScope();
		env.tEnv.beginScope();
		if (e.decs != null) {
			for (DecList dl = e.decs; dl != null; dl = dl.tail) {
				transDec(dl.head);
			}
		}
		Expty et = transExp(e.body);
		env.vEnv.endScope();
		env.tEnv.endScope();
		if (et == null) return new Expty(null, newVOID);
		return new Expty(null, et.type);
	}
	// nil
	Expty transExp(NilExp e) throws semantException {
		return new Expty(null, newNIL);
	}
	// expr binary-operator expr
	Expty transExp(OpExp e) throws semantException {
		Expty l = transExp(e.left);
		Expty r = transExp(e.right);
		switch (e.oper) {
		// + - * /
		case OpExp.PLUS: case OpExp.MINUS: case OpExp.MUL: case OpExp.DIV:
			if (l.type.coerceTo(newINT) && r.type.coerceTo(newINT)) {
				return new Expty(null, newINT);
			} else {
				if (l.type.coerceTo(newINT)) {
					err(e.right.pos, "The right operand should be INT error!");
				} else {
					err(e.left.pos, "The left operand should be INT error!");
				}
				throw new semantException();
			}
		// < <= > >=
		case OpExp.LT: case OpExp.LE: case OpExp.GT: case OpExp.GE:
			if ((l.type.coerceTo(newINT) && r.type.coerceTo(newINT)) ||
					(l.type.coerceTo(newSTR) && r.type.coerceTo(newSTR))) {
				return new Expty(null, newINT);
			} else {
				err(e.pos, "The two operands should be both INT or STRING error!");
				throw new semantException();
			}
		// = !=
		case OpExp.EQ: case OpExp.NE:
			if (!l.type.coerceTo(r.type) && !r.type.coerceTo(l.type)) {
				err(e.pos, "The two operands should be the same type error!");
				throw new semantException();
			}
			if (l.type.coerceTo(newVOID) || r.type.coerceTo(newVOID)) {
				err(e.pos, "The two operands should not be VOID error!");
				throw new semantException();
			}
			if (((l.type.actual() instanceof NIL) && (!(r.type.actual() instanceof RECORD))) ||
					((r.type.actual() instanceof NIL) && (!(l.type.actual() instanceof RECORD)))){
				err(e.pos, "When one operand is NIL, the other should be RECORD error!");
				throw new semantException();
			}
			return new Expty(null, newINT);
		default:
			err(e.pos, "Translate operation expression error!");
			throw new semantException();
		}
	}
	// type-id { field-list }
	Expty transExp(RecordExp e) throws semantException {
		Type type = (Type)env.tEnv.get(e.typ);
		if (type == null || (!(type.actual() instanceof RECORD))) {
			err(e.pos, "The RECORD type should be defined first error!");
			throw new semantException();
		}
		
		FieldExpList fel = e.fields;
		RECORD r = (RECORD)type.actual();
		for (; fel != null; fel = fel.tail, r = r.tail) {
			if (r == null) {
				err(e.pos, "The formals number error!");
				throw new semantException();
			}
			if (fel.name != r.fieldName) {
				err(fel.pos, "The variable should be defined first error!");
				throw new semantException();
			}
			if (!typeEqual(r.fieldType.actual(), transExp(fel.init).type.actual())) {
				err(fel.pos, "The RECORD expression type and assignment should be same error!");
				throw new semantException();
			}
		}
		if (r != null) {
			err(e.pos, "The formals number error!");
			throw new semantException();
		}
		return new Expty(null, type);
	}
	// ( expr-seq )
	Expty transExp(SeqExp e) throws semantException {
		ExpList el;
		Expty res = null;
		for (el = e.list; el != null; el=el.tail) {
			res = transExp(el.head);
		}
		if (res == null) return new Expty(null, newVOID);
		return res;
	}
	// string-constant
	Expty transExp(StringExp e) throws semantException {
		return new Expty(null, newSTR);
	}
	// lvalue
	Expty transExp(VarExp e) throws semantException {
		return transVar(e.var);
	}
	// while expr do expr
	Expty transExp(WhileExp e) throws semantException {
		if (!(transExp(e.test).type.actual().coerceTo(newINT))) {
			err(e.test.pos, "The test clause should be INT error!");
			throw new semantException();
		}
		level = level + 1;
		if (!(transExp(e.body).type instanceof VOID)) {
			err(e.body.pos, "WHILE should return VOID error!");
			throw new semantException();
		}
		level = level - 1;
		return new Expty(null, newVOID);
	}
	
	// translate type
	Type transType(Ty t) throws semantException {
		if (t instanceof NameTy) {
			return transType((NameTy) t);
		}
		if (t instanceof RecordTy) {
			return transType((RecordTy) t);
		}
		if (t instanceof ArrayTy) {
			return transType((ArrayTy) t);
		}
		err(t.pos, "Translate type error!");
		throw new semantException();
	}
	// name type
	Type transType(NameTy t) throws semantException {
		Type res = (Type)env.tEnv.get(t.name);
		if (res == null) {
			err(t.pos, "No such name type error!");
			throw new semantException();
		}
		return res;
	}
	// record type
	Type transType(RecordTy t) throws semantException {
		RECORD r = null, p = null;
		Type temp;
		List <Symbol> dict = new ArrayList <Symbol> ();
		for (FieldList tField = t.fields; tField != null; tField = tField.tail) {
			temp = (Type) (env.tEnv.get(tField.typ));
			if (temp == null) {
				err(t.pos, "The field name should be defined first error!");
				throw new semantException();
			}
			if (dict.contains(tField.name)) {
				err(t.pos, "The field name redefined error!");
				throw new semantException();
			} else {
				dict.add(tField.name);
			}
			if (p == null) {
				r = p = new RECORD(tField.name, temp, null);
			} else {
				p.tail = new RECORD(tField.name, temp, null);
				p = p.tail;
			}
				
		}
		return r;
	}
	// array type
	Type transType(ArrayTy t) throws semantException {
		Type res = (Type)env.tEnv.get(t.typ);
		if (res == null) {
			err(t.pos, "So such array type error!");
			throw new semantException();
		}
		return new ARRAY(res);
	}
	// translate field list
	RECORD transFields(FieldList f) throws semantException {
		RECORD res = null, p = null;
		FieldList fl;
		for (fl = f; fl != null; fl = fl.tail) {
			Type t = ((Type)env.tEnv.get(fl.typ)).actual();
			if (t == null) {
				err(fl.pos, "RECORD should be defined first in field list error!");
				throw new semantException();
			}
			if (p == null) {
				p = new RECORD(fl.name, t, null);
				res = p;
			} else {
				p.tail = new RECORD(fl.name, t, null);
				p = p.tail;
			}
		}
		return res;
	}
	
	// translate declaration
	EXP transDec(Dec d) throws semantException {
		if (d instanceof VarDec) {
			return transDec((VarDec) d);
		}
		if (d instanceof TypeDec) {
			return transDec((TypeDec) d);
		}
		if (d instanceof FunctionDec) {
			return transDec((FunctionDec) d);
		}
		err(d.pos, "Translate declaration error!");
		throw new semantException();
	}
	// variable declaration
	EXP transDec(VarDec d) throws semantException {
		Expty et = transExp(d.init);
		if (d.typ == null) {
			if (et.type.actual() instanceof NIL) {
				err(d.pos, "The variable declaration should not return NIL error!");
				throw new semantException();
			} else {
				env.vEnv.put(d.name, new VarEntry(et.type.actual()));
			} 
		} else {
			if (typeEqual(transType(d.typ).actual(), et.type.actual())) {
				env.vEnv.put(d.name, new VarEntry(transType(d.typ).actual()));
			} else {
				err(d.pos, "The definition and assignment type should be same error!");
				throw new semantException();
			}
		}
		return null;
	}
	// type declaration
	EXP transDec(TypeDec d) throws semantException {
		List<Symbol> dict = new ArrayList<Symbol>();
		TypeDec td;
		for (td = d; td != null; td = td.next) {
			while (dict.contains(td.name)) {
				err(td.pos, "Type " + td.name + " redefined error!");
				td.name = Symbol.symbol(td.name.toString()+"_2");
				err(td.pos, "Rename to "+td.name);
			}
			dict.add(td.name);
			env.tEnv.put(td.name, new NAME(td.name));
		}
		for (td = d; td != null; td = td.next) {
			((NAME)env.tEnv.get(td.name)).bind(transType(td.ty));
		}
		
		for (td = d; td != null; td = td.next) {
			if (((NAME)env.tEnv.get(td.name)).isLoop()) {
				err(td.pos, "The name has been loop error!");
				throw new semantException();
			}
		}
		return null;
	}
	// function declaration
	EXP transDec(FunctionDec d) throws semantException {
		List<Symbol> dict = new ArrayList<Symbol>();
		FunctionDec fd;
		
		for (fd = d; fd != null; fd = fd.next) {
			if (env.vEnv.get(fd.name) != null && (env.vEnv.get(fd.name) instanceof StdFuncEntry)) {
				err(fd.pos, "The function name" + fd.name + "conflicts with stdandard functions error!");
				fd.name = Symbol.symbol("my" + fd.name.toString());
				err(fd.pos, "Rename to " + fd.name);
			}
			while (dict.contains(fd.name)) {
				err(fd.pos, "The function redefined error!");
				fd.name = Symbol.symbol("re" + fd.name.toString());
				err(fd.pos, "Rename to " + fd.name);
			}
			dict.add(fd.name);
			if (fd.result == null) {
				env.vEnv.put(fd.name, new FuncEntry(transFields(fd.params), new VOID()));
			} else {
				env.vEnv.put(fd.name, new FuncEntry(transFields(fd.params), transType(fd.result).actual()));
			}
		}
		
		for (fd = d; fd != null; fd = fd.next) {
			FuncEntry fe = (FuncEntry)env.vEnv.get(fd.name);
			env.vEnv.beginScope();
			for (FieldList p = fd.params; p != null; p = p.tail) {
				Type type= (Type)env.tEnv.get(p.typ);
				if (type == null) {
					err(fd.pos, "The function formals type should be definced first error!");
					throw new semantException();
				} else {
					env.vEnv.put(p.name, new VarEntry(type.actual()));
				}
			}
			
			Expty et = transExp(fd.body);
			env.vEnv.endScope();
			
			if (!typeEqual(fe.reterntype.actual(), et.type.actual())) {
				err(fd.pos, "The return body and type should be same error!");
				throw new semantException();
			}
		}
		return null;
	}
}