package model;

import java.util.ArrayList;
import java.util.List;

public class Check {
	

	private List<Operation> operations;
	private Container parent;
	
	public Check(List<Operation> operations,Container parent) {
		super();
		this.operations=operations;
		this.parent=parent;
	}
	public Check() {
		
	}
	public Check(Container parent){
		this.operations=new ArrayList<Operation>();
		this.parent = parent;
		
	}
	public void addOperation(Operation op){
		this.operations.add(op);
	}
	public void removeOperation(Operation op){
		this.operations.remove(op);
	}
	public Container getParent() {
		return parent;
	}
	public void setParent(Container parent) {
		this.parent = parent;
	}
	
	
	public String toString(){
		String res = "check{\n";
		for(Operation op : this.getOperations()){
			res+=op.toString();
		}
		;
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
