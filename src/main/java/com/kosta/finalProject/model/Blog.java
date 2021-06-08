package com.kosta.finalProject.model;

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
@EqualsAndHashCode(of = "blogID")
@Table(name = "")
public class Blog {

    /**
     * Default constructor
     */
    public Blog() {
    }

  
    @Id
    private String blogID;

   
    @ManyToOne
    private User user;




}