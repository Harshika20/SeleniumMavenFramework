package utils;

public class ExcelUtilsDemo {
	
	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath+"/Excel/Se.xlsx", "LoginCreds");
		excel.getRowCount();
		excel.getCellData(0, 0);
		excel.getCellData(1, 1);
	}

}
