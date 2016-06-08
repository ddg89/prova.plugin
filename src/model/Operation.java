package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Operation {
	private GuardOperator op ; 
	private Predicate predicate;
	
	public Operation(GuardOperator op, Predicate predicate ){
		this.op = op;
		this.predicate = predicate;
	}
	public Operation(){
		
	}
	public GuardOperator getOp() {
		return op;
	}
	public void setOp(GuardOperator op) {
		this.op = op;
	}
	public Predicate getPredicate() {
		return predicate;
	}
	public void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}
	public String toString(){
		return op.toString()+predicate.toString();
	}

}
