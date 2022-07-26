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
	   

	    public Player() {

	    }

	    public Player(long balance) {
	        this.balance = balance;
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

}
