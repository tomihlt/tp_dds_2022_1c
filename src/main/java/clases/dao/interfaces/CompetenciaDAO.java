package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.entidades.Competencia;
import clases.entidades.Factor;

public interface CompetenciaDAO extends CRUD<Competencia>
{
	public List<Competencia> findByName(List<String> names) throws SQLException;

	public Competencia findByName(String name) throws SQLException;

	public List<Factor> findFactoresByIdCompetencia(Integer id) throws SQLException;

	public List<Integer> getCantidadPreguntasPorFactor(Competencia aux) throws SQLException;

	public Competencia find(Integer id, boolean b) throws SQLException;

	public Competencia find(Integer id, boolean b, boolean c) throws SQLException;

	public List<Factor> findFactores(Competencia competencia) throws SQLException;
}
