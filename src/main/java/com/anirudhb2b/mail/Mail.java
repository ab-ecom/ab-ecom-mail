package com.anirudhb2b.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Mail {
    private String fromEmail;
    private String toEmail;
    private LocalDate fromDate;
    private LocalDate toDate;
}
