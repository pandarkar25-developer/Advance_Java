package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Test {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/clg";
        String user = "prasanna";
        String password = "Prasanna@123";

        try{
            Connection con = DriverManager.getConnection(url,user,password);
            Statement stm =con.createStatement();
            
            String query ="select * from student;";
            ResultSet rs =stm.executeQuery(query);
             while(rs.next()){
                System.out.println(
                    rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)
                );
            }

            query ="create table IF NOT EXISTS mark(roll_no int,std_name varchar(50),sub varchar(50),mark int)";
            stm.executeUpdate(query);

            query ="INSERT INTO MARK VALUES(01,'PRASANNA','JAVA',90)";
            stm.executeUpdate(query);

            query ="INSERT INTO MARK VALUES(02,'OM','CPP',80)";
            stm.executeUpdate(query);

            query ="SELECT * FROM mark";
            ResultSet RS1 =stm.executeQuery(query);
            while (RS1.next()) {
                System.out.println(RS1.getInt(1)+" "+RS1.getString(2)+" "+RS1.getString(3)+" "+RS1.getInt(4));
            }
            
            query ="DELETE FROM mark;";
            stm.executeUpdate(query);

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}