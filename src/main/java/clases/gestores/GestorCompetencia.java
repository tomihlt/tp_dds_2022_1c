package clases.gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.interfaces.CompetenciaDAO;
import clases.dao.interfaces.FuncionDAO;
import clases.dao.postgres.PostgresCompetencia;
import clases.dao.postgres.PostgresFuncion;
import clases.dto.CompetenciaBasicaDTO;
import clases.dto.CompetenciaPuntajeNombreDTO;
import clases.dto.FuncionNombreIdDTO;
import clases.entidades.Competencia;
import clases.entidades.Funcion;

public class GestorCompetencia
{

	public List<CompetenciaBasicaDTO> getAllCompetenciasBasicasDTO()
	{
		List<CompetenciaBasicaDTO> comps = new ArrayList<CompetenciaBasicaDTO>();
		
		CompetenciaDAO dao = new PostgresCompetencia();
		try
		{
			List<Competencia> aux = dao.getAll();
			CompetenciaBasicaDTO comp;
			for(Competencia c : aux)
			{
				comp = new CompetenciaBasicaDTO();
				comp.setNombre(c.getNombre());
				comp.setId(c.getId());
				comps.add(comp);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return comps;
	}

}
