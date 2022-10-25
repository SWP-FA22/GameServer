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
 * @author Huu
 */
@SQLTable(table = "Player")
public class Player extends JSONEntity {

    @SQLColumn(column = "ID", isAutoIncrement = true)
    private Integer id;

    @SQLColumn(column = "Password")
    private String password;

    @SQLColumn(column = "Username")
    private String username;

    @SQLColumn(column = "Name")
    private String name;

    @SQLColumn(column = "Email")
    private String email;

    @SQLColumn(column = "WeaponID")
    private Integer weaponID;

    @SQLColumn(column = "EngineID")
    private Integer engineID;

    @SQLColumn(column = "SailID")
    private Integer sailID;

    @SQLColumn(column = "Rank")
    private Integer rank;

    @SQLColumn(column = "Role")
    private Integer role;

    @SQLColumn(column = "IsCheckIn")
    private boolean ischeckedin;

    @SQLColumn(column = "CheckInCount")
    private Integer checkincount;

    public Player() {
    }

    public boolean isIscheckedin() {
        return ischeckedin;
    }

    public void setIscheckin(boolean ischeckedin) {
        updateProp("ischeckedin", ischeckedin);
        this.ischeckedin = ischeckedin;
    }

    public Integer getCheckincount() {
        return checkincount;
    }

    public void setCheckincount(Integer checkincount) {
        updateProp("checkincount", checkincount);
        this.checkincount = checkincount;
    }

    public Player(Integer id, String password, String username, String name, String email, Integer weaponID, Integer engineID, Integer sailID, Integer rank, Integer role, boolean ischeckedin, Integer checkincount) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.name = name;
        this.email = email;
        this.weaponID = weaponID;
        this.engineID = engineID;
        this.sailID = sailID;
        this.rank = rank;
        this.role = role;
        this.ischeckedin = ischeckedin;
        this.checkincount = checkincount;
        updateProps();
    }

    public Player(Integer id, String password, String username, String name, String email, Integer weaponID, Integer engineID, Integer sailID, Integer rank, Integer role) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.name = name;
        this.email = email;
        this.weaponID = weaponID;
        this.engineID = engineID;
        this.sailID = sailID;
        this.rank = rank;
        this.role = role;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        updateProp("role", role);
        this.role = role;
    }
}
