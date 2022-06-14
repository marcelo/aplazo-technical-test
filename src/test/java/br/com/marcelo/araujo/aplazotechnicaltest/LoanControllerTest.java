package br.com.marcelo.araujo.aplazotechnicaltest;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import br.com.marcelo.araujo.aplazotechnicaltest.controllers.LoanController;
import br.com.marcelo.araujo.aplazotechnicaltest.dtos.LoanDTO;
import br.com.marcelo.araujo.aplazotechnicaltest.dtos.PaymentDTO;
import br.com.marcelo.araujo.aplazotechnicaltest.services.LoanService;

@WebMvcTest(LoanController.class)
class LoanControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoanService loanService;

	@Test
	void loan_creation_test() throws Exception {

		LoanDTO loanRequest = new LoanDTO(1000d, 4, 2.5d);

		when(loanService.createLoan(loanRequest)).thenReturn(new ArrayList<PaymentDTO>());

		mockMvc.perform(post("/loans/new").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(loanRequest))).andExpect(status().isOk())
				.andReturn();

	}

}