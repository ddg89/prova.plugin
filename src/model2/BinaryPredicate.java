package model2;

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
		return left.toString()+op.toString()+right.toString();
	}
		

}
