package com.hashedin.candidateService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRequestDTO {
    private String name;
    private String email;
    private String phone;
    private String resume;
}
