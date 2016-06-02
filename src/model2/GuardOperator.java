package model2;

public enum GuardOperator {
	AND,OR,XOR;
	public String toString(){
		switch (this) {
		case AND:
			return "AND";
		case OR:
			return "OR";
		case XOR:
			return "XOR";
			
			

		
		}
		return "";
	}

}
