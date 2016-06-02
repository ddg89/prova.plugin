package model2;

public class UnaryOp extends Operation {
	
	private Predicate predicate;
	public UnaryOp(Predicate p){
		this.predicate=p;
	}
	public String toString(){
		return predicate.toString();
	}

}
