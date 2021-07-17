package com.anirudhb2b.mail.company;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mail-api/company")
@RequiredArgsConstructor
@Tag(name = "Company controller", description = "The mail company API")
public class CompanyController {
    private final CompanyService service;


    @Operation(summary = "Get all companies",
        description = "Get list of companies",
        tags = { "mail", "company" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
            description = "successful operation",
            content = @Content(schema = @Schema(implementation = Company.class)))
    })
    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<List<Company>> findAllCompanies() {
        Optional<List<Company>> response = service.getCompanies();
        return ResponseEntity.ok()
                .body(response.get());
    }
}
