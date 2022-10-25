/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.yuyu.annotations.SQLColumn;
import com.yuyu.annotations.SQLTable;
import com.yuyu.jdbc.JSONEntity;
import java.sql.Date;

/**
 *
 * @author Huu
 */
@SQLTable(table = "Post")
public class Posts extends JSONEntity {

    @SQLColumn(column = "ID", isAutoIncrement = true)
    private Integer id;

    @SQLColumn(column = "CreatedBy")
    private Integer createdBy;

    @SQLColumn(column = "Title")
    private String title;

    @SQLColumn(column = "Description")
    private String description;

    @SQLColumn(column = "TimeCreate")
    private Date timeCreate;
    
    @SQLColumn(column = "isApproved")
    private Boolean isApproved;

    public Posts() {

    }

    public Posts(Integer id, Integer createdBy, String title, String description, Date timeCreate, Boolean isApproved) {
        this.id = id;
        this.createdBy = createdBy;
        this.title = title;
        this.description = description;
        this.timeCreate = timeCreate;
        this.isApproved = isApproved;
        updateProps();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        updateProp("id", id);
        this.id = id;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        updateProp("createdBy", createdBy);
        this.createdBy = createdBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        updateProp("title", title);
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        updateProp("description", description);
        this.description = description;
    }

    public Date getTimeCreate() {
        return (Date)timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        updateProp("timeCreate", timeCreate);
        this.timeCreate = timeCreate;
    }

    public Boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        updateProp("isApproved", isApproved);
        this.isApproved = isApproved;
    }

}
