package clases.gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.dao.interfaces.FactorDAO;
import clases.dao.postgres.PostgresFactor;
import clases.dto.FactorBasicoDTO;
import clases.dto.PreguntaBasicaDTO;
import clases.entidades.Pregunta;

public class GestorFactor
{

	public List<PreguntaBasicaDTO> findPreguntasBasicasByFactor(FactorBasicoDTO f) throws SQLException
	{
		List<PreguntaBasicaDTO> preguntasDto = new ArrayList<PreguntaBasicaDTO>();
		FactorDAO dao = new PostgresFactor();
		
		List<Pregunta> preguntas = dao.findPreguntasByIdFactor(f.getId());
		
		PreguntaBasicaDTO preg = null;
		
		for(Pregunta p : preguntas)
		{
			preg = new PreguntaBasicaDTO();
			preg.setId(p.getId());
			preg.setNombre(p.getNombre());
			preguntasDto.add(preg);
		}
		
		return preguntasDto;
	}

}
