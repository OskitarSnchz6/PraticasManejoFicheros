/*package com.add.ejercicio4;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class VistaControlador { 
	 
		public void VistaEstudiante(Estudiante estudiante) {
			System.out.println("Datos de los Estudiantes: "+estudiante);
		}
		
		public void verEstudiante(List<Estudiante> estudiantes) {
			for (Estudiante estudiante : estudiantes) {
				System.out.println("Datos del estudiante: "+estudiante);
		}		
	}

}

class ControladorEstudiante {
	
	private VistaControlador vista= new VistaControlador();
	
	public ControladorEstudiante() {
	}
	
	//llama al DAO para guardar un estudiante
	public void create(Estudiante estudiante ) {
		EstudianteDAO dao= new  ImplementarCRUD();
		dao.create(estudiante);
	}
	
	//llama al DAO para actualizar un cliente
	public void update(Estudiante estudiante) {
		EstudianteDAO dao= new  ImplementarCRUD();
		dao.update(estudiante);
	}
	
	public void insert(Estudiante estudiante) {
		EstudianteDAO dao= new  ImplementarCRUD();
		dao.insert(estudiante);
	}
	
	//llama al DAO para eliminar un cliente
	public void delete(Estudiante estudiante) {
		EstudianteDAO dao= new  ImplementarCRUD();
		dao.delete(estudiante);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verEstudiantes(){
		List<Estudiante> estudiante = new ArrayList<Estudiante>();
		EstudianteDAO dao= new  ImplementarCRUD();
		estudiante=dao.read();
		vista.verEstudiante(estudiante);
	}
}
*/