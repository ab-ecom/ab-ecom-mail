package com.anirudhb2b.mail.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Company {
    private Integer id;
    private String name;
    private String email;
}
