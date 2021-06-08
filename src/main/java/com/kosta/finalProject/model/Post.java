
package com.kosta.finalProject.model;

import java.util.Date;

import javax.persistence.Entity;
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
@Table(name = "")
public class Post {

    /**
     * Default constructor
     */
    public Post() {
    }

    @Id
    private String postID;

    @ManyToOne
    private Blog blog;

    private Date postDate;
    private String postTitle;
    private int viewCnt;





}