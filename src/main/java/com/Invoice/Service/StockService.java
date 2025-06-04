package com.Invoice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Invoice.Models.Stock;
import com.Invoice.Repository.StockRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	public Stock createStock(Stock stock) {
		return stockRepository.save(stock);
	}

	public Stock updateStock(Long id, Stock stock) {
		return stockRepository.findById(id).map(existingStock -> {
			existingStock.setBrandName(stock.getBrandName());
			existingStock.setQuantity(stock.getQuantity());
			existingStock.setBatchNo(stock.getBatchNo());
			existingStock.setPrice(stock.getPrice());
			existingStock.setItemName(stock.getItemName()); // Update fields as needed
			existingStock.setQuantity(stock.getQuantity());
			return stockRepository.save(existingStock);
		}).orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
	}

	@Transactional
	public void updateStockQuantities(List<Stock> stockUpdates) {
		for (Stock update : stockUpdates) {
			Stock stock = stockRepository.findById(update.getId())
					.orElseThrow(() -> new RuntimeException("Stock item not found"));
			stock.setQuantity(stock.getQuantity() - update.getQuantity());
			stockRepository.save(stock);
		}
	}

	public void deleteStock(Long stockId) {
		// Step 2: Delete the stock item
		stockRepository.deleteById(stockId);
	}

	public List<Stock> getStockByUserId(Long userId) {
		return stockRepository.getByUserId(userId);
	}

}
