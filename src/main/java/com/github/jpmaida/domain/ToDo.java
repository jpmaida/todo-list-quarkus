package com.github.jpmaida.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.jpmaida.infra.IdGenerator;

@Entity
@Table(name = "to_do")
public class ToDo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String description;
    
    @Column
    private boolean isDone;

    public ToDo(){}

    public ToDo(String description){
        this.id = IdGenerator.generate();
        this.description = description;
        this.isDone = false;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setIsDone(boolean isDone){
        this.isDone = isDone;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
