package com.bidding.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidding.Entity.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

}
