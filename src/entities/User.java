/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.yuyu.annotations.SQLColumn;
import com.yuyu.annotations.SQLTable;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Huu
 */

@SQLTable(table = "User")

public class User extends EntityBase {
    
    @SQLColumn(column = "userid")
    public int userid;
    
    @SQLColumn(column = "password")
    public String password;
    
    @SQLColumn(column = "password")
    public String playername;
    
    @SQLColumn(column = "gmail")
    public String gmail;
    
    @SQLColumn(column = "weaponitemid")
    public int  weaponitemid;
    
    @SQLColumn(column = "engineitemid")
    public int engineitemid;
    
    @SQLColumn(column = "saillitemid")
    public int saillitemid;

    public User() {
    }
    
    public User(ResultSet rs) throws SQLException{
        this(rs.getInt("userid"), rs.getString("password"), rs.getString ("playername"), rs.getString ("gmail"), rs.getInt("weaponitemid"), rs.getInt("engineitemid"), rs.getInt("saillitemid") );
        
    }

    public User(int userid, String password, String playername, String gmail, int weaponitemid, int engineitemid, int saillitemid) {
        this.userid = userid;
        this.password = password;
        this.playername = playername;
        this.gmail = gmail;
        this.weaponitemid = weaponitemid;
        this.engineitemid = engineitemid;
        this.saillitemid = saillitemid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getWeaponitemid() {
        return weaponitemid;
    }

    public void setWeaponitemid(int weaponitemid) {
        this.weaponitemid = weaponitemid;
    }

    public int getEngineitemid() {
        return engineitemid;
    }

    public void setEngineitemid(int engineitemid) {
        this.engineitemid = engineitemid;
    }

    public int getSaillitemid() {
        return saillitemid;
    }

    public void setSaillitemid(int saillitemid) {
        this.saillitemid = saillitemid;
    }
}
