package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BD {
  
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/Portal?useSSL=false&allowPublicKeyRetrieval=true";//biblioteca es el nombre de la base de datos
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	private Connection connection = null;
    private PreparedStatement statement = null;
    private static DefaultTableModel m = new DefaultTableModel(new Object[] {"No.lista", "Nombre", "Asistencia"},0); 

	public void Conectar() {
        try {
			connection =  DriverManager.getConnection(URL, USUARIO, CLAVE);
		
		} catch (SQLException e) {
		}

		
		
	}
	
	public boolean BuscarUser(String user) {
		boolean existe=false;
		Conectar();
		String sql="SELECT*FROM Usuarios WHERE usuario=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, user);
			
			ResultSet found = statement.executeQuery();
			
			if(found.next()) {
				existe=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

			return existe;
			
	}
	
	public boolean Buscarpass(String password) {
		boolean existe=false;
		Conectar();
		String sql="SELECT*FROM Usuarios WHERE contraseña=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, password);
			
			ResultSet found = statement.executeQuery();
			
			if(found.next()) {
				existe=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

			return existe;
	}
	public void recuperar(String usuarios, String password, String passwordnew) {
		Conectar();
		String sql = "SELECT * FROM Usuarios WHERE Usuario=? AND Contraseña=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, usuarios);
			statement.setString(2, password);

			ResultSet found = statement.executeQuery();

			if (found.next()) {
				String sqlUpdate = "UPDATE Usuarios SET Contraseña=? WHERE Usuario=?";
				statement = connection.prepareStatement(sqlUpdate);
				statement.setString(1, passwordnew);
				statement.setString(2, usuarios);
				statement.executeUpdate();

				JOptionPane.showMessageDialog(null, "Contraseña actualizada exitosamente");
			} else {
				JOptionPane.showMessageDialog(null, "No existe el usuario");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Agregar(String nombre, int unidades) {
		Conectar();
		String sql = "INSERT INTO Materias(Nombre, Unidades) VALUES(?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, nombre);
			statement.setInt(2, unidades );
			int f = statement.executeUpdate();
			
		if(f>0) {
			JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente");
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo agregar");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DefaultTableModel tablamaterias() {
		Conectar();
		DefaultTableModel m = new DefaultTableModel(new Object[] {"Materias", "Unidades"},0); 
		String sql = "SELECT * FROM Materias";
		try {
			statement = connection.prepareStatement(sql);
			ResultSet re = statement.executeQuery();
			while(re.next()){
				String Nombre = re.getString("Nombre");
				int Unidades = re.getInt("Unidades");
				Object [] o = {Nombre, Unidades};
				
				m.addRow(o);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public DefaultComboBoxModel comboxmaterias() {
		Conectar();
		DefaultComboBoxModel <String> o = new DefaultComboBoxModel<String> (); 
		String sql = "SELECT Nombre FROM Materias";
		
		try {
			statement = connection.prepareStatement(sql);
			ResultSet re = statement.executeQuery();
			while(re.next()){
				String Nombre = re.getString("Nombre");
			
				
				o.addElement(Nombre);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	
	public DefaultTableModel tablaalumnos() {
		Conectar();
		DefaultTableModel m = new DefaultTableModel(new Object[] {"Nombre completo", "Matricula", "Fecha de nacimiento", "Edad", "Carrera", "Semestre", "Materia" },0); 
		String sql = "SELECT * FROM Alumnos";
		try {
			statement = connection.prepareStatement(sql);
			ResultSet re = statement.executeQuery();
			while(re.next()){
				String Nombre = re.getString("Nombre_completo");
				int Matricual = re.getInt("Matricula");
				String fc = re.getString("Fecha_de_nacimiento");
				int edad = re.getInt("Edad");
				String carrera = re.getString("Carrera");
				int s = re.getInt("Semestre");
				String M = re.getString("Materia");
				
				Object [] o = {Nombre, Matricual, fc.toString(), edad, carrera, s, M};
				
				m.addRow(o);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	public void agregartablaalumno(String Nombre, int matricula, String fecha, int edad, String carrera, int semestre, String materia ) {
		Conectar();
		String sql = "INSERT INTO Alumnos(Nombre_completo, Matricula, Fecha_de_nacimiento, Edad, Carrera, Semestre, Materia) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			//java.sql.Date fecha = new java.sql.Date(new java.util.Date().getTime());
			statement = connection.prepareStatement(sql);
			statement.setString(1, Nombre);
			statement.setInt(2, matricula );
			statement.setString(3, fecha );
			statement.setInt(4, edad );
			statement.setString(5, carrera );
			statement.setInt(6, semestre );
			statement.setString(7, materia );
			int f = statement.executeUpdate();
			
		if(f>0) {
			JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente");
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo agregar");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarcolumnaalumnos(String materia) {
		Conectar();
		m.setRowCount(0);
		String sql = "SELECT Nombre_completo FROM Alumnos WHERE Materia=? ORDER BY Nombre_completo ASC";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, materia);
			ResultSet re = statement.executeQuery();
			while(re.next()){
				//String C 
				int c=m.getRowCount()+1;
				
				String Nombre = re.getString("Nombre_completo");				
				Object [] o = {c, Nombre};
				
				m.addRow(o);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

	public DefaultTableModel r() {
		return m;
	}
	
	public DefaultTableModel tablacal(String materias) {
		 Conectar();
		 String sql = "SELECT * FROM Materias WHERE Nombre="+"'"+materias+"'"; 
		 int unidades = 0;
		 DefaultTableModel C = new DefaultTableModel(new Object[] {"Nombre"},0); 
		 
			try {
				statement = connection.prepareStatement(sql);
				ResultSet re = statement.executeQuery();
				while(re.next()){
					unidades = re.getInt("Unidades");					
				}	
				
				for(int x = 0; x<unidades; x++) {
					C.addColumn( "Unidad " + (x+1));
				}
				sql = "SELECT * FROM Alumnos WHERE Materia="+"'"+materias+"'";
				statement = connection.prepareStatement(sql);
				re = statement.executeQuery();
				
				while(re.next()){
					String alumnos = re.getString("Nombre_completo");	
					Object []c = {alumnos};
					C.addRow(c);
				}	
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return C;
	}
	
	public void ingresarcal(String Nombre, String Materia, String Unidad, float Calificacion) {
		Conectar();
		String sql = "INSERT INTO Calificacion (Nombre, Materia, Unidad, Calificacion) VALUES(?, ?, ?, ?)";
		try {
			//java.sql.Date fecha = new java.sql.Date(new java.util.Date().getTime());
			statement = connection.prepareStatement(sql);
			statement.setString(1, Nombre);
			statement.setString(2, Materia );
			statement.setString(3, " Unidad " + Unidad );
			statement.setFloat(4, Calificacion );
		
			int f = statement.executeUpdate();
			
		if(f>0) {
			JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente");
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo agregar");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAsistencia(String nombre, String materia, String asistencia) {
	    Conectar();
	    String sql = "UPDATE Alumnos SET Asistencia = ? WHERE Nombre_completo = ? AND Materia = ?";
	    try {
	        statement = connection.prepareStatement(sql);
	        statement.setString(1, asistencia);
	        statement.setString(2, nombre);
	        statement.setString(3, materia);
	        statement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	
	
	
	
	

		
	
}
