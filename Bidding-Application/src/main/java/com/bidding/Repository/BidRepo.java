package com.bidding.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidding.Entity.Bid;

public interface BidRepo extends JpaRepository<Bid, Long> {

}
