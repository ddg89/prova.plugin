package model;

import javax.xml.bind.annotation.XmlElement;

public class BinaryPredicate extends Predicate {
	private F left;
	private Threshold right;
	private BinaryPredicateOperator op;
	public BinaryPredicate(F left, Threshold right, BinaryPredicateOperator op){
		this.left =left;
		this.right = right;
		this.op=op;
	}
	
	public F getLeft() {
		return left;
	}
	@XmlElement
	public void setLeft(F left) {
		this.left = left;
	}
	public Threshold getRight() {
		return right;
	}
	@XmlElement
	public void setRight(Threshold right) {
		this.right = right;
	}
	public BinaryPredicateOperator getOp() {
		return op;
	}
	@XmlElement
	public void setOp(BinaryPredicateOperator op) {
		this.op = op;
	}
	public String toString(){
		return " "+left.toString()+op.toString()+right.toString()+" ";
	}	

}
