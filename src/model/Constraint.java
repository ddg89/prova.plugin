package model;



public class Constraint extends Container {
	
	public Constraint(String Name) {
		super(Name);
		this.type="constraint";
	}

	public String toString(){
		String res="constraint "+name+"{\n";
		if(this.check!=null)
			res+="\t\t"+check.toString();
		if(this.message!=null)
			res+="\t\t"+message.toString();
		for(Fix f : this.getFixList()){
			res+="\t\t"+f.toString();
		}
		res +="\n\t}"; 
		return res;
	}
	

}
