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
@SQLTable(table = "Ship")
public class Ship extends JSONEntity {

    @SQLColumn(column = "ID", isAutoIncrement = true)
    private Integer id;

    @SQLColumn(column = "Name")
    private String name;

    @SQLColumn(column = "Description")
    private String description;

    @SQLColumn(column = "BaseATK")
    private Double baseATK;

    @SQLColumn(column = "BaseHP")
    private Double baseHP;

    @SQLColumn(column = "BaseSpeed")
    private Double baseSpeed;

    @SQLColumn(column = "BaseRota")
    private Double baseRota;

    @SQLColumn(column = "Price")
    private Integer price;

    @SQLColumn(column = "Addressable")
    private String addressable;

    public Ship() {
    }

    public Ship(Integer id, String name, String description, Double baseATK, Double baseHP, Double baseSpeed, Double baseRota, Integer price, String addressable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.baseATK = baseATK;
        this.baseHP = baseHP;
        this.baseSpeed = baseSpeed;
        this.baseRota = baseRota;
        this.price = price;
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

    public Double getBaseATK() {
        return baseATK;
    }

    public void setBaseATK(Double baseATK) {
        updateProp("baseATK", baseATK);
        this.baseATK = baseATK;
    }

    public Double getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(Double baseHP) {
        updateProp("baseHP", baseHP);
        this.baseHP = baseHP;
    }

    public Double getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(Double baseSpeed) {
        updateProp("baseSpeed", baseSpeed);
        this.baseSpeed = baseSpeed;
    }

    public Double getBaseRota() {
        return baseRota;
    }

    public void setBaseRota(Double baseRota) {
        updateProp("baseRota", baseRota);
        this.baseRota = baseRota;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        updateProp("price", price);
        this.price = price;
    }

    public String getAddressable() {
        return addressable;
    }

    public void setAddressable(String addressable) {
        updateProp("addressable", addressable);
        this.addressable = addressable;
    }

}
