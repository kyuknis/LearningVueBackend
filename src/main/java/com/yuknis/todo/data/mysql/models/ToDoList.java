package com.yuknis.todo.data.mysql.models;

import org.hibernate.annotations.Cascade;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CascadeType;
import java.util.List;

@Entity
@Table(name = "to_do_lists")
@Valid
public class ToDoList extends AuditedModel {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected Long id;

    @Column(name = "title")
    @NotNull
    protected String title;

    @Column(name = "Description")
    protected String description;

    @OneToMany(mappedBy = "toDoList")
    @Cascade(value = CascadeType.ALL)
    @Valid
    protected List<ToDo> toDos;

    public ToDoList() {
        // ..
    }

    public ToDoList(Long id) {
        this.setId(id);
    }

    public ToDoList(String title, String description) {
        this.setTitle(title);
        this.setDescription(description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public int getListCount() {
        return this.getToDos().size();
    }

}
