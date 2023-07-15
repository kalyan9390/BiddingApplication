package com.bidding.Controller;

import java.math.BigDecimal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bidding.Entity.Bid;
import com.bidding.Service.BidService;

@RestController
public class BidController {

	private final BidService bidService;

	public BidController(BidService bidService) {
		this.bidService = bidService;
	}

	@PostMapping("/bid/save")
	public void placeBid(@RequestParam Long userId, @RequestParam Long itemId, @RequestParam BigDecimal amount,
			Model model) {

		bidService.placeBid(userId, itemId, amount);
	}

	@PutMapping("/bid/update/{bidId}")
	public Bid updateBidAmount(@PathVariable Long bidId, @RequestParam BigDecimal newAmount) {

		return bidService.updateBidAmount(bidId, newAmount);
	}

	@DeleteMapping("/bid/delete/{bidId}")
	public void deleteBid(@PathVariable Long bidId) {
		bidService.deleteBid(bidId);
	}

	@GetMapping("/bid/get/{itemId}")
	public BigDecimal getHighestBidAmount(@PathVariable Long itemId) {
		BigDecimal highestBidAmount = bidService.getHighestBidAmount(itemId);
		return highestBidAmount;
	}
}
