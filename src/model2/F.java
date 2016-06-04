package model2;

public class F extends Threshold{
	private String  card;
	public F(String text , String card) {
		super(text);
		this.card = card;
		// TODO Auto-generated constructor stub
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
