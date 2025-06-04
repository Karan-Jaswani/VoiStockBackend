package com.Invoice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Invoice.Models.Stock;
import com.Invoice.Service.StockService;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

	@Autowired
	private StockService stockService;

	@PostMapping("/{userId}")
	public ResponseEntity<?> createStock(@RequestBody Stock stock, @PathVariable Long userId) {
		stock.setUserId(userId);
		Stock savedStock = stockService.createStock(stock);
		return new ResponseEntity(savedStock, HttpStatus.CREATED);
	}

	// Get stock by User ID
	@GetMapping("/{userId}")
	public ResponseEntity<List<Stock>> getStockByUserId(@PathVariable Long userId) {
		return ResponseEntity.ok(stockService.getStockByUserId(userId));
	}

	// Update stock
	@PutMapping("/{id}") // Add {id} to match frontend URL
	public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
		Stock updatedStock = stockService.updateStock(id, stock);
		return ResponseEntity.ok(updatedStock);
	}

	@PutMapping("/update-quantity")
	public ResponseEntity<String> updateStock(@RequestBody List<Stock> stockUpdates) {
		stockService.updateStockQuantities(stockUpdates);
		return ResponseEntity.ok("Stock updated successfully");
	}

	// Delete stock by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStock(@PathVariable Long id) {
		stockService.deleteStock(id);
		return ResponseEntity.ok("Stock deleted successfully");
	}

}
