package model2;

public class UnaryPredicate extends Predicate {
	private UnaryOperator op;
	private F f;
	public UnaryPredicate(UnaryOperator op , F f){
		this.op=op;
		this.f = f;
	}
	public String toString(){
		return op.toString()+f.toString();
	}
	public UnaryOperator getOp() {
		return op;
	}
	public void setOp(UnaryOperator op) {
		this.op = op;
	}
	public F getF() {
		return f;
	}
	public void setF(F f) {
		this.f = f;
	}
}
