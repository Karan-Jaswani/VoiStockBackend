package com.Invoice.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_challan")
public class DeliveryChallan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String challanNo;
	private String date;
	private String clientName;
	private String clientMobile;
	private String clientAddress;
	private String clientGstin;
	private String clientState;
	private String bankName;
	private String ifsc;
	private String accountNo;
	private String upiId;
	private String signature;
	private Long userId;
	private List<String> itemName;
	private List<Long> itemQuantity;

	public DeliveryChallan() {
	}

	public DeliveryChallan(Long id, String challanNo, String date, String clientName, String clientMobile,
			String clientAddress, String clientGstin, String clientState, String bankName, String ifsc,
			String accountNo, String upiId, String signature, Long userId, List<String> itemName,
			List<Long> itemQuantity) {
		this.id = id;
		this.challanNo = challanNo;
		this.date = date;
		this.clientName = clientName;
		this.clientMobile = clientMobile;
		this.clientAddress = clientAddress;
		this.clientGstin = clientGstin;
		this.clientState = clientState;
		this.bankName = bankName;
		this.ifsc = ifsc;
		this.accountNo = accountNo;
		this.upiId = upiId;
		this.signature = signature;
		this.userId = userId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientMobile() {
		return clientMobile;
	}

	public void setClientMobile(String clientMobile) {
		this.clientMobile = clientMobile;
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

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
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

	public List<String> getItemName() {
		return itemName;
	}

	public void setItemName(List<String> itemName) {
		this.itemName = itemName;
	}

	public List<Long> getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(List<Long> itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

}