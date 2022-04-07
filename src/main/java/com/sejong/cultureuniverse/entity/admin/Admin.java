package com.sejong.cultureuniverse.entity.admin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.*;

import java.io.Serializable;


@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {

    @Id
    private String adminId;
    private String adminPw;

}
