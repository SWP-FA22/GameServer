/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.yuyu.annotations.SQLColumn;
import com.yuyu.annotations.SQLTable;
import com.yuyu.jdbc.JSONEntity;
import java.sql.Timestamp;
import java.util.Date;
import org.json.JSONArray;

/**
 *
 * @author LinhThuy
 */
@SQLTable(table = "Report")
public class Report extends JSONEntity {

    @SQLColumn(column = "FromID")
    private Integer fromid;

    @SQLColumn(column = "ToID")
    private Integer toid;

    @SQLColumn(column = "Reason")
    private String reason;

    @SQLColumn(column = "VideoURL")
    private String videoURL;

    @SQLColumn(column = "Time")
    private Timestamp time;

    @SQLColumn(column = "IsApproved")
    private Integer isapproved;

    public Report() {

    }

    public Report(Integer fromid, Integer toid, String reason, String videoURL, Timestamp time, Integer isapproved) {
        this.fromid = fromid;
        this.toid = toid;
        this.reason = reason;
        this.videoURL = videoURL;
        this.time = time;
        this.isapproved = isapproved;
        
         updateProps();
    }

    public Integer getFromid() {
        return fromid;
    }

    public void setFromid(Integer fromid) {
        this.fromid = fromid;
    }

    public Integer getToid() {
        return toid;
    }

    public void setToid(Integer toid) {
        this.toid = toid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(Integer isapproved) {
        this.isapproved = isapproved;
    }
    }
