package model2;



public class Constraint extends Container {
	
	public Constraint(String Name, Context Parent) {
		super(Name, Parent);
		this.type="constraint";
	}

	public String toString(){
		String res="constraint "+name+"{\n";
		if(this.check!=null)
			res+=check.toString();
		if(this.message!=null)
			res+=message.toString();
		for(Fix f : this.getFixList()){
			res+=f.toString();
		}
		return res;
	}
	

}
