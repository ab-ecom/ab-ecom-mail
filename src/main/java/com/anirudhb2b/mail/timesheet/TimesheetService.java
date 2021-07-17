package com.anirudhb2b.mail.timesheet;

import com.anirudhb2b.mail.MailConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TimesheetService {
    private final MailConfig mailConfig;
    public Optional<List<Timesheet>> getTimesheets() {
        Optional<List<Timesheet>> timesheets = Optional.empty();
        timesheets = Optional.of(mailConfig.getTimesheets());
        return timesheets;
    }
}
