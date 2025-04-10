package com.limadev.meetime.oauthintegrationapi.adapter.in.api;

import com.limadev.meetime.oauthintegrationapi.adapter.in.api.request.CreateContactRequest;
import com.limadev.meetime.oauthintegrationapi.application.business.port.in.AddContactUseCase;
import com.limadev.meetime.oauthintegrationapi.common.exception.response.ErrorResponse;
import com.limadev.meetime.oauthintegrationapi.common.mapper.ContactMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
@Tag(name = "Contact Controller", description = "Controller manipulação de usuários no CRM")
public class ContactController {

    private final AddContactUseCase addContactUseCase;
    private final ContactMapper contactMapper;


    @Operation(summary = "Endpoint responsável por criar contatos no CRM.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contato criado com sucesso.", content = @Content()),
            @ApiResponse(responseCode = "400", description = "Requisição errada.", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "429", description = "Rate Limiter ultrapassado", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = "/v1/create", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createContact(@RequestBody @Valid CreateContactRequest contactRequest) {
        addContactUseCase.createContact(contactMapper.toDomain(contactRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
