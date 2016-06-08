package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Check {
	
	
	private List<Operation> operations;
	
	public Check(List<Operation> operations) {
		super();
		this.operations=operations;
	}
	public Check(){
		this.operations=new ArrayList<Operation>();
		
	}
	@XmlElementWrapper
	@XmlElement
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
