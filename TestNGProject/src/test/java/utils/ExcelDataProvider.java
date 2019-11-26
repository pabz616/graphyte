package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class ExcelDataProvider {
		
	@DataProvider(name ="fiveElementsData")
	public Object[][] getData() {
		String projectPath = System.getProperty("user.dir");
		String dataFile = "/test-data/FiveElementsData.xlsx";
		
		String excelPath = projectPath+dataFile;
		String sheetName = "data"; 
		
		Object data[][] = testData(excelPath, sheetName);
		return data;
	}
	
	public Object[][]testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data [][] = new Object [rowCount-1][colCount];
		
		for(int i = 1; i < rowCount; i++) {
			for (int j = 1; j < colCount; j++){
				
				String cellData = excel.getCellDataString(i, j);
				data[i-1][j] = cellData;
			}
		}
		return data;
	}

}
