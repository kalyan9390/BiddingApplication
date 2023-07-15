package com.bidding.Service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bidding.Entity.Bid;
import com.bidding.Entity.Item;
import com.bidding.Entity.User;
import com.bidding.Repository.BidRepo;
import com.bidding.Repository.ItemRepo;
import com.bidding.Repository.UserRepo;

@Service
public class BidService {

	private final BidRepo bidRepo;
	private final ItemRepo itemRepo;
	private final UserRepo userRepo;

	public BidService(BidRepo bidRepo, ItemRepo itemRepo, UserRepo userRepo) {
		this.bidRepo = bidRepo;
		this.itemRepo = itemRepo;
		this.userRepo = userRepo;
	}

	public void placeBid(Long userId, Long itemId, BigDecimal amount) {

		Optional<User> user = userRepo.findById(userId);
		Optional<Item> item = itemRepo.findById(itemId);

		Bid bid = new Bid();
		bid.setAmount(amount);
		bid.setUser(user.get());
		bid.setItem(item.get());

		bidRepo.save(bid);
	}

	public Bid updateBidAmount(Long bidId, BigDecimal newAmount) {
		Bid bid = bidRepo.findById(bidId).orElseThrow(() -> new IllegalArgumentException("Bid not found"));

		bid.setAmount(newAmount);

		return bidRepo.save(bid);
	}

	public void deleteBid(Long bidId) {
		bidRepo.deleteById(bidId);
	}

	public BigDecimal getHighestBidAmount(Long itemId) {
		Optional<Bid> highestBid = bidRepo.findById(itemId);
		return highestBid.map(Bid::getAmount).orElse(BigDecimal.ZERO);
	}
}
