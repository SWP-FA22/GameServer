/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Player;
import entities.Transaction;
import java.sql.ResultSet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author quang
 */
public class TransactionModel extends ModelBase<Transaction> {

    public TransactionModel() throws Exception {
        super(Transaction.class);
    }

    public void createNewTransaction(Integer playerID, Integer amount) throws Exception {
        connection().executeUpdate("INSERT INTO [" + getTableName() + "]([PlayerID], [Amount]) VALUES (?, ?)", playerID, amount);
    }

    public List<Transaction> getTransactionByPlayerID(Integer id) throws Exception {
        return getIf("[PlayerID] = ?", id);
    }

    public List<Map.Entry<Transaction, Player>> getAllTransactionWithPlayer() throws Exception {
        List<Map.Entry<Transaction, Player>> result = new ArrayList<>();
        try ( ResultSet rs = connection().executeQuery("SELECT * FROM [Transaction], [Player] WHERE [Player].[ID] = [Transaction].[PlayerID]")) {
            while (rs.next()) {
                Transaction t = new Transaction();
                Player p = new Player();

                t.loadProps(rs);
                p.loadProps(rs);

                result.add(new AbstractMap.SimpleEntry<>(t, p));
            }
        }

        return result;
    }
}
