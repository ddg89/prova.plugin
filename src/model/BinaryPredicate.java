package model;

public class BinaryPredicate extends Predicate {
	private F left;
	private Threshold right;
	private BinaryPredicateOperator op;
	public BinaryPredicate(F left, Threshold right, BinaryPredicateOperator op){
		this.left =left;
		this.right = right;
		this.op=op;
	}
	public String toString(){
		return " "+left.toString()+op.toString()+right.toString()+" ";
	}
	public F getLeft() {
		return left;
	}
	public void setLeft(F left) {
		this.left = left;
	}
	public Threshold getRight() {
		return right;
	}
	public void setRight(Threshold right) {
		this.right = right;
	}
	public BinaryPredicateOperator getOp() {
		return op;
	}
	public void setOp(BinaryPredicateOperator op) {
		this.op = op;
	}
		

}
