package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.dto.CandidatoBasicoDTO;
import clases.entidades.Candidato;

public interface CandidatoDAO extends CRUD<Candidato>
{
	public Candidato findCandidatoByDni(Integer dni) throws SQLException;
	
	public List<Candidato> findByFilters(String apellido, String nombre, Integer numeroDeCandidato) throws SQLException;
}
