package com.sam.userlogin.entity;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="user-updownload")
public class UserUpDownLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userProfilePic;

    private long size;

    @Lob
    private byte[] content;
}
