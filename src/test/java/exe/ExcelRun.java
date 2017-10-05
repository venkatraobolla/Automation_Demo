package exe;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

public class ExcelRun 
{
	WritableWorkbook myFirstWbook;
	Connection con;
  @Test
  public void TestRunFinalProcess() throws IOException, WriteException 
  {
	  	myFirstWbook = Workbook.createWorkbook(new File("C:\\Artha\\ArthaDB_Automation_TestResults.xls"));
	  	WritableSheet excelSheet = myFirstWbook.createSheet("TestResults", 0);
	  	WritableFont cellFont1 = new WritableFont(WritableFont.TAHOMA, 10);
	    cellFont1.setColour(Colour.BLACK);
	    WritableCellFormat cellFormat1 = new WritableCellFormat(cellFont1);		    
	    excelSheet.addCell(new Label(0, 0, "Testcase ID", cellFormat1));
        excelSheet.addCell(new Label(1, 0, "Failure Reason", cellFormat1));
        excelSheet.addCell(new Label(2, 0, "Failure Rec Count", cellFormat1));
        excelSheet.addCell(new Label(3, 0, "Test Result", cellFormat1));
        
        excelSheet.addCell( new Label(0,1,"TC001", cellFormat1));
        excelSheet.addCell( new Label(1,1,Arthadb_Automation.TC001Rec, cellFormat1));
        excelSheet.addCell( new Label(2,1,Arthadb_Automation.TC001RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,1,Arthadb_Automation.TC001Result, cellFormat1));
        
        excelSheet.addCell( new Label(0,2,"TC002", cellFormat1));
        excelSheet.addCell( new Label(1,2,Arthadb_Automation.TC002Rec, cellFormat1));
        excelSheet.addCell( new Label(2,2,Arthadb_Automation.TC002RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,2,Arthadb_Automation.TC002Result, cellFormat1));
        
        excelSheet.addCell( new Label(0,3,"TC003", cellFormat1));
        excelSheet.addCell( new Label(1,3,Arthadb_Automation.TC003Rec, cellFormat1));
        excelSheet.addCell( new Label(2,3,Arthadb_Automation.TC003RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,3,Arthadb_Automation.TC003Result, cellFormat1));
        
        excelSheet.addCell( new Label(0,4,"TC004", cellFormat1));
        excelSheet.addCell( new Label(1,4,Arthadb_Automation.TC004Rec, cellFormat1));
        excelSheet.addCell( new Label(2,4,Arthadb_Automation.TC004RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,4,Arthadb_Automation.TC004Result, cellFormat1));
        
        excelSheet.addCell( new Label(0,5,"TC005", cellFormat1));
        excelSheet.addCell( new Label(1,5,Arthadb_Automation.TC005Rec, cellFormat1));
        excelSheet.addCell( new Label(2,5,Arthadb_Automation.TC005RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,5,Arthadb_Automation.TC005Result, cellFormat1));

        excelSheet.addCell( new Label(0,6,"TC006", cellFormat1));
        excelSheet.addCell( new Label(1,6,Arthadb_Automation.TC006Rec, cellFormat1));
        excelSheet.addCell( new Label(2,6,Arthadb_Automation.TC006RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,6,Arthadb_Automation.TC006Result, cellFormat1));
        
        excelSheet.addCell( new Label(0,7,"TC007", cellFormat1));
        excelSheet.addCell( new Label(1,7,Arthadb_Automation.TC007Rec, cellFormat1));
        excelSheet.addCell( new Label(2,7,Arthadb_Automation.TC007RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,7,Arthadb_Automation.TC007Result, cellFormat1));
        
        excelSheet.addCell( new Label(0,8,"TC008", cellFormat1));
        excelSheet.addCell( new Label(1,8,Arthadb_Automation.TC008Rec, cellFormat1));
        excelSheet.addCell( new Label(2,8,Arthadb_Automation.TC008RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,8,Arthadb_Automation.TC008Result, cellFormat1));       

        excelSheet.addCell( new Label(0,9,"TC009", cellFormat1));
        excelSheet.addCell( new Label(1,9,Arthadb_Automation.TC009Rec, cellFormat1));
        excelSheet.addCell( new Label(2,9,Arthadb_Automation.TC009RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,9,Arthadb_Automation.TC009Result, cellFormat1));     
        
        excelSheet.addCell( new Label(0,10,"TC010", cellFormat1));
        excelSheet.addCell( new Label(1,10,Arthadb_Automation.TC010Rec, cellFormat1));
        excelSheet.addCell( new Label(2,10,Arthadb_Automation.TC010RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,10,Arthadb_Automation.TC010Result, cellFormat1));   
        
		excelSheet.addCell( new Label(0,11,"TC011", cellFormat1));
        excelSheet.addCell( new Label(1,11,Arthadb_Automation.TC011Rec, cellFormat1));
        excelSheet.addCell( new Label(2,11,Arthadb_Automation.TC011RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,11,Arthadb_Automation.TC011Result, cellFormat1));     
        
		excelSheet.addCell( new Label(0,12,"TC012", cellFormat1));
        excelSheet.addCell( new Label(1,12,Arthadb_Automation.TC012Rec, cellFormat1));
        excelSheet.addCell( new Label(2,12,Arthadb_Automation.TC012RecCount+"", cellFormat1));
        excelSheet.addCell( new Label(3,12,Arthadb_Automation.TC012Result, cellFormat1));     
         
        myFirstWbook.write();
        myFirstWbook.close();
        
  }
}
