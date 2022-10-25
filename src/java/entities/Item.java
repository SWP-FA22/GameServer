/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.yuyu.annotations.SQLColumn;
import com.yuyu.annotations.SQLTable;
import com.yuyu.jdbc.JSONEntity;
import org.json.*;

/**
 *
 * @author Huu
 */
@SQLTable(table = "Item")
public class Item extends JSONEntity {

    @SQLColumn(column = "ID", isAutoIncrement = true)
    private Integer id;

    @SQLColumn(column = "Description")
    private String description;

    @SQLColumn(column = "ImageURL")
    private String imageURL;

    @SQLColumn(column = "Name")
    private String name;

    @SQLColumn(column = "Addressable")
    private String addressable;

    @SQLColumn(column = "Type")
    private Integer type;

    @SQLColumn(column = "Price")
    private Integer price;

    @SQLColumn(column = "BonusATK")
    private Double bonusATK;

    @SQLColumn(column = "BonusHP")
    private Double bonusHP;

    @SQLColumn(column = "BonusSpeed")
    private Double bonusSpeed;

    @SQLColumn(column = "BonusRota")
    private Double bonusRota;

    public Item() {
    }

    public Item(Integer id, String description, String imageURL, String name, String addressable, Integer type, Integer price, Double bonusATK, Double bonusHP, Double bonusSpeed, Double bonusRota) {
        this.id = id;
        this.description = description;
        this.imageURL = imageURL;
        this.name = name;
        this.addressable = addressable;
        this.type = type;
        this.price = price;
        this.bonusATK = bonusATK;
        this.bonusHP = bonusHP;
        this.bonusSpeed = bonusSpeed;
        this.bonusRota = bonusRota;
        updateProps();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        updateProp("id", id);
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        updateProp("name", name);
        this.name = name;
    }

    public String getAddressable() {
        return addressable;
    }

    public void setAddressable(String addressable) {
        updateProp("addressable", addressable);
        this.addressable = addressable;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        updateProp("type", type);
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        updateProp("price", price);
        this.price = price;
    }

    public Double getBonusATK() {
        return bonusATK;
    }

    public void setBonusATK(Double bonusATK) {
        updateProp("bonusATK", bonusATK);
        this.bonusATK = bonusATK;
    }

    public Double getBonusHP() {
        return bonusHP;
    }

    public void setBonusHP(Double bonusHP) {
        updateProp("bonusHP", bonusHP);
        this.bonusHP = bonusHP;
    }

    public Double getBonusSpeed() {
        return bonusSpeed;
    }

    public void setBonusSpeed(Double bonusSpeed) {
        updateProp("bonusSpeed", bonusSpeed);
        this.bonusSpeed = bonusSpeed;
    }

    public Double getBonusRota() {
        return bonusRota;
    }

    public void setBonusRota(Double bonusRota) {
        updateProp("bonusRota", bonusRota);
        this.bonusRota = bonusRota;
    }
}
