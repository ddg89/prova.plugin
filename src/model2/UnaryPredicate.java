package model2;

public class UnaryPredicate extends Predicate {
	private UnaryOperator op;
	private F booleanF;
	public UnaryPredicate(UnaryOperator op , F f){
		this.op=op;
		this.booleanF = f;
	}
	public String toString(){
		return op.toString()+booleanF.toString();
	}
}
