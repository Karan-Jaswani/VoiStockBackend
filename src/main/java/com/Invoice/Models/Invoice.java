package com.Invoice.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String invoiceNo;
	private String invoiceDate;
	private String clientName;
	private String clientAddress;
	private String clientGstin;
	private String clientState;
	private String bankName;
	private String ifsc;
	private String accountNo;
	private String branch;
	private String upiId;
	private Double taxableAmount;
	private Double cgst;
	private Double sgst;
	private Double freight;
	private Double totalAmount;
	private String amountInWords;
	private String signature;
	private Long userId;
	private List<String> stockName;
	private List<Double> stockQuantity;
	private List<Double> stockRate;
	private List<Double> stockAmount;

	public Invoice() {
	}

	public Invoice(Long id, String invoiceNo, String invoiceDate, String clientName, String clientAddress,
			String clientGstin, String clientState, String bankName, String ifsc, String accountNo, String branch,
			String upiId, Double taxableAmount, Double cgst, Double sgst, Double freight, Double totalAmount,
			String amountInWords, String signature, Long userId, List<String> stockName, List<Double> stockQuantity,
			List<Double> stockRate, List<Double> stockAmount) {
		this.id = id;
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.clientGstin = clientGstin;
		this.clientState = clientState;
		this.bankName = bankName;
		this.ifsc = ifsc;
		this.accountNo = accountNo;
		this.branch = branch;
		this.upiId = upiId;
		this.taxableAmount = taxableAmount;
		this.cgst = cgst;
		this.sgst = sgst;
		this.freight = freight;
		this.totalAmount = totalAmount;
		this.amountInWords = amountInWords;
		this.signature = signature;
		this.userId = userId;
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
		this.stockRate = stockRate;
		this.stockAmount = stockAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientGstin() {
		return clientGstin;
	}

	public void setClientGstin(String clientGstin) {
		this.clientGstin = clientGstin;
	}

	public String getClientState() {
		return clientState;
	}

	public void setClientState(String clientState) {
		this.clientState = clientState;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public Double getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(Double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAmountInWords() {
		return amountInWords;
	}

	public void setAmountInWords(String amountInWords) {
		this.amountInWords = amountInWords;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<String> getStockName() {
		return stockName;
	}

	public void setStockName(List<String> stockName) {
		this.stockName = stockName;
	}

	public List<Double> getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(List<Double> stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public List<Double> getStockRate() {
		return stockRate;
	}

	public void setStockRate(List<Double> stockRate) {
		this.stockRate = stockRate;
	}

	public List<Double> getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(List<Double> stockAmount) {
		this.stockAmount = stockAmount;
	}

}