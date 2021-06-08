
package com.kosta.finalProject.model;

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
@EqualsAndHashCode(of = "postID")
@Table(name = "")
public class Post_Contents {

    /**
     * Default constructor
     */
    public Post_Contents() {
    }

    @Id
    private String postID;

    
    private String contents;


}