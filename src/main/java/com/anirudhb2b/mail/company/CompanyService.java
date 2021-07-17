package com.anirudhb2b.mail.company;

import com.anirudhb2b.mail.MailConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final MailConfig mailConfig;
    public Optional<List<Company>> getCompanies() {
        Optional<List<Company>> companies = Optional.empty();
        companies = Optional.of(mailConfig.getCompanies());
        return companies;
    }
}
