package com.anirudhb2b.mail.timesheet;

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
@RequestMapping("/mail-api/timesheet")
@RequiredArgsConstructor
@Tag(name = "Timesheet controller", description = "The mail company timesheet API")
public class TimesheetController {
    private final TimesheetService service;


    @Operation(summary = "Get all timesheets",
            description = "Get list of timesheets",
            tags = { "mail", "timesheet" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Timesheet.class)))
    })
    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<List<Timesheet>> findAllTimesheets() {
        Optional<List<Timesheet>> response = service.getTimesheets();
        return ResponseEntity.ok()
                .body(response.get());
    }
}
