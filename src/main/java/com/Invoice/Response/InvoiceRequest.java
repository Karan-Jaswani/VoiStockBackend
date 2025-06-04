package com.Invoice.Response;

import com.Invoice.Models.Invoice;
import com.Invoice.Models.Stock;

import java.util.List;

public class InvoiceRequest {
    private Invoice invoice;
    private List<Stock> stockUpdates;

    // Getters and Setters
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Stock> getStockUpdates() {
        return stockUpdates;
    }

    public void setStockUpdates(List<Stock> stockUpdates) {
        this.stockUpdates = stockUpdates;
    }
}
