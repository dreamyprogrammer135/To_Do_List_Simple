package com.dreamyprogrammer.todolistsimple.elements;

import java.util.ArrayList;
import java.util.Date;

public class TaskElement {
    private String name;
    private Date createDate;
    private Integer priority;
    private Integer typeElement;
    private String groupElement;
    private Integer delete;


    public TaskElement(String name, Integer typeElement) {
        this.name = name;
        this.typeElement = typeElement;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public String getGroupElement() {
        return groupElement;
    }

    public void setGroupElement(String groupElement) {
        this.groupElement = groupElement;
    }

    public Integer getTypeElement() {
        return typeElement;
    }

    public void setTypeElement(Integer typeElement) {
        this.typeElement = typeElement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}
