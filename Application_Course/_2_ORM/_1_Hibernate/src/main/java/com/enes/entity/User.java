package com.enes.entity;

import com.enes.enums.EAddressType;
import com.enes.enums.EGender;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Information information;

    @Column(length = 32, nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String username;

    @Enumerated
    @Builder.Default
    private EGender gender = EGender.UNSPECIFIED;

    @ElementCollection
    private List<String> interests;

    @ElementCollection
    private Map<EAddressType, Address> addresses;
}
