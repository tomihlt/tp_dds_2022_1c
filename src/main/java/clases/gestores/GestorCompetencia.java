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
import clases.dto.FactorBasicoDTO;
import clases.dto.FuncionNombreIdDTO;
import clases.entidades.Competencia;
import clases.entidades.Factor;
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

	public List<FactorBasicoDTO> getFactoresBasicosByCompetencia(CompetenciaPuntajeNombreDTO c) throws SQLException
	{
		List<FactorBasicoDTO> factoresDto = new ArrayList<FactorBasicoDTO>();
		
		CompetenciaDAO cDao = new PostgresCompetencia();
		List<Factor> factores = cDao.findFactoresByIdCompetencia(c.getId());
		
		for(Factor f : factores)
		{
			FactorBasicoDTO fact = new FactorBasicoDTO();
			fact.setId(f.getId());
			fact.setNombre(f.getNombre());
			factoresDto.add(fact);
		}
		
		return factoresDto;
	}

	public Competencia findById(Integer id) throws SQLException
	{
		CompetenciaDAO dao = new PostgresCompetencia();
		return dao.find(id);
	}

}
