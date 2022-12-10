package clases.dto;

import clases.enums.TipoDNI;

public class CandidatoLogInDTO
{
	private Integer id;
	private TipoDNI tipoDni;
	private Integer nroDni;
	private char[] pw;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public TipoDNI getTipoDni()
	{
		return tipoDni;
	}

	public void setTipoDni(TipoDNI tipoDni)
	{
		this.tipoDni = tipoDni;
	}

	public Integer getNroDni()
	{
		return nroDni;
	}

	public void setNroDni(Integer nroDni)
	{
		this.nroDni = nroDni;
	}

	public char[] getPw()
	{
		return pw;
	}

	public void setPw(char[] pw)
	{
		this.pw = pw;
	}

}
