package com.kosta.finalProject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "postlist")
@Entity
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "blogID")
@Table(name = "p_blog")
public class BlogDTO {

    /**
     * Default constructor
     */
    public BlogDTO() {
    } 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "blog_id")
    private Long blogID;

    @ManyToOne
    private UserDTO user;
    
    @Column(name = "blog_title")
    private String blogTitle;
    
    @JsonIgnore
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //, fetch = FetchType.EAGER
    List<PostDTO> postlist;

}