package com.yuknis.todo.data.mysql.models;

import com.yuknis.todo.data.contracts.ToDo;
import com.yuknis.todo.data.contracts.ToDoList;
import com.yuknis.todo.data.dto.ToDoListDTO;
import org.hibernate.annotations.Cascade;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class ToDoListModel extends AuditedModel implements ToDoList {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected Long id;

    @Column(name = "title")
    @NotNull
    protected String title;

    @Column(name = "Description")
    protected String description;

    @OneToMany(mappedBy = "toDoListModel")
    @Cascade(value = CascadeType.ALL)
    @Valid
    protected List<ToDo> toDos;

    public ToDoListModel() {
        // ..
    }

    public ToDoListModel(Long id) {
        this.setId(id);
    }

    public ToDoListModel(String title, String description) {
        this.setTitle(title);
        this.setDescription(description);
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

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<ToDo> getToDos() {
        return toDos;
    }

    @Override
    public void setToDos(List<ToDo> toDoModels) {
        this.toDos = toDos;
    }

    public int getListCount() {
        return this.getToDos().size();
    }

    public static class Builder {

        public ToDoListModel create(ToDoListDTO dto) {

            ToDoListModel persistentToDoListModel = new ToDoListModel();

            persistentToDoListModel.setId(dto.getId());
            persistentToDoListModel.setDescription(dto.getDescription());
            persistentToDoListModel.setTitle(dto.getTitle());
            persistentToDoListModel.setToDos(dto.getToDos());

            return persistentToDoListModel;

        }

    }

}
