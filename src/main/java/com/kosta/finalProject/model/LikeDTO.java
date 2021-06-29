package com.kosta.finalProject.model;

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
@EqualsAndHashCode(of = "likeNO")
@Table(name = "p_like")
public class LikeDTO {

    /**
     * Default constructor
     */
    public LikeDTO() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "like_no")
    private int likeNO;

    @ManyToOne
    private UserDTO user;
    
    @ManyToOne
    private PostDTO post;
    
    public LikeDTO(PostDTO post, UserDTO user) {
        this.post = post;
        this.user = user;
    }
    
}