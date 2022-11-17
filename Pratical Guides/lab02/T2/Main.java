import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        File ficheiroPalavras = new File(args[0]);
        Scanner sc = new Scanner(ficheiroPalavras);
        int tamanhoSopa = sc.nextLine().length();
        int tempSize = tamanhoSopa;
        Requirements requirements = new Requirements();

        //check if file has blank lines.                                              /// Só funciona para o "palavras.txt"
        FileInputStream fstream = new FileInputStream("palavras.txt"); 
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        while ((strLine = br.readLine()) != null)   {
            if (strLine.isEmpty()){
                System.out.println("Error: The file has blank lines! (End of program)");
                br.close();
                sc.close();
                return;                                                               /// Return do main?
            }                                                                         /// Acho que devia ser System.exit(1);
        }
        br.close();                                                                   /// Falta fechar o fstream (fstream.close())

        // check if puzzle is square.                                                
        for (int i = 0, l = tamanhoSopa; i < l; i++) {
            if (tempSize != l) {
                System.out.println("Error: The puzzle is not a square! (End of the program)");
                sc.close();
                return;
            }
            String line = sc.nextLine();
            tempSize = line.length();
        }
        sc.close();
        
        //check soup size.
        if (tamanhoSopa > 40 || tamanhoSopa < 2){
            System.out.println("Error: Soup size invalid!");
            return;
        }
        

        WSSolver solver = new WSSolver();
        List<String> listaPalavras = solver.getWordList(ficheiroPalavras, tamanhoSopa);
        
        //check if word list contains any word with non alphabetical chars.
        for (String word : listaPalavras) {
            if(requirements.isAlpha(word) == false) {
                System.out.println("Error: List of words contains non alphabetical strings!");
                return;
            }
        }

        //check if word list contains any UPPERCASE word.
        for (String word : listaPalavras) {
            if(requirements.isUpperCase(word) == true) {
                System.out.println("Error: List of words contains UPPERCASE word!");
                return;
            }
        }

        System.out.println(listaPalavras);

        Character[][] sopa = solver.getSoupList(ficheiroPalavras, tamanhoSopa); //array bidimensional com a sopa de letras
        
        //check if puzzle chars are all UPPERCASE
        for(int i = 0; i < sopa.length; i++) {
            for(int j = 0; j < sopa[i].length; j++) {
                if (Character.isUpperCase(sopa[i][j]) == false) {
                    System.out.println("Error: Puzzle contains lowerCase letters!");
                    return;
                }
            }
        }
       
        Character[][] sopaResolved = solver.getSoupResolvedList(ficheiroPalavras, tamanhoSopa);
        
        for (int n = 0 ; n < tamanhoSopa ; n++)
        {
            String row1 = Arrays.toString(sopa[n]);
            row1 = row1.replace(",", " ").replace("[", " ").replace("]", " ");  //remove the commas, left brackets and right brackets /// ahhh???
            row1.trim();            //remove trailing spaces from partially initialized arrays
            System.out.println(row1);
        }
        System.out.println();

        for (String word : listaPalavras) {
            word = word.toUpperCase();
            String[] posicoes = solver.findWord(sopa, word);
            switch (posicoes[2]) {
                case "Right": // x não mexe e y aumenta
                    for (int i = Integer.valueOf(posicoes[1]); i < word.length() + Integer.valueOf(posicoes[1]); i++) {
                        int j = Integer.valueOf(posicoes[0]);
                        sopaResolved[j][i] = sopa[j][i];
                    }
                    break;
                case "UpRight":
                    int i1 = Integer.valueOf(posicoes[0]);
                    int j1 = Integer.valueOf(posicoes[1]);
                    while (i1 > Integer.valueOf(posicoes[0]) - word.length() && j1 < word.length() + Integer.valueOf(posicoes[1])) {
                        sopaResolved[i1][j1] = sopa[i1][j1];
                        i1--;
                        j1++;
                    }
                    break;
                case "Up":
                    for (int i = Integer.valueOf(posicoes[0]); i > Integer.valueOf(posicoes[0]) - word.length(); i--) {
                        int j = Integer.valueOf(posicoes[1]);
                        sopaResolved[i][j] = sopa[i][j];
                    }
                    break;
                case "UpLeft":
                    int i2 = Integer.valueOf(posicoes[0]);
                    int j2 = Integer.valueOf(posicoes[1]);
                    while (i2 > Integer.valueOf(posicoes[0]) - word.length() && j2 > Integer.valueOf(posicoes[1]) - word.length()) {
                        sopaResolved[i2][j2] = sopa[i2][j2];
                        i2--;
                        j2--;
                    }

                    break;
                case "Left":
                    for (int i = Integer.valueOf(posicoes[1]); i > Integer.valueOf(posicoes[1]) - word.length(); i--) {
                        int j = Integer.valueOf(posicoes[0]);
                        sopaResolved[j][i] = sopa[j][i];
                    }
                    break;
                case "DownLeft":
                    int i3 = Integer.valueOf(posicoes[0]);
                    int j3 = Integer.valueOf(posicoes[1]);
                    while (i3 < word.length() + Integer.valueOf(posicoes[0]) && j3 > Integer.valueOf(posicoes[1]) - word.length()) {
                        sopaResolved[i3][j3] = sopa[i3][j3];
                        i3++;
                        j3--;
                    }
                    break;
                case "Down":
                    for (int i = Integer.valueOf(posicoes[0]); i < word.length() + Integer.valueOf(posicoes[0]); i++) {
                        int j = Integer.valueOf(posicoes[1]);
                        sopaResolved[i][j] = sopa[i][j];
                    }
                    break;
                case "DownRight":
                    int i4 = Integer.valueOf(posicoes[0]);
                    int j4 = Integer.valueOf(posicoes[1]);
                    while (i4 < word.length() + Integer.valueOf(posicoes[0]) && j4 < word.length() + Integer.valueOf(posicoes[1])) {
                        sopaResolved[i4][j4] = sopa[i4][j4];
                        i4++;
                        j4++;
                    }
                default:
                    break;
            }
            word = word.toLowerCase();
            System.out.printf("%-10s %-2d (%-2s,%-1s) %s\n", word, word.length(), posicoes[0], posicoes[1], posicoes[2]);
            
        }
        System.out.println();
        for (int n = 0 ; n < tamanhoSopa ; n++){
            String row2 = Arrays.toString(sopaResolved[n]);
            row2 = row2.replace(",", " ").replace("[", " ").replace("]", " ");  //remove the commas, left brackets and right brackets
            row2.trim();            //remove trailing spaces from partially initialized arrays
            System.out.println(row2);
        }

    }
}