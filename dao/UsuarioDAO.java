//author Nicolas
package dao;

import dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public static void insereUsuario(UsuarioDTO user) {
	try {
	    String query = "insert into Usuario values(?,?)";
	    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/help", "root", "root");
	    
	    PreparedStatement ps = conn.prepareStatement(query);
	    ps.setString(1, user.getLogin());
	    ps.setString(2, user.getSenha());
	    ps.execute();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public static boolean existeUsuario(UsuarioDTO user) {
	boolean ret = false;
	try {
	    String query = "select login, senha from Usuario";
	    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/help", "root", "root");
	    
	    PreparedStatement ps = conn.prepareStatement(query);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		if (rs.getString("login").equals(user.getLogin()) && rs.getString("senha").equals(user.getSenha())) {
		    ret = true;
		    break;
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return ret;
    }
}
