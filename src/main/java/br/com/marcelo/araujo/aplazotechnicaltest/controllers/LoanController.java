package br.com.marcelo.araujo.aplazotechnicaltest.controllers;


import static br.com.marcelo.araujo.aplazotechnicaltest.utils.ConstantsMapping.LOANS;
import static br.com.marcelo.araujo.aplazotechnicaltest.utils.ConstantsMapping.NEW;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcelo.araujo.aplazotechnicaltest.dtos.LoanDTO;
import br.com.marcelo.araujo.aplazotechnicaltest.dtos.PaymentDTO;
import br.com.marcelo.araujo.aplazotechnicaltest.services.LoanService;

@RestController
@RequestMapping(LOANS)
public class LoanController {

	private static final Logger logger = LoggerFactory.getLogger("DEFAULT");

	@Autowired
	private LoanService loanService;

	@PostMapping(NEW)
	public ResponseEntity<List<PaymentDTO>> createLoan(@RequestBody @Valid LoanDTO loan) {
		logger.info("APLAZO - LOAN CREATION - INVOKED: " + loan);
		return ResponseEntity.ok(loanService.createLoan(loan));
		
	}
	

}