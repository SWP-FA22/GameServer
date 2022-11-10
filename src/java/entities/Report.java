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

    @SQLColumn(column = "ID", isAutoIncrement = true)
    private Integer id;
    
    @SQLColumn(column = "From")
    private String from;

    @SQLColumn(column = "To")
    private String to;

    @SQLColumn(column = "Reason")
    private String reason;

    @SQLColumn(column = "VideoURL")
    private String videoURL;

    @SQLColumn(column = "Time")
    private Timestamp time;

    @SQLColumn(column = "IsApprove")
    private boolean isapproved;

    public Report() {

    }

    public Report(Integer id, String from, String to, String reason, String videoURL, Timestamp time, boolean isapproved) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.reason = reason;
        this.videoURL = videoURL;
        this.time = time;
        this.isapproved = isapproved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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

    public boolean getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }
}
