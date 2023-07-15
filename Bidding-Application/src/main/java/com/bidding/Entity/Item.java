package com.bidding.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// Other item properties and relationships

	@OneToMany(mappedBy = "item")
	private List<Bid> bids = new ArrayList<>();

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(Long id, String name, List<Bid> bids) {
		super();
		this.id = id;
		this.name = name;
		this.bids = bids;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
}
