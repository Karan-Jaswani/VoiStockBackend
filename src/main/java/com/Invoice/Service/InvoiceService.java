package com.Invoice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Invoice.Models.Invoice;
import com.Invoice.Repository.InvoiceRepository;
import com.Invoice.Repository.StockRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private StockRepository stockRepository;

	@Transactional
	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	public Invoice getInvoiceById(Long id) {
		return invoiceRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Invoice not found with ID: " + id));
	}

	public void deleteInvoice(Long id) {
		if (!invoiceRepository.existsById(id)) {
			throw new RuntimeException("Invoice not found with ID: " + id);
		}
		invoiceRepository.deleteById(id);
	}
}