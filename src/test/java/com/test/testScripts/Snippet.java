package com.test.testScripts;

import java.io.IOException;

import com.test.Utils.getData;

public class Snippet {
	public static void main(String[] args) throws IOException {
		
		
		getData.writeValueInExcelFile("LineitemCMS","MessageCode",1,"pass");
	}

}
