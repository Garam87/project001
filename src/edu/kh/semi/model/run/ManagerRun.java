package edu.kh.semi.model.run;

import edu.kh.semi.model.service.ManagerService;

public class ManagerRun {

	public static void main(String[] args) {

		
		ManagerService service = new ManagerService();
		
		service.displayMenu();
	}

}
