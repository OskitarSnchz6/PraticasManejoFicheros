package com.add.ejercicio4;

public interface pruebaDAO {
	 public void insert(Estudiante estudiante);
	 public void update(Estudiante estudiante);
	 public void delete(Integer id);
	 public Estudiante select(Integer id);
}