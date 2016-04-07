package library.view;

import library.Main;

public interface IViewController {
	public void delete();

	public void add();

	public void edit();

	public void showDetails(Object object);
	
	public void setMainApp(Main main);
}
