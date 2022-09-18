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
public class Player {

    @SQLColumn(column = "ID", isAutoIncrement = true)
    public int id;

    @SQLColumn(column = "Password")
    public String password;

    @SQLColumn(column = "Username")
    public String username;

    @SQLColumn(column = "Name")
    public String name;

    @SQLColumn(column = "Email")
    public String email;

    @SQLColumn(column = "WeaponID")
    public int weaponID;

    @SQLColumn(column = "EngineID")
    public int engineID;

    @SQLColumn(column = "SailID")
    public int sailID;

    @SQLColumn(column = "Rank")
    public int rank;

    public Player() {
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", password=" + password + ", username=" + username + ", name=" + name + ", email=" + email + ", weaponID=" + weaponID + ", engineID=" + engineID + ", sailID=" + sailID + ", rank=" + rank + '}';
    }

    public Player(int id, String password, String username, String name, String email, int weaponID, int engineID, int sailID, int rank) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.name = name;
        this.email = email;
        this.weaponID = weaponID;
        this.engineID = engineID;
        this.sailID = sailID;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public int getEngineID() {
        return engineID;
    }

    public void setEngineID(int engineID) {
        this.engineID = engineID;
    }

    public int getSailID() {
        return sailID;
    }

    public void setSailID(int sailID) {
        this.sailID = sailID;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
