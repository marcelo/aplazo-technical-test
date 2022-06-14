package br.com.marcelo.araujo.aplazotechnicaltest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.marcelo.araujo.aplazotechnicaltest.dtos.LoanDTO;
import br.com.marcelo.araujo.aplazotechnicaltest.dtos.PaymentDTO;
import br.com.marcelo.araujo.aplazotechnicaltest.entities.Loan;
import br.com.marcelo.araujo.aplazotechnicaltest.entities.Payment;
import br.com.marcelo.araujo.aplazotechnicaltest.repositories.LoanRepository;
import br.com.marcelo.araujo.aplazotechnicaltest.services.LoanService;

@ExtendWith(MockitoExtension.class)
public class LoanServiceTests {

	@Mock
	private LoanRepository loanRepository;

	@InjectMocks
	private LoanService loanService;

	private LoanDTO loanDTO;

	@BeforeEach
	public void setup() {

		loanDTO = new LoanDTO(1450d, 6, 8.5d);
	}

	
	@DisplayName("Create Loan - PaymentList Output")
	@Test
	public void givenLoan_createLoan_output_paymentsList_test() {

		List<PaymentDTO> payments = loanService.createLoan(loanDTO);

		assertThat(payments).isNotNull();
		assertEquals(6, payments.size());

	}
	
	@DisplayName("Loan Pojo Test")
	@Test
	public void loan_pojo_test() {


		Loan loan = new Loan(1000d, 4, 10d);
		Loan loan2 = new Loan(1000d, 4, 10d);
		Loan loan3 = new Loan(1000d, 4, 10d);
		
		
		loan.setTerms(10);
		loan.setAmount(2000d);
		loan.setRate(5.44d);
		assertThat(loan).isNotNull();
		assertEquals(2000d, loan.getAmount());
		assertEquals(10, loan.getTerms());
		assertEquals(5.44d, loan.getRate());
		
		assertTrue(loan3.equals(loan2));
		assertTrue(loan3.hashCode() == loan2.hashCode());
		
	}
	
	@DisplayName("Loan DTO Test")
	@Test
	public void loan_dto_test() {


		LoanDTO loan = new LoanDTO(1000d, 4, 10d);
		LoanDTO loan2 = new LoanDTO(1000d, 4, 10d);
		LoanDTO loan3 = new LoanDTO(1000d, 4, 10d);
		
		
		loan.setTerms(10);
		loan.setAmount(2000d);
		loan.setRate(5.44d);
		assertThat(loan).isNotNull();
		assertEquals(2000d, loan.getAmount());
		assertEquals(10, loan.getTerms());
		assertEquals(5.44d, loan.getRate());
		
		assertTrue(loan3.equals(loan2));
		assertTrue(loan3.hashCode() == loan2.hashCode());
		
	}
	
	
	@DisplayName("Payment POJO Test")
	@Test
	public void payment_pojo_test() {


		Payment payment = new Payment(1, 1000d, new Date());
		Payment payment2 = new Payment(2, 1000d, new Date());
		Payment payment3 = new Payment(2, 1000d, new Date());
		
		
		payment.setAmount(2000d);
		payment.setPaymentNumber(10);
		
		assertThat(payment).isNotNull();
		assertEquals(2000d, payment.getAmount());
		assertEquals(10, payment.getPaymentNumber());
		
		
		assertTrue(payment2.equals(payment3));
		assertTrue(payment3.hashCode() == payment2.hashCode());

	}
	
	
	@DisplayName("Payment DTO Test")
	@Test
	public void payment_dto_test() {


		PaymentDTO payment = new PaymentDTO(1, 1000d, new Date());
		PaymentDTO payment2 = new PaymentDTO(2, 1000d, new Date());
		PaymentDTO payment3 = new PaymentDTO(2, 1000d, new Date());
		
		
		payment.setAmount(2000d);
		payment.setPaymentNumber(10);
		
		assertThat(payment).isNotNull();
		assertEquals(2000d, payment.getAmount());
		assertEquals(10, payment.getPaymentNumber());
		
		
		assertTrue(payment2.equals(payment3));
		assertTrue(payment3.hashCode() == payment2.hashCode());
	}
	
	
}