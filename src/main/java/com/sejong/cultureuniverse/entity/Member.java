package com.sejong.cultureuniverse.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userIdx;
    
    @NotBlank
    @Size(min = 4, max = 16)
    private String username;
    
    @NotBlank
    private String password;
    
    
    private String name;
    
    private String role;


}
