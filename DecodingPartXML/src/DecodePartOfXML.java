/*
В файле XML у которого кодировка UTF-8
часть записей в кодировке windows-1251 :

<OW_LNAME>ÁÎÐÎÄÈÍ</OW_LNAME>
<OW_FNAME>ÈÃÎÐÜ</OW_FNAME>
<OW_MNAME>ÞÐÜÅÂÈ×</OW_MNAME>

кодируем эти записи в UTF-8
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DecodePartOfXML {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);

        System.out.println("Paste full path to folder");
        String pathToFolder = userInput.nextLine();

        System.out.println("Paste name of file with extension");
        String fileName = userInput.nextLine();

        String pathToFile = pathToFolder + "/" + fileName;
        String  line = "";
        String originalFile = "";

        try{
            FileReader reader = new FileReader(pathToFile);
            BufferedReader buffReader = new BufferedReader(reader);

            while ((line = buffReader.readLine()) != null){
                originalFile += line;
            }
            buffReader.close();;

            for (int i = 0; i < originalFile.length() - 10; ++i){
                if(originalFile.charAt(i) == '<' && originalFile.charAt(i + 1) == 'O' && (originalFile.charAt( i + 4) == 'L' || originalFile.charAt(i + 4) == 'F' || originalFile.charAt(i + 4) == 'M')){
                    //System.out.println(originalFile.charAt(i + 10));
                    int beginOfSubstring  = i + 10;
                    int endOfSubstring = i + 10;
                    String toDecode = "";
                    String decoded = "";
                    String decoded2 = "";
                    for(int j = beginOfSubstring; j < originalFile.length() - 10; ++j){
                        if (originalFile.charAt(j) == '<'){
                            endOfSubstring = j;
                            toDecode = originalFile.substring(beginOfSubstring, endOfSubstring);
                            //decoded = new String(toDecode.getBytes("windows-1251"), "UTF-8");
                            byte[] fromToDecode = toDecode.getBytes("windows-1251");
                            String testString = new String(fromToDecode);
                            decoded = new String(toDecode.getBytes("windows-1251"), "UTF-8");
                            decoded2 = new String(decoded.getBytes("windows-1252"), "UTF-8");
                            //System.out.println(testString);
                            break;
                        }
                    }
                    System.out.println(toDecode);
                    System.out.println(decoded);
                    //System.out.println(decoded2);

                }
                //System.out.println();
            }

        } catch (IOException e){
            System.out.println("Can't read file from " + pathToFile);
        }
    }
}
