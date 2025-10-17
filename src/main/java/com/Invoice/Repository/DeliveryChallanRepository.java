package com.Invoice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Invoice.Models.DeliveryChallan;

@Repository
public interface DeliveryChallanRepository extends JpaRepository<DeliveryChallan, Long> {
	List<DeliveryChallan> getByUserId(Long userId);
}
