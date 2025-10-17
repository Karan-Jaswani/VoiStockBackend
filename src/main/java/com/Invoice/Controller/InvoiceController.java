package com.Invoice.Controller;

import java.util.List;

import com.Invoice.Response.InvoiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Invoice.Models.Invoice;
import com.Invoice.Models.Stock;
import com.Invoice.Repository.InvoiceRepository;
import com.Invoice.Repository.StockRepository;
import com.Invoice.Service.InvoiceService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private StockRepository stockRepository;

	@Transactional
	@PostMapping
	public void createInvoice(@RequestBody InvoiceRequest request) {
		// Extract the invoice and stock updates from the request
		Invoice invoice = request.getInvoice();
		List<Stock> stockUpdates = request.getStockUpdates();

		// Saving the invoice
		invoiceService.saveInvoice(invoice);

		// Update stock quantities only if the invoice is successfully generated
		for (Stock update : stockUpdates) {
			Stock stock = stockRepository.findById(update.getId())
					.orElseThrow(() -> new RuntimeException("Stock item not found"));
			stock.setQuantity(update.getQuantity()); // Deduct the quantity
			stockRepository.save(stock);
		}
	}

	@GetMapping("/{userId}")
	public List<Invoice> getAllInvoices(@PathVariable Long userId) {
		return invoiceRepository.getByUserId(userId);
	}
}

