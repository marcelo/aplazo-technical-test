package br.com.marcelo.araujo.aplazotechnicaltest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcelo.araujo.aplazotechnicaltest.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}