package com.mino.exboard.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity{
    @Id
    private String email;

    private String password;

    private String name;
}
