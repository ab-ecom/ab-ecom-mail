package com.anirudhb2b.mail;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail-api/mail")
@RequiredArgsConstructor
@Tag(name = "Mail controller", description = "The mail API")
public class MailController {
    private final MailService service;

    @Operation(summary = "Send a mail",
            description = "Send a mail by all fields",
            tags = { "mail" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Mail sent",
                content = @Content(schema = @Schema(implementation = Mail.class))
        ),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    @ResponseBody
    public void sendMail(@RequestBody Mail mail) {
        service.sendMessage(mail);
    }
}
