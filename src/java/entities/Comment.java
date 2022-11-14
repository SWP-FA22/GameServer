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
@SQLTable(table = "Comment")
public class Comment extends JSONEntity {

    @SQLColumn(column = "ID", isAutoIncrement = true)
    private Integer id;

    @SQLColumn(column = "PostID")
    private Integer postID;

    @SQLColumn(column = "CreatedBy")
    private Integer createdBy;

    @SQLColumn(column = "Description")
    private String description;

    @SQLColumn(column = "TimeCreate")
    private Date timeCreate;

    public Comment() {
    }

    public Comment(Integer id, Integer postID, Integer createdBy, String description, Date timeCreate) {
        this.id = id;
        this.postID = postID;
        this.createdBy = createdBy;
        this.description = description;
        this.timeCreate = timeCreate;
        updateProps();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        updateProp("id", id);
        this.id = id;
    }

    public void setPostID(int postID) {
        updateProp("postID", postID);
        this.postID = postID;
    }

    public Integer getPostID() {
        return postID;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        updateProp("createdBy", createdBy);
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        updateProp("description", description);
        this.description = description;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        updateProp("timeCreate", timeCreate);
        this.timeCreate = timeCreate;
    }

}
