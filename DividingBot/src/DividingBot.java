import java.util.*;
//import java.lang.Math.*;

public class DividingBot{
    
	static Scanner scanner;
    static int firstNumber=0;
	static int secondNumber=0;
	static int reply=0;
	static int intervalPosition = 0;
    static String firstNumberLine;
	static String secondNumberLine;
	static String input;
    
	public static String[] splitApart(String string, int splitHereIndex){
        String[] result = new String[2];
        result[0] = string.substring(0, splitHereIndex);
        result[1] = string.substring(splitHereIndex);
        return result;
    }
    
    public static void initialChecks()throws Exception{
    	try{
            firstNumber = Integer.parseInt(firstNumberLine);
        }
        catch(Exception e){
            System.out.println("������ ������� ����������: �������� ������ �����");
            System.exit(0);
        }
        try{
            secondNumber = Integer.parseInt(secondNumberLine);
        }
        catch(Exception e){
            System.out.println("������ ������� ����������: �������� ������ �����");
            System.exit(0);
        }
        if(firstNumber<secondNumber){
            System.out.println("������ ������� ����������: ���������� �������� ����� � ���� ������ ����� � ��������");
            System.exit(0);
        }
        if(secondNumber==0){
            System.out.println("������ ������� ����������: ���������� ��������� �� 0");
            System.exit(0);
        }
        intervalPosition = input.indexOf("/");
        if(intervalPosition<1){
            System.out.println("������ ������� ����������: �������� ������ �����");
            System.exit(0);
        }
    }
    
    public static void main(String []args) throws Exception{
        
        System.out.println("����� ���������� � ������� ��������������� ������� ���������!");
        System.out.println("������� ������� � �������: �������/��������");
        scanner = new Scanner(System.in);
        input = scanner.nextLine();
        initialChecks();
        scanner.close();
        
        String[] numberLines = input.split("/");
        firstNumberLine = numberLines[0];
        secondNumberLine = numberLines[1];
                
        reply = Math.round(firstNumber/secondNumber);
        String replyLine = Integer.toString(reply);        
        int splittableLength = secondNumberLine.length();
        String firstNumberRemainder = firstNumberLine;
        int counter = 0;
        int startPrintPosition = 1;
        
        while(firstNumberRemainder.length()>0){
        	String iterationLine1="";
        	String iterationLine2="";
        	String iterationLine3="";
        	String iterationLine4="";
        	String iterationLine5="";
        	
        	iterationLine1 = " " + firstNumber + " | " + secondNumber;
            System.out.println(iterationLine1);
            
            iterationLine2="-";
            for(int i=0; i<firstNumberLine.length(); i++){
            	iterationLine2 += " ";
            }
            iterationLine2 += " | ";
            for(int i=0; i<secondNumberLine.length()+1; i++){
            	iterationLine2 += "-";
            }
            System.out.println(iterationLine2);
        	
        	String[] fragmentedNumber = splitApart(firstNumberLine, splittableLength);
            String firstNumberFragmentLine = fragmentedNumber[0];
            firstNumberRemainder = fragmentedNumber[1];
            int firstNumberFragment = Integer.parseInt(firstNumberFragmentLine);
            if(firstNumberFragment<secondNumber){
                splittableLength++;
                continue;
            }
            int multiplication = secondNumber*Character.digit(replyLine.charAt(counter), 10);
            int subtraction = firstNumberFragment-multiplication;
            int firstNumberFragmentLength=firstNumberFragmentLine.length();
            int multiplicationLength = Integer.toString(multiplication).length();
            if(firstNumberFragmentLength > multiplicationLength){
            	iterationLine3 += " ";
            }
            iterationLine3 += subtraction;
            //iterationLine3=printable + subtraction;
            if(counter==0){
                for(int i=0; i<firstNumberRemainder.length(); i++){
                	startPrintPosition++;
                }
                iterationLine3 += " | " + reply;
            }
            System.out.println(iterationLine3);
            counter++;
            splittableLength = secondNumberLine.length();
        }
        
        
        
        
        
        //char[] firstNumberChars = numbers[0].toCharArray();
        //char[] secondNumberChars = numbers[1].toCharArray();
        
        //int secondNumberCharsLength = secondNumberChars.length();
        //int firstNumberFragment
        
        
        
        
        
     }
}