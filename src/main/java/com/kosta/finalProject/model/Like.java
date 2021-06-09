package com.kosta.finalProject.model;

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
@Table(name = "")
public class Like {

    /**
     * Default constructor
     */
    public Like() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int likeNO;

    @ManyToOne
    private Post post;

    
    private int likeCnt;


}