package compiler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Compiler {

    public Compiler() {
    }
  
   static String identifier="[A-Z a-z]([A-Z a-z])*";
    static String letter="[A-Z a-z]";
   static String number="[0-9]+";
   static String comment="[{][A-Z a-z]*[0-9]*[}]";
   static String token;
   static String ReservedWords[]={"if","then","else","end","repeat","until","read","write"};
   static String Operation[][]={{"+","-","*","/","="},{"ADD","SUBTRACT","MULTIPLY","DIVIDE","EQUAL"}};
   static String Operator[][]={{"||","&&","==","<=",">=","<",">",":="},
   {"OR","AND","EQUAL TO","LESS THAN OR EQUAL","GREATER THAN OR EQUAL",
                     "LESS THAN","GREATER THAN","ASSIGN OPERATOR"}};
   static String[][] Symbols={{";",":","(",")","{","}"},
   {"Semi-Colon","Colon","RightP","LeftP","RightCurlyBracket","LeftCurlyBracket"}};
   static ArrayList<String> symbols=new ArrayList<String>();
   static ArrayList<String> reservedWords = new ArrayList<String>();
   static ArrayList<String> operation = new ArrayList<String>();
   static ArrayList<String> operator = new ArrayList<String>();
   
  static ArrayList<String> tokenList = new ArrayList<String>();
   static Scanner input;
   static String fileName;
    
   public static void getToken(String code) 
   {
       for(int i=0;i<Symbols[0].length;i++)
       {
           symbols.add(Symbols[0][i]);
       }
       for(int i=0;i<Operator[0].length;i++)
       {
           operator.add(Operator[0][i]);
       }
       for(int i=0;i<ReservedWords.length;i++)
       {
           reservedWords.add(ReservedWords[i]);
       }
       for(int i=0;i<Operation[0].length;i++)
       {
           operation.add(Operation[0][i]);
       }
           
           
               token=code;
                
               if(symbols.contains(token))
               {
                 System.out.println(token+" | "+Symbols[1][symbols.indexOf(token)]);
                 tokenList.add(token+" | "+Symbols[1][symbols.indexOf(token)]+"\n");
               }
               else if(reservedWords.contains(token))
               {
                System.out.println(token+" | "+"Reserved Word"); 
                tokenList.add(token+" | "+"Reserved Word"+"\n");
               }
               else if(operator.contains(token))
               {
                   System.out.println(token+" | "+Operator[1][operator.indexOf(token)]);
                   tokenList.add(token+" | "+Operator[1][operator.indexOf(token)]+"\n");
               }
               else if(operation.contains(token))
               {
                   System.out.println(token+" | "+Operation[1][operation.indexOf(token)]);
                   tokenList.add(token+" | "+Operation[1][operation.indexOf(token)]+"\n");
               }
               else if(token.matches(letter))
               {
                   System.out.println(token+" | Letter");
                   tokenList.add(token+" | letter"+"\n");
               }
               else if(token.matches(identifier))
               {
                   System.out.println(token+" | Identifier");
                   tokenList.add(token+" | Identifier"+"\n");
               }
               else if(token.matches(number))
               {
                   System.out.println(token+" | Number"); 
                   tokenList.add(token+" | Number"+"\n");
               }
               
               else if(token.matches(comment))
               {
                   System.out.println(token+" | Comment");
                   tokenList.add(token+" | comment"+"\n");
               }
               else if(token.matches(" "))
               {
                   
               }
               else 
                   System.out.println(token+" | unrecognized");
                   
                   
           }
               
     
   }
   
   
    

