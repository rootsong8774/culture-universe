package com.sejong.cultureuniverse.Entity;

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

    private String username;
    private String pw;
    private String name;
    private String email;
    @Lob
    private Blob profilePic;
    private String phoneNum;
    private Date signDate;

}
