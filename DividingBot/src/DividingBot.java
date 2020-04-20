import java.util.*;
//import java.lang.Math.*;

public class DividingBot{
    
	static Scanner scanner;
    static int firstNumber=0;
	static int secondNumber=0;
	static int reply=0;
	static int intervalPosition=0;
    static int counter=0;
	static int startPrintPosition=0;
	static int multiplication=0;
	static int subtraction=0;
	//static int firstNumberFragmentLength=0;
	//static int multiplicationLength=0;
	static int firstNumberFragment=0;
	static String firstNumberLine;
	static String secondNumberLine;
	static String replyLine;
	static String input;
	static String firstNumberRemainder;
	static String multiplicationLine;
	static String subtractionLine;
	static String firstNumberFragmentLine;
    
	public static void main(String []args) throws Exception{
        
        System.out.println("Добро пожаловать в утилиту автоматического деления столбиком!");
        System.out.println("Введите задание в формате: делимое/делитель");
        scanner = new Scanner(System.in);
        input = scanner.nextLine();
        scanner.close();
        inputChecks();
        reply = Math.round(firstNumber/secondNumber);
        replyLine = Integer.toString(reply);  
        
        int splittableLength = secondNumberLine.length();
        while(true){
        	String[] fragmentedNumber = splitApart(firstNumberLine, splittableLength);
            firstNumberFragmentLine = fragmentedNumber[0];
            firstNumberRemainder = fragmentedNumber[1];
            firstNumberFragment = Integer.parseInt(firstNumberFragmentLine);
            if(firstNumberFragment<secondNumber){
                splittableLength++;
                continue;
            }
            else break;
        }
        do{
        	System.out.println(getIterationLine1());
        	System.out.println(getIterationLine2());
        	System.out.println(getIterationLine3());
        	System.out.println(getIterationLine4());
        	//counter++; 
        } while(firstNumberRemainder.length()>0);
    }
		
	public static String getIterationLine1() {
		String output="";
		if(counter==0){
			startPrintPosition++;
			output = printRegex(" ", startPrintPosition) + firstNumber + " | " + secondNumber;
		}
		else {
			subtraction = firstNumberFragment-multiplication;
			startPrintPosition += Integer.toString(multiplication).length() - Integer.toString(subtraction).length();
			firstNumberFragment = subtraction;
			int repeat=0;
			while(firstNumberFragment < secondNumber && firstNumberRemainder.length()>0) {
					firstNumberFragment = firstNumberFragment*10 + Character.digit(firstNumberRemainder.charAt(0), 10);
					if(firstNumberRemainder.length()>1)
						firstNumberRemainder=firstNumberRemainder.substring(1);
					else if(firstNumberRemainder.length()==1) firstNumberRemainder="";
					if(repeat>0) counter++;
					repeat++;
			}
			firstNumberFragmentLine = Integer.toString(firstNumberFragment);
			
			output = printRegex(" ", startPrintPosition) + firstNumberFragmentLine;
		}
		return output;
	}
	
	public static String getIterationLine2() {
		String output="";
		startPrintPosition--;
		output = printRegex(" ", startPrintPosition);
		output = printRegex("-", 1);
		if(counter==0) {
			output += printRegex(" ", firstNumberLine.length());
			output += " | ";
			output += printRegex("-", secondNumberLine.length()+1);
		}
		return output;
	}
	
	public static String getIterationLine3() {
		String output="";
		multiplication = secondNumber*Character.digit(replyLine.charAt(counter), 10);
		startPrintPosition++;
		if(firstNumberFragmentLine.length() > Integer.toString(multiplication).length()) {
			startPrintPosition++;
		}
		output = printRegex(" ", startPrintPosition);
		output += multiplication;
		if(counter==0) {
			output += printRegex(" ", firstNumberRemainder.length());
			output += " | " + reply;
			counter++;
		}
		return output;
	}
	
	public static String getIterationLine4() {
		String output="";
		output = printRegex(" ", startPrintPosition);
		output += printRegex("-", Integer.toString(multiplication).length());
		return output;
	}
	
	public static void inputChecks()throws Exception{
		try{
			String[] numberLines = input.split("/");
			firstNumberLine = numberLines[0];
			secondNumberLine = numberLines[1];
		}
		catch(Exception e) {
			System.out.println("Работа утилиты прекращена: неверный формат ввода");
            System.exit(0);
		}
		try{
            firstNumber = Integer.parseInt(firstNumberLine);
        }
        catch(Exception e){
            System.out.println("Работа утилиты прекращена: неверный формат ввода");
            System.exit(0);
        }
        try{
            secondNumber = Integer.parseInt(secondNumberLine);
        }
        catch(Exception e){
            System.out.println("Работа утилиты прекращена: неверный формат ввода");
            System.exit(0);
        }
        if(firstNumber<secondNumber){
            System.out.println("Работа утилиты прекращена: Невозможно получить ответ в виде целого числа с остатком");
            System.exit(0);
        }
        if(secondNumber==0){
            System.out.println("Работа утилиты прекращена: Невозможно разделить на 0");
            System.exit(0);
        }
        intervalPosition = input.indexOf("/");
        if(intervalPosition<1){
            System.out.println("Работа утилиты прекращена: неверный формат ввода");
            System.exit(0);
        }
    }
	public static String[] splitApart(String string, int splitHereIndex){
        String[] result = {string.substring(0, splitHereIndex), string.substring(splitHereIndex)};
        
        return result;
    }
	
	public static String printRegex(String regex, int times) {
		String output="";
		for(int i=0; i<times; i++){
        	output += regex;
        }
		return output;
	}
}