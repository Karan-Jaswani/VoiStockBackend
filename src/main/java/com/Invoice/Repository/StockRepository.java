package com.Invoice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Invoice.Models.Stock;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	public Stock getByBatchNo(String batchNo);

	public List<Stock> getByUserId(Long userId);

}
