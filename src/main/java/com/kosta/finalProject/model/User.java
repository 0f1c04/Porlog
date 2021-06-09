
package com.kosta.finalProject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "userID")
@Table(name = "")
public class User {

    /**
     * Default constructor
     */
    public User() {
    }

    @Id
    private String userID;

    private String userPW;

    private String eamil;

    private String nickname;

    private Date lastLogin;

    private Date lastPWChg;

    private int authLV;




}