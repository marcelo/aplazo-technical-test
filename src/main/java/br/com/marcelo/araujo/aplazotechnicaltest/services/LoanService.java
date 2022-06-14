package br.com.marcelo.araujo.aplazotechnicaltest.services;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcelo.araujo.aplazotechnicaltest.dtos.LoanDTO;
import br.com.marcelo.araujo.aplazotechnicaltest.dtos.PaymentDTO;
import br.com.marcelo.araujo.aplazotechnicaltest.entities.Loan;
import br.com.marcelo.araujo.aplazotechnicaltest.entities.Payment;
import br.com.marcelo.araujo.aplazotechnicaltest.repositories.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepo;

	@Transactional
	public List<PaymentDTO> createLoan(LoanDTO loanDTO) {

		Double formula = loanDTO.getAmount() * loanDTO.getRate() * loanDTO.getTerms() / 100;
		Double requestedLoanAmount = loanDTO.getAmount();
		Double interestAmount = requestedLoanAmount + formula;
		Double totalPerWeek = interestAmount / loanDTO.getTerms();

		Loan loan = new Loan(loanDTO.getAmount(), loanDTO.getTerms(), loanDTO.getRate());

		List<PaymentDTO> paymentsDTO = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();

		IntStream.range(1, loanDTO.getTerms() + 1).forEach(n -> {

			LocalDate localDate = LocalDate.now();
			DecimalFormat df = new DecimalFormat("0.00");
			df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

			PaymentDTO paymentDTO = new PaymentDTO(n, Double.parseDouble(df.format(totalPerWeek)),
					Date.from(localDate.atStartOfDay().plusWeeks(n).atZone(ZoneId.systemDefault()).toInstant()));

			paymentsDTO.add(paymentDTO);

		});

		List<Payment> payments = paymentsDTO
				  .stream()
				  .map(paymentDTO -> modelMapper.map(paymentDTO, Payment.class))
				  .collect(Collectors.toList());
		
		loan.setPayments(payments);

		loanRepo.save(loan);
		return paymentsDTO;

	}

}
