/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.yuyu.annotations.SQLColumn;
import com.yuyu.annotations.SQLTable;
import com.yuyu.jdbc.JSONEntity;

/**
 *
 * @author quang
 */
@SQLTable(table = "Resource")
public class Resource extends JSONEntity {

    @SQLColumn(column = "ID", isAutoIncrement = true)
    private Integer id;

    @SQLColumn(column = "Type")
    private Integer type;

    @SQLColumn(column = "Name")
    private String name;

    @SQLColumn(column = "Description")
    private String description;

    @SQLColumn(column = "ImageURL")
    private String imageURL;

    @SQLColumn(column = "Addressable")
    private String addressable;

    public Resource() {
    }

    public Resource(Integer id, Integer type, String name, String description, String imageURL, String addressable) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.addressable = addressable;

        updateProps();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        updateProp("id", id);
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        updateProp("type", type);
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        updateProp("name", name);
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        updateProp("description", description);
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        updateProp("imageURL", imageURL);
        this.imageURL = imageURL;
    }

    public String getAddressable() {
        return addressable;
    }

    public void setAddressable(String addressable) {
        updateProp("addressable", addressable);
        this.addressable = addressable;
    }

}
