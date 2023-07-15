package com.bidding.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	@OneToMany(mappedBy = "user")
	private List<Bid> bids = new ArrayList<>();
	
	
	// Constructors, getters, and setters
	
	public User() {
		super();
		
	}

	public User(Long id, String username, List<Bid> bids) {
		super();
		this.id = id;
		this.username = username;
		this.bids = bids;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;                  
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	
	
}
