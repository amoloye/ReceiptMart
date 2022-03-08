package com.example.receipt.appuser;

import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor
@Setter
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;




}
