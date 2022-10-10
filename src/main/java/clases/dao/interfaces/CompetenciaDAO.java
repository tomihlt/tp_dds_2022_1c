package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.tablas.Competencia;

public interface CompetenciaDAO extends CRUD<Competencia>
{
	public List<Competencia> findByName(List<String> names) throws SQLException;
	public Competencia findByName(String name) throws SQLException;
}
