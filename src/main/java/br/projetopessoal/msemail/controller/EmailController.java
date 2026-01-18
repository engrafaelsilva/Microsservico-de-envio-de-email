package br.projetopessoal.msemail.controller;

import br.projetopessoal.msemail.dto.EmailDto;
import br.projetopessoal.msemail.models.EmailModel;
import br.projetopessoal.msemail.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(
        name = "Email",
        description = "Endpoints responsáveis pelo envio de e-mails"
)
public class EmailController {

    @Autowired
    EmailService emailService;

    @Operation(
            summary = "Enviar e-mail",
            description = "Envia um e-mail via SMTP e registra o status do envio no sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "E-mail enviado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EmailModel.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos enviados na requisição"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno ao tentar enviar o e-mail"
            )
    })
    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(
            @RequestBody @Valid EmailDto emailDto
    ) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
