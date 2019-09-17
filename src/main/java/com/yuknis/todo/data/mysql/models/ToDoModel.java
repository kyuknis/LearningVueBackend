package com.yuknis.todo.data.mysql.models;

import com.yuknis.todo.data.contracts.ToDo;
import com.yuknis.todo.data.contracts.ToDoList;
import com.yuknis.todo.data.dto.ToDoDTO;
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
public class ToDoModel extends AuditedModel implements ToDo {

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
    protected ToDoListModel toDoList;

    public ToDoModel() {
        // ..
    }

    public ToDoModel(Long id) {
        this.setId(id);
    }

    public ToDoModel(String title, Boolean complete) {
        this.setTitle(title);
        this.setComplete(complete);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Boolean getComplete() {
        return complete;
    }

    @Override
    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    @Override
    public ToDoList getToDoList() {
        return toDoList;
    }

    @Override
    public void setToDoList(ToDoList toDoListModel) {
        this.toDoList = toDoList;
    }

    public static class Builder {

        public ToDoModel create(ToDoDTO dto) {

            ToDoModel persistentToDoModel = new ToDoModel();

            persistentToDoModel.setId(dto.getId());
            persistentToDoModel.setTitle(dto.getTitle());
            persistentToDoModel.setComplete(dto.getComplete());
            persistentToDoModel.setToDoList(dto.getToDoList());

            return persistentToDoModel;

        }

    }

}
