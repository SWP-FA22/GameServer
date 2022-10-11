/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Transaction;
import java.util.List;

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
}
