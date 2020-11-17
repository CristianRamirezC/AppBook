package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DB table columns
public class DBooks {
    private int id;
    private String title;
    private String authors;
    private String editors;
    private String publicationyear;
    private String comments;
    private String image;
    private String response;
    private DBconnection connection;
    
    //Builder
    public DBooks(){
        
    }

    /**
     *
     * @param id
     * @param title
     * @param editors
     * @param publicationyear
     * @param comments
     * @param image
     * @param response
     * @param connection
     */
    //Builder
    public DBooks(int id, String title, String editors, String publicationyear, String comments, String image, String response, DBconnection connection) {
        this.id = id;
        this.title = title;
        this.editors = editors;
        this.publicationyear = publicationyear;
        this.comments = comments;
        this.image = image;
        this.response = response;
        this.connection = connection;
    }

    //Agregar libros a la BD
    public String add(DBooks books){
        PreparedStatement statement = null; //We use PreparedStatement to send information to Query
        try{
            connection = new DBconnection();
            statement = connection.connectDB().prepareStatement("insert into books values(null,?,?,?,?,?,?)");
            //we send the information to the respectively index of the list above
            statement.setString(1, books.getTitle()); 
            statement.setString(2, books.getAuthors());
            statement.setString(3, books.getEditors());
            statement.setString(4, books.getPublicationyear());
            statement.setString(5, books.getComments());
            statement.setString(6, books.getImage());
            statement.execute();
            //Flag to check the operation was made successfully
            return "OK";
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            if(connection != null){
                try{
                    connection.disconnectDB();
                    statement.close();
                }catch(SQLException d){
                }
            }
        }
    }
    
    //Edit book information
    public String edit(DBooks books){
        PreparedStatement statement = null;
        try{
            connection = new DBconnection();
            statement = connection.connectDB().prepareStatement("update books set title=?, authors=?, editors=?,publicationyear=?, comments=?, image=? where id=?");
            statement.setString(1, books.getTitle());
            statement.setString(2, books.getAuthors());
            statement.setString(3, books.getEditors());
            statement.setString(4, books.getPublicationyear());
            statement.setString(5, books.getComments());
            statement.setString(6, books.getImage());
            statement.setInt(7, books.getId());
            statement.execute(); //execute the query
            return "OK";
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            if(connection != null){
                try{
                    connection.disconnectDB();
                    statement.close();
                }catch(SQLException d){
                }
            }
        }
    }
    
    //remove a book from the DB
    public String remove(int id){
        PreparedStatement statement = null;
        try{
            connection = new DBconnection();
            statement = connection.connectDB().prepareStatement("delete from books where id=?");
            statement.setInt(1, id);
            statement.execute(); // execute the query
            return "OK";
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            if(connection != null){
                try{
                    connection.disconnectDB();
                    statement.close();
                }catch(SQLException d){
                }
            }
        }
    }
    
    //Make a query
    public ResultSet get(int type, String value){ // Result set is a datatype to store a row
        String query="", type2=""; // type2= data type to make the query
        switch(type){
            case 0:
                type2= "title";
                break;
            case 1:
                type2= "authors";
                break;
            case 2:
                type2= "editors";
                break;      
        }
        query = "SELECT * FROM books where"+ type2 +" like ?";
        PreparedStatement st;
        connection = new DBconnection();
        try{
            st = connection.connectDB().prepareStatement(query);
            st.setString(1, value);
            return st.executeQuery();
        }catch(SQLException e){
        }
        return null;
    }
    
    //Get amount of books stored on the DB
    public int getTotalBooks(){
        PreparedStatement st;
        connection = new DBconnection();
        try{
            st = connection.connectDB().prepareStatement("SELECT count(id) as total from books");
            ResultSet rs = st.executeQuery(); // 
            
            if(rs.next()){ // if a row is stored in the Result set
                return rs.getInt("total"); // return the information stored on ResultSet, total= alias set on the above query
            }
        }catch(SQLException e){
        }
        
        return 0;
    }
    
    
    
    //metodos accesores
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getEditors() {
        return editors;
    }

    public void setEditors(String editors) {
        this.editors = editors;
    }

    public String getPublicationyear() {
        return publicationyear;
    }

    public void setPublicationyear(String publicationyear) {
        this.publicationyear = publicationyear;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
