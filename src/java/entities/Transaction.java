/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.yuyu.annotations.SQLColumn;
import com.yuyu.annotations.SQLTable;
import com.yuyu.jdbc.JSONEntity;
import java.sql.Timestamp;

/**
 *
 * @author quang
 */
@SQLTable(table = "Transaction")
public class Transaction extends JSONEntity {
    
    @SQLColumn(column = "ID", isAutoIncrement = true)
    private Integer id;
    
    @SQLColumn(column = "Time")
    private Timestamp time;
    
    @SQLColumn(column = "PlayerID")
    private Integer playerID;
    
    @SQLColumn(column = "Amount")
    private Integer amount;

    public Transaction() {
    }

    public Transaction(Integer id, Timestamp time, Integer playerID, Integer amount) {
        this.id = id;
        this.time = time;
        this.playerID = playerID;
        this.amount = amount;
        updateProps();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        updateProp("id", id);
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        updateProp("time", time);
        this.time = time;
    }

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        updateProp("playerID", playerID);
        this.playerID = playerID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        updateProp("amount", amount);
        this.amount = amount;
    }
}
