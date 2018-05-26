package NameFinderExample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author disha
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
 
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;


public class NameFinderExample {
 
    
 
    /**
     * method to find locations in the sentence
     * @throws IOException
     */
    public void findName(String speech) throws IOException {
        InputStream is = new FileInputStream("en-ner-person.bin");
        System.out.println(speech);
 
        // load the model from file
        TokenNameFinderModel model = new TokenNameFinderModel(is);
        is.close();
 
        // feed the model to name finder class
        NameFinderME nameFinder = new NameFinderME(model);
        String[] sentence = speech.split("\\s+");
        for (int i = 0; i < sentence.length; i++) {
    // You may want to check for a non-word character before blindly
    // performing a replacement
    // It may also be necessary to adjust the character class
        sentence[i] = sentence[i].replaceAll("[^\\w]", "");
        }
 
        System.out.println("hello");
 System.out.println(sentence[0]);
        System.out.println("hello");
        String s1[]={"John","Smith"};
        Span nameSpans[] = nameFinder.find(s1);
 System.out.println(nameSpans[0]);
 System.out.println("something");
 
        // nameSpans contain all the possible entities detected
        for(Span s: nameSpans){
            
            System.out.print(s.toString());
            System.out.print("  :  ");
            // s.getStart() : contains the start index of possible name in the input string array
            // s.getEnd() : contains the end index of the possible name in the input string array
            for(int index=s.getStart();index<s.getEnd();index++){
                System.out.print(sentence[index]+" ");
            }
            System.out.println();
        }
    }
    
    /**
     * method to find locations in the sentence
     * @throws IOException
     */
    public void findLocation(String speech) throws IOException {
        InputStream is = new FileInputStream("en-ner-location.bin");
 
        // load the model from file
        TokenNameFinderModel model = new TokenNameFinderModel(is);
        is.close();
 
        // feed the model to name finder class
       // System.out.println(speech);
        NameFinderME nameFinder = new NameFinderME(model);
 
        String[] sentence = speech.split("\\s+");
        for (int i = 0; i < sentence.length; i++) {
        // You may want to check for a non-word character before blindly
        // performing a replacement
        // It may also be necessary to adjust the character class
        sentence[i] = sentence[i].replaceAll("[^\\w]", "");
         }
                                File file = new File("test1.txt");
				FileWriter fileWriter = new FileWriter(file);
        Span nameSpans[] = nameFinder.find(sentence);
 
        // nameSpans contain all the possible entities detected
        for(Span s: nameSpans){
            System.out.print(s.toString());  
            System.out.print("  :  ");
            // s.getStart() : contains the start index of possible name in the input string array
            // s.getEnd() : contains the end index of the possible name in the input string array
            for(int index=s.getStart();index<s.getEnd();index++){
                System.out.print(s);
            }
            System.out.println();
            
        }
    }
    
}


