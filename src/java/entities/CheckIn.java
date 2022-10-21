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
@SQLTable(table = "CheckIn")
public class CheckIn extends JSONEntity {

    @SQLColumn(column = "ID", isAutoIncrement = true)
    private Integer id;

    @SQLColumn(column = "ResourceID")
    private Integer resourceid;

    @SQLColumn(column = "Amount")
    private Integer amount;

    @SQLColumn(column = "CheckinCount")
    private Integer checkincount;

    public CheckIn() {
    }

    public CheckIn(Integer id, Integer resourceid, Integer amount, Integer checkincount) {
        this.id = id;
        this.resourceid = resourceid;
        this.amount = amount;
        this.checkincount = checkincount;
        updateProps();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        updateProp("id", id);
        this.id = id;
    }

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        updateProp("resourceid", resourceid);
        this.resourceid = resourceid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        updateProp("amount", amount);
        this.amount = amount;
    }

    public Integer getCheckincount() {
        return checkincount;
    }

    public void setCheckincount(Integer checkincount) {
        updateProp("checkincount", checkincount);
        this.checkincount = checkincount;
    }

}
