package model;

public class Message {
	private String text;
	private Container parent;

	public String getName() {
		return text;
	}

	public void setName(String text) {
		this.text = text;
	}

	public Message(String text,Container parent) {
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

	public Container getParent() {
		return parent;
	}

	public void setParent(Container parent) {
		this.parent = parent;
	}

	public String toString(){
		return "message : \""+text+"\" \n";
	}

}
