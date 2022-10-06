/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.yuyu.annotations.SQLColumn;
import com.yuyu.annotations.SQLTable;
import org.json.*;

/**
 *
 * @author Huu
 */
@SQLTable(table = "Item")
public class Item extends EntityBase {

    @SQLColumn(column = "ID", isAutoIncrement = true)
    public Integer id;

    @SQLColumn(column = "Description")
    public String description;

    @SQLColumn(column = "ImageURL")
    public String imageURL;

    @SQLColumn(column = "Name")
    public String name;

    @SQLColumn(column = "Addressable")
    public String addressable;

    @SQLColumn(column = "Type")
    public Integer type;

    @SQLColumn(column = "Price")
    public Double price;

    @SQLColumn(column = "BonusATK")
    public Double bonusATK;

    @SQLColumn(column = "BonusHP")
    public Double bonusHP;

    @SQLColumn(column = "BonusSpeed")
    public Double bonusSpeed;

    @SQLColumn(column = "BonusRota")
    public Double bonusRota;

    public Item() {
    }

    public Item(Integer id, String description, String imageURL, String name, String addressable, Integer type, Double price, Double bonusATK, Double bonusHP, Double bonusSpeed, Double bonusRota) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

	public JSONObject toJSON() throws JSONException {
		// TODO - implement Item.toJSON
		throw new UnsupportedOperationException();
	}

}
