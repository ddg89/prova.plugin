package model2;

import java.util.ArrayList;
import java.util.List;

public class Check {
	private List<Operation> operations;
	private Container parent;
	
	public Check(List<Predicate> pList, List<Operation> operations,Container parent) {
		super();
		
		this.parent=parent;
	}

	public Check(){
		
		
	}
	
	public Container getParent() {
		return parent;
	}
	public void setParent(Container parent) {
		this.parent = parent;
	}
	
	
	public String toString(){
		String res = "check{\n";
		//res+=this.getGuards().toString();
		res+="\n}\n";
		
		return res;
		
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	
}
