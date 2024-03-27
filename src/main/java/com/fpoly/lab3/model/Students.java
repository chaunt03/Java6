package com.fpoly.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    String email;
    String fullname;
    Double marks;
    Boolean gender;
    String country;
}
