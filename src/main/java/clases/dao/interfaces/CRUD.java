package clases.dao.interfaces;

import java.util.List;

public interface CRUD<T>
{
	public void add(T t);

	public void remove(T t);

	public T find(Integer id);

	public List<T> getAll();
}
