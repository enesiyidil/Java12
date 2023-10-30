package com.enes.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class Iletisim {

    String ceptelefonu;
    String evTelefonu;
    String isTelefonu;
    String email;
    @Column(length = 500)
    String adres;
    String webSite;
}
