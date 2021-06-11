
package com.kosta.finalProject.model;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "p_user")
public class UserDTO {

    /**
     * Default constructor
     */
    public UserDTO() {
    }

    @Id
    @Column(name = "user_id")
    private String userID;

    @Column(name = "user_pw")
    private String userPW;
    
    private String email;

    private String nickname;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "last_pw_chg")
    private Date lastPWChg;

    @Column(name = "auth_lv")
    private int authLV;




}