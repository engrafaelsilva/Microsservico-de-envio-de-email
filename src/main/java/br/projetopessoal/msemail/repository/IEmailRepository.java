package br.projetopessoal.msemail.repository;

import br.projetopessoal.msemail.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailRepository extends JpaRepository<EmailModel, Long> {

}
