package com.compmon.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.compmon.daoimpl.ComponentDaoImpl;
import com.compmon.model.Component;


public class Read {

	
	public static void main(String[] args) {

		int rowCount=0;
		int totalRowsInserted=0;
		ComponentDaoImpl insertComponent = new ComponentDaoImpl();
		Component component=null;
		
		try{
			 FileInputStream file = new FileInputStream(new File("C:/Ashish/Release/ComponentVersion/table_design.xlsx"));
             
	            //Get the workbook instance for XLS file
			 XSSFWorkbook  workbook = new XSSFWorkbook (file);
	 
	            //Get first sheet from the workbook
			 XSSFSheet  sheet = workbook.getSheetAt(0);
	             
	            //Iterate through each rows from first sheet
	            Iterator<Row> rowIterator = sheet.iterator();
	            while(rowIterator.hasNext()) {
	         
	            	Row row = rowIterator.next();
	                
	                if(rowCount!=0){
	                	
	                	component = new Component();  // creating a new row to insert ....
	                	 //For each row, iterate through each columns
		                Iterator<Cell> cellIterator = row.cellIterator();
		                while(cellIterator.hasNext()) {
		                     
		                    Cell cell = cellIterator.next();
		                     
		                    switch(cell.getCellType()) {
		                        case Cell.CELL_TYPE_BOOLEAN:
		                            System.out.print(cell.getBooleanCellValue() + "\t\t");
		                            break;
		                        case Cell.CELL_TYPE_NUMERIC:
		                            System.out.print(cell.getNumericCellValue() + "\t\t");
		                            break;
		                        case Cell.CELL_TYPE_STRING:
		                        	
		                        	int index = cell.getColumnIndex();
		                            
		                        	if(index==0){
		                        		component.setTenant(cell.getStringCellValue());
		                        	}else if(index==1){
		                        		component.setEnvironment(cell.getStringCellValue());
		                        	}else if(index==2){
		                        		component.setApplication(cell.getStringCellValue());
		                        	}else if(index==3){
		                        		component.setBox(cell.getStringCellValue());
		                        	}else if(index==4){
		                        		component.setInstance(cell.getStringCellValue());
		                        	}else if(index==5){
		                        		component.setComponentName(cell.getStringCellValue());
		                        	}else if(index==6){
		                        		component.setComponentVersion(cell.getStringCellValue());
		                        	}else if(index==7){
		                        		component.setComponentUrl(cell.getStringCellValue());
		                        	}
		                        	System.out.print(cell.getStringCellValue() + "\t\t");
		                            break;
		                    }
		                } 		// traversing all the columns of a row is over...
		                	// insert that object in the database...
		                	insertComponent.insertComponent(component);
	                }
	                
	               rowCount++;
	               System.out.println("");
	            }

                System.out.println("Total rows  : " + rowCount);
	            file.close();
	           	
		}
		catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
		catch (IOException e) {
            e.printStackTrace();
        }

	}

}
