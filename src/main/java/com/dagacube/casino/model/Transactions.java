package com.dagacube.casino.model;


public class Transactions {
	
	    private String[] transactionTypes;
	
	
	    public Transactions() {

	    }

	    public Transactions(String[] transactionTypes) {
	        this.setTransactionTypes(transactionTypes);
	       
	    }

		public String[] getTransactionTypes() {
			return transactionTypes;
		}

		public void setTransactionTypes(String[] transactionTypes) {
			this.transactionTypes = transactionTypes;
		}
	    
	    
	    
}
