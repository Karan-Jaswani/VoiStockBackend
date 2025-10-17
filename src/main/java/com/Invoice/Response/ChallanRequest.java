package com.Invoice.Response;

import com.Invoice.Models.DeliveryChallan;
import com.Invoice.Models.Stock;

import java.util.List;

public class ChallanRequest {
    private DeliveryChallan dchallan;
    private List<Stock> stockUpdates;

    public List<Stock> getStockUpdates() {
        return stockUpdates;
    }

    public void setStockUpdates(List<Stock> stockUpdates) {
        this.stockUpdates = stockUpdates;
    }

    public DeliveryChallan getDchallan() {
        return dchallan;
    }

    public void setDchallan(DeliveryChallan dchallan) {
        this.dchallan = dchallan;
    }

}
