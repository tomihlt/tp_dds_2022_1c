package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import clases.dto.CandidatoBasicoDTO;
import clases.entidades.Candidato;
import clases.entidades.Cuestionario;

public interface CandidatoDAO extends CRUD<Candidato>
{
	public Candidato findCandidatoByDni(Integer dni) throws SQLException;
	
	public List<Candidato> findByFilters(String apellido, String nombre, Integer numeroDeCandidato) throws SQLException;
	
	public Boolean tieneCuestionarioById(Integer id) throws SQLException;

	public Cuestionario findCuestionario(Candidato candidato) throws SQLException;
}
