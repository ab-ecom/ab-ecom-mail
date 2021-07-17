package com.anirudhb2b.mail;

import com.anirudhb2b.mail.company.Company;
import com.anirudhb2b.mail.timesheet.Timesheet;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "mail")
@Data
public class MailConfig {
    private String environment;
    private String fromEmail;
    private String toEmail;
    private List<Company> companies;
    private List<Timesheet> timesheets;
}