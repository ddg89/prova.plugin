package model.copy;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class F extends Threshold{
	private String  card;
	public F(String text , String card) {
		super(text);
		this.card = card;
	}
	public F(){
		super();
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
}
