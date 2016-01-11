package ExcelReading;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelDataRead {

	
		FileInputStream fi;
		XSSFWorkbook wb;
		XSSFSheet ws;
		
		public ExcelDataRead(String excelpath)
		{
			try {
				File f=new File(excelpath);
				fi=new FileInputStream(f);
				wb=new XSSFWorkbook(fi);
				
			    } 
			catch (Exception e) 
			{
				
				e.getMessage();
			
		    }
		}
		
		public ExcelDataRead() {
			// TODO Auto-generated constructor stub
		}

		public String getdata(int sheetindex,int row,int col)
		{
			
			ws=wb.getSheetAt(sheetindex);
			String data=ws.getRow(row).getCell(col).getStringCellValue();
			return data;
			
		}
		
		public void getrow()
		{
			
		}
		
		public int getrowcount(int sheetindex)
		{
			
			int row=wb.getSheetAt(sheetindex).getLastRowNum();		
			row=row;
			return row;
			
		}
		
		
		public int getcolcount(int sheetindex)
		{
			
			int col=wb.getSheetAt(sheetindex).getRow(0).getLastCellNum();
			col=col;
			return col;
			
		}
		
		/*public void setvalue(int sheetindex,int row,String Result)
		{
			int cl=getcolcount(sheetindex);
			ws=wb.getSheetAt(sheetindex);
			ws.getRow(row).createCell(cl).setCellValue(Result);
			
		}
		*/
		 /*@AfterMethod
		  public void screen(ITestResult result) throws Exception
		  {
			e.Failurescreenshot(result, result.getName());
			e.teardown();
			 			
		   }*/
		
		@DataProvider(name="test1")
		  public static Object[][] passdata() {

			ExcelDataRead ex=new ExcelDataRead("C:/sureshjada/DatadrivenFramework/src/TestData/testcase.xlsx");
		  	  int rows=ex.getrowcount(0);
		  	  int colNum=ex.getcolcount(0);
		  	  System.out.println(rows);
		  	  System.out.println(colNum);
		  	  Object[][] data=new Object[rows][colNum];
		  	  for(int i=0;i<(rows);i++){
		  		  for(int j=0;j<colNum;j++)
		  	      {
		  			//logger=report.startTest(ex.getdata(0,i+1,j));
		  			//logger.log(LogStatus.PASS, "Verify test");
		  		  data[i][j]=ex.getdata(0,i+1,j);
		  		//report.endTest(logger);
	  			//report.flush();
		  		  System.out.println(data[i][j]);
		  	  }}
		  	  
		  	 return data;

		  }


	}


