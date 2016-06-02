package model2;

public class Message {
	private String text;
	private Critique parent;

	public String getName() {
		return text;
	}

	public void setName(String text) {
		this.text = text;
	}

	public Message(String text,Critique parent) {
		super();
		this.text = text;
		this.parent = parent;
	}
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Critique getParent() {
		return parent;
	}

	public void setParent(Critique parent) {
		this.parent = parent;
	}

	public String toString(){
		return "message : \""+text+"\" \n";
	}

}
