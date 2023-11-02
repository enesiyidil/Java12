package com.enes.entity;

import lombok.*;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Embeddable
public class Information {

    private String name;

    private String surname;

    private String middlename;
}
