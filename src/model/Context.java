package model;



public class Context {
	private String name;
	private Container container;
	private Evl2 parent;
	protected boolean isSetContainer;
	
	public Context(String name, Container c, Evl2 parent) {
		super();
		this.name = name;
		this.container = c;
		this.parent = parent;
		
	}
	public Context(String name, Constraint c, Evl2 parent) {
		super();
		this.name = name;
		this.container = c;
		this.parent = parent;
		
	}
	public Context(String contextName, Evl2 parent) {
		this.parent=parent;
		this.name=contextName;
		
		//this.Container = new Container();
		//this.isSetContainer=false;
	}
	public Context(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Container getContainer() {
		if(this.container==null)
			return null;
		return  this.container;
	}
	public void setContainer(Container c) {
		this.container = c;
		
	}
	public void removeContainer(Container c){
		if (this.container.equals(c)) {
			this.container=null;
		}
	}
	public void addOperationToCheck (Container container, Check check ,Operation op){
		if (this.getContainer().equals(container)) {
			this.container.addOperationToCheck(op, check);
		}
	}
	public void removeOperationFromCheck(Container container, Check check ,Operation op){
		if(this.getContainer().equals(container)){
			this.container.removeOperationFromCheck(op, check);
		}
	}
	public void setContainerMessage(Container Container, Message msg){
		if (this.getContainer().equals(Container)) {
			this.container.setMessage(msg);
		}
	}
	public void removeContainerMessage(Container Container){
		if(this.getContainer().equals(Container))
			this.container.removeMessage();
	}
	public void addFix(Container Container , Fix fix){
		if (this.getContainer().equals(Container)) {
			this.container.addFix(fix);
		}
	}
	public void removeFix(Container Container , Fix fix){
		if (this.getContainer().equals(Container)) {
			this.container.removeFix(fix);
		}
	}
	public Evl2 getParent() {
		return parent;
	}
	public void setParent(Evl2 parent) {
		this.parent = parent;
	}
	
	public void removeCheck(Container c , Check check){
		if(this.container.equals(c)){
			if(c.getCheck().equals(check)){
				c.removeCheck();
			}
		}
	}
	public void removeTitleFromFix(Container container , Fix fix){
		if (this.getContainer().equals(container)) {
			this.container.removeTitleFromFix(fix);
		}
	}
	public void removeDoFromFix(Fix f ,Container crit, Do d){
		if(this.getContainer().equals(crit)){
		for(Fix fix : this.getContainer().getFixList()){
			if(fix.equals(f)){
				fix.removeDo(d);
			}
		}
		}
	}
	
	public String toString(){
		String res="";
		res+="context "+this.getName()+"{\n";
		
			if (container!=null)
				res+=this.getContainer().toString();
				
		
		
		res+="}\n";
		return res;
	}
}
