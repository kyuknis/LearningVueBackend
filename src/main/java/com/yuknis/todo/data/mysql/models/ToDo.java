package com.yuknis.todo.data.mysql.models;

import org.hibernate.annotations.ColumnDefault;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "to_dos")
public class ToDo extends AuditedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "title")
    @NotNull
    protected String title;

    @Column(name = "complete", columnDefinition = "boolean default false")
    @ColumnDefault("false")
    protected Boolean complete;

    @ManyToOne
    @JoinColumn(name = "to_do_list_id")
    protected ToDoList toDoList;

    public ToDo() {
        // ..
    }

    public ToDo(Long id) {
        this.setId(id);
    }

    public ToDo(String title, Boolean complete) {
        this.setTitle(title);
        this.setComplete(complete);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

}
