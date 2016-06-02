package model2;

public enum UnaryOperator {
	NOT,ABSENT;
	
	public String toString() {
		switch (this) { 
		case NOT:
			return "!";
			
		}
		return "";
	}
	

}
