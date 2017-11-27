package com.test.Utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getData {

	public static String[][] readExcel(String fileName, String sheetName) throws IOException{		
		File file = new File("C:\\Selenium8\\TestData3.xlsx");	
		FileInputStream ips = new FileInputStream(file);

		Workbook Wb = new XSSFWorkbook(ips);
		Sheet Sh = Wb.getSheet(sheetName);


		int rowNum =Sh.getLastRowNum() + 1;		
		int colNum = Sh.getRow(0).getLastCellNum();		
		String[][] data = new String[rowNum][colNum];		

		for (int i=0; i< rowNum; i++){	
			System.out.println("i:"+i);
			Row row = Sh.getRow(i);	

			for( int j =0; j < colNum; j++){
				System.out.println("j:"+j);
				String value = row.getCell(j).getStringCellValue();	
				data[i][j] = value;	
			}		
		}
		return data;		


	}

	public static String valueFromHeader(String sheetName, String header, int rowNum) throws IOException{
		File file = new File("C:\\Selenium8\\TestData3.xlsx");	
		FileInputStream ips = new FileInputStream(file);

		Workbook Wb = new XSSFWorkbook(ips);
		Sheet Sh = Wb.getSheet(sheetName);
		Row row = Sh.getRow(rowNum);
		int colNum = Sh.getRow(0).getLastCellNum();	
		String value = null;
		for( int j =0; j < colNum; j++){
			System.out.println("j:"+j);
			if(Sh.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase(header)){
				value = row.getCell(j).getStringCellValue();	
				break;
			}
		}
		Wb.close();
		ips.close();
		return value;

	}

	public static void writeValueInExcelFile(String sheetName, String header, int rowNum, String value) throws IOException{

		File file = new File("C:\\Selenium8\\TestData3.xlsx");	
		FileInputStream ips=new FileInputStream(file);
		Workbook Wb = new XSSFWorkbook(ips);
		Sheet Sh = Wb.getSheet(sheetName);
		Row row = Sh.getRow(rowNum);
		int colNum = Sh.getRow(0).getLastCellNum();			
		for( int j =0; j < colNum; j++){
			System.out.println("j:"+j);
			if(Sh.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase(header)){
				row.getCell(j).setCellValue(value);	
				break;
			}
		}
		FileOutputStream ops = new FileOutputStream(file);
		Wb.write(ops);

		Wb.close();
		ips.close();

	}

	public static List<Integer> rowNumberHavingSameRelatedNumber(String sheetName, String header, String relatedNumberFromCMS) throws IOException{
		File file = new File("C:\\Selenium8\\TestData3.xlsx");	
		FileInputStream ips = new FileInputStream(file);

		Workbook Wb = new XSSFWorkbook(ips);
		Sheet Sh = Wb.getSheet(sheetName);
		int rowNum =Sh.getLastRowNum() + 1;	
		System.out.println("last row: "+rowNum);
		List<Integer> temp=new ArrayList<Integer>();

		for(int i=1;i<rowNum;i++){
			Row row = Sh.getRow(rowNum);
			int colNum = Sh.getRow(0).getLastCellNum();	
			String value = null;
			for( int j =0; j < colNum; j++){
				System.out.println("j:"+j);
				if(Sh.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase(header)){
					value =Sh.getRow(i).getCell(j).getStringCellValue();
					if(value.equals(relatedNumberFromCMS)){
						temp.add(i);
					}
					break;
				}
			}
			Wb.close();
			ips.close();
		}
		return temp;

	}
	}
