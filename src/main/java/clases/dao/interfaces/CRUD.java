package clases.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface CRUD<T>
{
	public void save(T t) throws SQLException;

	public void remove(T t);

	public T find(Integer id) throws SQLException;
	
	public T find(Integer id, Boolean modificacion) throws SQLException;
	
	public List<T> find(List<Integer> id) throws SQLException;

	public List<T> getAll() throws SQLException;
	
	public void update(T t) throws SQLException;
	
}
