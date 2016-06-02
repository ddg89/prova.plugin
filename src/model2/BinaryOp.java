package model2;

public class BinaryOp extends Operation {
	private Predicate RPredicate;
	private GuardOperator op;
	public BinaryOp(Predicate p,GuardOperator op){
		this.RPredicate = p;
		this.op = op;
	}
	public String toString(){
		return op.toString()+RPredicate.toString();
		
	}

}
