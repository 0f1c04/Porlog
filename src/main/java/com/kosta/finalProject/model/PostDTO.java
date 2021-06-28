
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
@EqualsAndHashCode(of = "postID")
@Table(name = "p_post")
public class PostDTO {

    /**
     * Default constructor
     */
    public PostDTO() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long postID;

    @ManyToOne
    private BlogDTO blog;
    
    @Column(name = "post_date")
    private Date postDate;
    
    @Column(name = "post_title")
    private String postTitle;
    
    @Column(name = "view_cnt")
    private int viewCnt;

}