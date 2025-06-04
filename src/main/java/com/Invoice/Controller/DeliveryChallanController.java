package com.Invoice.Controller;

import java.util.List;

import com.Invoice.Response.ChallanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Invoice.Models.DeliveryChallan;
import com.Invoice.Models.Stock;
import com.Invoice.Repository.DeliveryChallanRepository;
import com.Invoice.Repository.StockRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/dchallan")
public class DeliveryChallanController {

	@Autowired
	private DeliveryChallanRepository deliveryChallanRepository;

	@Autowired
	private StockRepository stockRepository;

	@GetMapping("/{userId}")
	public List<DeliveryChallan> getAllByUserId(@PathVariable Long userId) {
		System.out.println("HERE IS DATA : " + deliveryChallanRepository.getByUserId(userId));
		return deliveryChallanRepository.getByUserId(userId);
	}

	@Transactional
	@PostMapping
	public void createDeliveryChallan(@RequestBody ChallanRequest request) {
		DeliveryChallan deliveryChallan = request.getDchallan();

		List<Stock> stockUpdates = request.getStockUpdates();

		// Saving the invoice
		deliveryChallanRepository.save(deliveryChallan);

		stockUpdates.stream().forEach(s -> System.out.println(s.getQuantity()));

		// Update stock quantities only if the invoice is successfully generated
		for (Stock update : stockUpdates) {
			Stock stock = stockRepository.findById(update.getId())
					.orElseThrow(() -> new RuntimeException("Stock item not found"));
			stock.setQuantity(update.getQuantity()); // Deduct the quantity
			stockRepository.save(stock);
		}
	}

}

