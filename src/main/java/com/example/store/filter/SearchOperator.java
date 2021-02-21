package com.example.store.filter;

public enum SearchOperator {
	EQUALITY, GREATER_THAN, LESS_THAN;

	public static SearchOperator getSimpleOperation(String input) {
		switch (input) {
			case ">":
				return GREATER_THAN;
			case "<":
				return LESS_THAN;
			case ":":
			default:
				return EQUALITY;
		}
	}
}
