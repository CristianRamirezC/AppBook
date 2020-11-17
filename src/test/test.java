/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.DBconnection;


public class test {
    public static void main(String[] args) {
        DBconnection db = new DBconnection();
        
        if(db.connectDB()!=null){
            System.out.println("Connected");
            db.disconnectDB();
        }else{
            System.out.println("Disconnected");
        }
    }
    
}
