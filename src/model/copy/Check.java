package model.copy;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Check {
	
	@XmlElementWrapper(name = "operationList")
	@XmlElement(name = "operation")
	private List<Operation> operations;
	private Container parent;
	
	public Check() {
		
	}
	public Check(List<Operation> operations,Container parent) {
		super();
		this.operations=operations;
		this.parent=parent;
	}
	public Check(Container parent){
		this.operations=new ArrayList<Operation>();
		this.parent = parent;
		
	}
	public Container getParent() {
		return parent;
	}
	public void setParent(Container parent) {
		this.parent = parent;
	}
	
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
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

	
}
