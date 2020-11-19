/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

//import data.DBconnection;
import business.BBooks;


public class test {
    public static void main(String[] args) {
        
        /*   DB connection test
        DBconnection db = new DBconnection();
        
        if(db.connectDB()!=null){
            System.out.println("Connected");
            db.disconnectDB();
        }else{
            System.out.println("Disconnected");
        }
        */
        
        
        
        // Test de capa de negocios
       // BBooks.add("Programacion", "Cristian", "Java editors", "19/11/20", "Mooy bueno", "esto no es noporxd");
        System.out.println(BBooks.gettotalBooks());
        
    }
    
}
