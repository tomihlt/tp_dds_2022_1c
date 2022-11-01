package clases.dao.interfaces;

import clases.entidades.Funcion;

public interface FuncionDAO extends CRUD<Funcion>
{

	public Funcion findByFilters();

}
