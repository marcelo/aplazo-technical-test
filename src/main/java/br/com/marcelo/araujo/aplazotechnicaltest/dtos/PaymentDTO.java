package br.com.marcelo.araujo.aplazotechnicaltest.dtos;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "payment_number", "amount", "payment_date" })
public class PaymentDTO {

	
	private Integer paymentNumber;
	private Double amount;
	private Date paymentDate;
	
	public PaymentDTO(Integer paymentNumber, Double amount, Date paymentDate) {
		super();
		this.paymentNumber = paymentNumber;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	
	@JsonProperty("payment_number")
	public Integer getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(Integer paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@JsonProperty("payment_date")
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, paymentDate, paymentNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentDTO other = (PaymentDTO) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(paymentDate, other.paymentDate)
				&& Objects.equals(paymentNumber, other.paymentNumber);
	}
	
	
}
