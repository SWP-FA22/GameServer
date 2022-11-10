/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Player;
import entities.Report;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LinhThuy
 */
public class ReportModel extends ModelBase<Report>{
    public ReportModel() throws Exception{
        super(Report.class);
    }
    
public boolean createReport(String fromid, String toid, String reason, String videoURL) throws Exception{
    return ModelBase.connection().executeUpdate("INSERT INTO  [Report]  ([From], [To], [Reason], [VideoURL],[IsApprove]) VALUES (?, ?, ?, ?,0)", fromid, toid, reason, videoURL) > 0;
}
        //INSERT INTO  [Report]  ([FromID], [ToID], [Reason], [VideoURL]) VALUES (1, 3, 'test', 'test')
public List<Report> getReportbyPlayerID (Integer id) throws Exception{
    return getIf("[PlayerID] = ?", id);
}
public boolean deleteReport(int id) throws Exception {
        return getConnection().executeUpdate("DELETE FROM [Report] WHERE [ID] = ?", id) > 0;
    }
}