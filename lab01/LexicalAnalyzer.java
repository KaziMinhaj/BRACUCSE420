package lab01;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class LexicalAnalyzer {
	String[] keywordsArray = {"int","double","float","String","if","else"};
	String[] othersArray = {"(",")",";","{","}",","};
	String[] mathOperatorArray = {"+","-","=","/","*"};
	String[] logicalOperatorsArray = {">","<","<=",">="};
	String keywords = "";
	String others = "";
	String mathOperators = "";
	String logicalOperator = "";
	String numericValue = "";
	String identifiers = "";
	public void anlyze() {
		try {
			File inputFile = new File("input.txt");
			Scanner sc = new Scanner(inputFile);
			// check is there any next line?
			while(sc.hasNextLine()) {
				String currentLine = sc.nextLine(); // save the current line
				findKeyWord(currentLine.split(" ",2));
				findOthers(currentLine.split(""));
				findMathOperators(currentLine.split(""));
				findLogicalOperators(currentLine.split(""));
				findNumericValue(currentLine.split(""));
			}
			sc.close();
			System.out.println("Keywords: "+keywords);
			System.out.println("Identifiers: "+identifiers);
			System.out.println("Math Operators: "+mathOperators);
			System.out.println("Logical Operators: "+logicalOperator);
			System.out.println("Numerical Values: "+numericValue);
			System.out.println("Others: "+others);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void findKeyWord(String[] currentLineArray) {
		if(Arrays.asList(keywordsArray).contains(currentLineArray[0])) {
			addKeyWord(currentLineArray[0]);
//			System.out.println("keys :"+currentLineArray[0]);
			if(currentLineArray.length >1  ){
				
				findIdentifiers(currentLineArray[1].split(""));
			}
		}
	}
	
	public void addKeyWord(String word) {
		if(!keywords.contains(word)) {
			if(keywords.equals("")) {
				keywords=word;
			}
			else {
				keywords = keywords+ ","+word;
			}
		}
	}
	public void findOthers(String[] currentLineArray) {
		for(int i= 0; i< currentLineArray.length;i++) {
			if(Arrays.asList(othersArray).contains(currentLineArray[i])) {
				addOthers(currentLineArray[i]);
			}
			
		}
	}
	public void addOthers(String x) {
		if(!others.contains(x)) {
			if(others.equals("")) {
				others=x;
			}
			else {
				others = others+ " "+x;
			}
		}
	}
	public void findMathOperators(String[] currentLineArray){
		for(int i= 0; i< currentLineArray.length;i++) {
			if(Arrays.asList(mathOperatorArray).contains(currentLineArray[i])) {
				addMathOperators(currentLineArray[i]);
			}
			
		}
	}
	public void addMathOperators(String x) {
		if(!mathOperators.contains(x)) {
			if(mathOperators.equals("")) {
				mathOperators=x;
			}
			else {
				mathOperators = mathOperators+ " , "+x;
			}
		}
	}
	public void findLogicalOperators(String[] currentLineArray){
		for(int i= 0; i< currentLineArray.length;i++) {
			if(Arrays.asList(logicalOperatorsArray).contains(currentLineArray[i])) {
				addLogicalOperators(currentLineArray[i]);
			}
			
		}
	}
	public void addLogicalOperators(String x) {
		if(!logicalOperator.contains(x)) {
			if(logicalOperator.equals("")) {
				logicalOperator=x;
			}
			else {
				logicalOperator = logicalOperator+ " , "+x;
			}
		}
	}
	
	public void findNumericValue(String[] currentLineArray){
		for(int i= 0; i< currentLineArray.length;i++) {
			if( Character.isDigit(currentLineArray[i].charAt(0))) {
				addNumericValue(currentLineArray[i]);
			}
			
		}
	}
	public void addNumericValue(String x) {
		if(!numericValue.contains(x)) {
			if(numericValue.equals("")) {
				numericValue=x;
			}
			else {
				numericValue = numericValue+ " , "+x;
			}
		}
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public void findIdentifiers(String[] currentLineArrayParams){
//		System.out.print(currentLineArrayParams); 
		for(int i= 0; i<currentLineArrayParams.length;i++) {
			if(Character.isLetter(currentLineArrayParams[i].charAt(0))) {
				addidentifiers(currentLineArrayParams[i]);
			}
		}
//		addidentifiers(currentLineArrayParams);
	}
	public void addidentifiers(String x) {
		if(!identifiers.contains(x)) {
			if(identifiers.equals("")) {
				identifiers=x;
			}
			else {
				identifiers = identifiers+ " , "+x;
			}
		}
	}
	
}


