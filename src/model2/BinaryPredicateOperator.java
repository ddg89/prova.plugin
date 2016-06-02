package model2;

public enum BinaryPredicateOperator {
	GREATER, GREATER_OR_EQUAL, LOWER, LOWER_OR_EQUAL, EQUAL, DIFFERENT;
	public String toString() { 
		switch (this) {
		case GREATER:
			return">";
		case GREATER_OR_EQUAL:
			return">=";
		case LOWER:
			return "<";
		case LOWER_OR_EQUAL:
			return "<=";
		case EQUAL:
			return "=";
		case DIFFERENT:
			return "<>";
		}
	return "";
	}
	

}
