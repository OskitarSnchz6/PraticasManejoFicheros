package com.add.ejercicio3;

public class Usuario {
		
		private String id;
		private String nombre;
		private String apellido;
		private String email;
	    

	    public Usuario(String id, String nombre, String apellido, String email) {
	        this.id = id;
	    	this.nombre = nombre;
	    	this.apellido = apellido;
	        this.email = email;
	    }
	    

		public String getId() {
	        return id;
	    }

	    public void setId(String nombre) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    
	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }


	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

}

