package br.com.marcelo.araujo.aplazotechnicaltest.dtos;

import java.util.Objects;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class LoanDTO {

	@DecimalMin(value = "1.01", message = "amount should be greater than 1")
	@DecimalMax(value = "999999.00", message = "amount should be less than 999999.00")
	private Double amount;

	@Min(value = 4, message = "Minimum Number of Weeks is 4")
	@Max(value = 52, message = "Maximum Number of Weeks is 52")
	private Integer terms;

	@DecimalMin(value = "1.01", message = "rate should be greater than 1")
	@DecimalMax(value = "99.99", message = "rate should be less than 100")
	private Double rate;

	@Override
	public int hashCode() {
		return Objects.hash(amount, rate, terms);
	}

	public LoanDTO(Double amount, @Min(4) @Max(52) Integer terms, Double rate) {
		super();
		this.amount = amount;
		this.terms = terms;
		this.rate = rate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanDTO other = (LoanDTO) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(rate, other.rate)
				&& Objects.equals(terms, other.terms);
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getTerms() {
		return terms;
	}

	public void setTerms(Integer terms) {
		this.terms = terms;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

}