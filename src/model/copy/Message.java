package model.copy;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private String text;
	private Container parent;

	

	public Message(String text,Container parent) {
		super();
		this.text = text;
		this.parent = parent;
	}
	public Message() {
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
