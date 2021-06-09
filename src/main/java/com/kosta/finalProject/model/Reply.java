
package com.kosta.finalProject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@EqualsAndHashCode(of = "replyNO")
@Table(name = "")
public class Reply {

    /**
     * Default constructor
     */
    public Reply() {
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int replyNO;

    @ManyToOne
    private User replyUser;

    @ManyToOne
    private Post post;

    private String reply;
    private Date replyDate;



}