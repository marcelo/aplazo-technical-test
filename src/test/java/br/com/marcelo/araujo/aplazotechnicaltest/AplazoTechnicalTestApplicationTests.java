package br.com.marcelo.araujo.aplazotechnicaltest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.marcelo.araujo.aplazotechnicaltest.controllers.LoanController;
import br.com.marcelo.araujo.aplazotechnicaltest.services.LoanService;


@SpringBootTest
class AplazoTechnicalTestApplicationTests {


    @Autowired
    private LoanController loanController;
    

    @Autowired
    private LoanService loanService;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(loanService);
        assertNotNull(loanController);
    }

}
