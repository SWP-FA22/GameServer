/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.yuyu.annotations.SQLColumn;
import com.yuyu.annotations.SQLTable;

/**
 *
 * @author Huu
 */
@SQLTable(table = "Player")
public class Player extends EntityBase {

    @SQLColumn(column = "ID", isAutoIncrement = true)
    public Integer id;

    @SQLColumn(column = "Password")
    public String password;

    @SQLColumn(column = "Username")
    public String username;

    @SQLColumn(column = "Name")
    public String name;

    @SQLColumn(column = "Email")
    public String email;

    @SQLColumn(column = "WeaponID")
    public Integer weaponID;

    @SQLColumn(column = "EngineID")
    public Integer engineID;

    @SQLColumn(column = "SailID")
    public Integer sailID;

    @SQLColumn(column = "Rank")
    public Integer rank;

    public Player() {
    }

    public Player(Integer id, String password, String username, String name, String email, Integer weaponID, Integer engineID, Integer sailID, Integer rank) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.name = name;
        this.email = email;
        this.weaponID = weaponID;
        this.engineID = engineID;
        this.sailID = sailID;
        this.rank = rank;

        updateProps();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        updateProp("id", id);
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        updateProp("password", password);
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        updateProp("username", username);
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        updateProp("name", name);
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        updateProp("email", email);
        this.email = email;
    }

    public Integer getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(Integer weaponID) {
        updateProp("weaponID", weaponID);
        this.weaponID = weaponID;
    }

    public Integer getEngineID() {
        return engineID;
    }

    public void setEngineID(Integer engineID) {
        updateProp("engineID", engineID);
        this.engineID = engineID;
    }

    public Integer getSailID() {
        return sailID;
    }

    public void setSailID(Integer sailID) {
        updateProp("sailID", sailID);
        this.sailID = sailID;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        updateProp("rank", rank);
        this.rank = rank;
    }

}
