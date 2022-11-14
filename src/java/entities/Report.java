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
 * @author LinhThuy
 */
@SQLTable(table = "Report")
public class Report extends JSONEntity {

    @SQLColumn(column = "From")
    private String fromid;

    @SQLColumn(column = "To")
    private String toid;

    @SQLColumn(column = "Reason")
    private String reason;

    @SQLColumn(column = "VideoURL")
    private String videoURL;

    @SQLColumn(column = "Time")
    private Timestamp time;

    @SQLColumn(column = "IsApprove")
    private Boolean isapproved;

    public Report() {

    }

    public Report(String fromid, String toid, String reason, String videoURL, Timestamp time, Boolean isapproved) {
        this.fromid = fromid;
        this.toid = toid;
        this.reason = reason;
        this.videoURL = videoURL;
        this.time = time;
        this.isapproved = isapproved;

        updateProps();
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
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

    public Boolean getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(Boolean isapproved) {
        this.isapproved = isapproved;
    }
}
