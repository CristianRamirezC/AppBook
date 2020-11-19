package business;

import data.DBooks;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class BBooks {
    
    public static String add(String title, String authors, String editors, String year, String comments, String img){
        DBooks book = new DBooks(0, title, authors, editors, year, comments, img);
        return book.add(book);
    }
    
    public static String edit(int id, String title, String authors, String editors, String year, String comments, String img){
        DBooks book = new DBooks(id, title, authors, editors, year, comments, img);
        return book.edit(book);
    }
    
    public static String remove(int id){
        return new DBooks().remove(id);
        
    }
    
    public static int gettotalBooks(){
        return new DBooks().getTotalBooks();
    }
    
    //Define the default model of the table 
    public static DefaultTableModel get(int type, String value){  // titles of the coumns
        String titles[] = {"id", "Titulo", "Author", "Editor", "Año de Publicacion", "Comentarios", "Imagen"};
        DefaultTableModel model = new DefaultTableModel(new String[][]{}, titles){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
        };
        
        try{
            ResultSet rs = new DBooks().get(type, value);
            String row[] = new String[7];  // store rows information in this array
            while (rs.next()){  //while there's still rows on the table, do...
                row[0] = rs.getString(1); // assign one by one the Resultset information to the row
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                model.addRow(row); // we add the new row to the model
            }
        }catch(SQLException e){
            
        }
        
        return model;
    }
    
}
