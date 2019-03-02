package englishdictionary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnglishDictionary {
	
    static void kontrolEt(String englishWord){
        String kelime = "";
        String currentWord = "";
        Scanner in = new Scanner(System.in);
        
        try (Scanner oku = new Scanner(new FileReader("C:\\Users\\CUNEYT\\Desktop\\UnknownWords.txt"));
                FileWriter yaz = new FileWriter("C:\\Users\\CUNEYT\\Desktop\\UnknownWords.txt",true)){
            
            while(oku.hasNext()) {
            	currentWord = oku.next();
        	if(currentWord.equals(":")) {
                    if(kelime.equals(englishWord+" ")){
        	        System.out.println("Eklemek istenen kelime daha �nce eklenmi�.");
        	        System.out.println(kelime +"->"+ oku.nextLine());
        	        return;
        	    }
        	    else{
        	        kelime = "";
        	        oku.nextLine();
        	    }
                }
        	else {
                    kelime += currentWord +" ";
                }
            }
        yaz.write("\n" + englishWord + " : " + in.nextLine());
            
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamad�.");
        } catch (IOException ex) {
            Logger.getLogger(EnglishDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        
        kontrolEt(word); // word kelimesi dosyada varsa yazmayacak.
        in.close();
    }
    
}
