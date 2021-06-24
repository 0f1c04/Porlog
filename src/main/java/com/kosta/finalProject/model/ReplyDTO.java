
package com.kosta.finalProject.model;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "p_reply")
public class ReplyDTO {

    /**
     * Default constructor
     */
    public ReplyDTO() {
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reply_no")
    private Long replyNO;

    @ManyToOne
    private UserDTO replyUser;

    @ManyToOne
    private PostDTO post;

    private String reply;
    
    @Column(name = "reply_date")
    private Date replyDate;



}