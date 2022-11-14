/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Report;

/**
 *
 * @author LinhThuy
 */
public class ReportModel extends ModelBase<Report> {

    public ReportModel() throws Exception {
        super(Report.class);
    }

    public boolean createReport(String fromid, String toid, String reason, String videoURL) throws Exception {
        return ModelBase.connection().executeUpdate("INSERT INTO [Report]([From], [To], [Reason], [VideoURL]) VALUES (?, ?, ?, ?)", fromid, toid, reason, videoURL) > 0;
    }

    public void removeReport(String fromid, String toid) throws Exception {
        ModelBase.connection().executeUpdate("DELETE FROM [Report] WHERE [From] = ? AND [To] = ?", fromid, toid);
    }
}
