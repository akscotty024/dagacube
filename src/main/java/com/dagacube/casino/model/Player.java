package com.dagacube.casino.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player {
	
	    private long id;
	    private long balance;
	    private long amount;
	    private long transactionId;
	    private String transactionType; 
	    private String[] transactions;
	    
	   

	    public Player() {

	    }

	    public Player(long balance,long amount,long transactionId,String transactionType, String[] transactions) {
	        this.balance = balance;
	        this.amount = amount;
	        this.transactionId = transactionId;
	        this.transactionType = transactionType;
	        this.setTransactions(transactions);
	    }

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    public long getId() {
	        return id;
	    }
	    public void setId(long id) {
	        this.id = id;
	    }

	    @Column(name = "balance", nullable = false)
	    public long getBalance() {
	        return balance;
	    }
	    public void setBalance(long balance) {
	        this.balance = balance;
	    }

		public long getAmount() {
			return amount;
		}

		public void setAmount(long amount) {
			this.amount = amount;
		}

		public long getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(long transactionId) {
			this.transactionId = transactionId;
		}

		public String getTransactionType() {
			return transactionType;
		}

		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}

		public String[] getTransactions() {
			return transactions;
		}

		public void setTransactions(String[] transactions) {
			this.transactions = transactions;
		}


}
