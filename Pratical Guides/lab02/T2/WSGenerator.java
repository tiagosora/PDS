import java.io.*;
import java.util.*;

public class WSGenerator {

    public static void main(String[] args) throws IOException{
        File ficheiroPalavras = new File(args[0]);
        File ficheiroDirections = new File(args[1]);
        GeneratorFuncs funcs = new GeneratorFuncs();
        Scanner sc = new Scanner(ficheiroPalavras);
        Scanner sc2 = new Scanner(ficheiroDirections);
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> directions = new ArrayList<>();
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            String[] currentWords = currentLine.split("[,; ]");
            for (int i = 0; i < currentWords.length; i++) {
                words.add(currentWords[i]);
            }
        }
        while (sc2.hasNextLine()) {
            String currentLine = sc2.nextLine();
            String[] currentDirections = currentLine.split("[,; ]");
            for (int i = 0; i < currentDirections.length; i++) {
                directions.add(currentDirections[i]);
            }
        }
        sc.close();
        sc2.close();
        int soupSize = 15;
        Character[][] soupBlank = new Character[soupSize][soupSize];
        for (int i = 0; i < soupSize; i++) {
            String currentLine = "*";
            for (int j = 0; j < soupSize; j++) {
                soupBlank[i][j] = currentLine.charAt(0);
            }
        }
        for (int n = 0 ; n < soupSize ; n++){
            String row = Arrays.toString(soupBlank[n]);
            row = row.replace(",", " ").replace("[", " ").replace("]", " ");  //remove the commas, left brackets and right brackets
            row.trim();            //remove trailing spaces from partially initialized arrays
            System.out.println(row);
        }
        int Min = 0;
        int Max = soupSize - 1;
check1: for (String word : words){
            String tempWord = word;
            int tamanhoPalavra = word.length();
            int x = funcs.getRandomNumber(Min, Max);
            int y = funcs.getRandomNumber(Min, Max);
            int randomDirectionNumber = funcs.getRandomNumber(0, 7);
            String randomDirection = directions.get(randomDirectionNumber);
            LinkedHashMap<Character, Character> tempLocations = new LinkedHashMap<Character, Character>();
            switch (randomDirection) {
                case "Right":
                if (tamanhoPalavra <= (soupSize - y)){
                    for (int i = y; i < (y + tamanhoPalavra); i++) {
                        if(soupBlank[x][i] == '*'){
                            char xi = (char)x;
                            char yi = (char)y;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                        }
                        else if(soupBlank[x][i] == word.charAt(0)){
                            char xi = (char)x;
                            char yi = (char)y;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                        }
                        else{
                            continue check1;
                        }
                    }
                    for(int i=0; i<tamanhoPalavra;i++){
                        Character xPos= tempLocations.get(tempLocations.keySet().toArray()[i]);
                        Character yPos= (Character)tempLocations.values().toArray()[i];
                        int xPos2 = xPos;
                        int yPos2 = yPos;
                        soupBlank[xPos2][yPos2] = tempWord.charAt(0);
                        tempWord = tempWord.substring(1);
                    }
                }
                continue check1;
                case "UpRight":
                if ((x + 1) >= tamanhoPalavra && tamanhoPalavra <= (soupSize - (y + 1))){
                    int p = x;
                    for (int i = y; i < (y + tamanhoPalavra); i++) {
                        if(soupBlank[p][i] == '*'){
                            char xi = (char)p;
                            char yi = (char)y;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                            p -= 1;
                        }
                        else if(soupBlank[p][i] == word.charAt(0)){
                            char xi = (char)p;
                            char yi = (char)y;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                            p -= 1;
                        }
                        else{
                            continue check1;
                        }
                    }
                    for(int i=0; i<tamanhoPalavra;i++){
                        Character xPos= tempLocations.get(tempLocations.keySet().toArray()[i]);
                        Character yPos= (Character)tempLocations.values().toArray()[i];
                        int xPos2 = xPos;
                        int yPos2 = yPos;
                        soupBlank[xPos2][yPos2] = tempWord.charAt(0);
                        tempWord = tempWord.substring(1);
                    }
                }
                continue check1;
                case "Up":
                if ((x + 1) >= tamanhoPalavra){
                    for (int i = x; i > (x - tamanhoPalavra); i--) {
                        if(soupBlank[i][y] == '*'){
                            char xi = (char)i;
                            char yi = (char)y;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                        }
                        else if(soupBlank[i][y] == word.charAt(0)){
                            char xi = (char)i;
                            char yi = (char)y;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                        }
                        else{
                            continue check1;
                        }
                    }
                    for(int i=0; i<tamanhoPalavra;i++){
                        Character xPos= tempLocations.get(tempLocations.keySet().toArray()[i]);
                        Character yPos= (Character)tempLocations.values().toArray()[i];
                        int xPos2 = xPos;
                        int yPos2 = yPos;
                        soupBlank[xPos2][yPos2] = tempWord.charAt(0);
                        tempWord = tempWord.substring(1);
                    }
                }
                    continue check1;
                case "UpLeft":
                if ((x + 1) >= tamanhoPalavra && tamanhoPalavra <= (y + 1)){
                    int p = x;
                    for (int i = y; i > (y - tamanhoPalavra); i--){
                        if(soupBlank[p][i] == '*'){
                            char xi = (char)p;
                            char yi = (char)i;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                            p -= 1;
                        }
                        else if(soupBlank[p][i] == word.charAt(0)){
                            char xi = (char)p;
                            char yi = (char)i;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                            p -= 1;
                        }
                        else{
                            continue check1;
                        }
                    }
                    for(int i=0; i<tamanhoPalavra;i++){
                        Character xPos= tempLocations.get(tempLocations.keySet().toArray()[i]);
                        Character yPos= (Character)tempLocations.values().toArray()[i];
                        int xPos2 = xPos;
                        int yPos2 = yPos;
                        soupBlank[xPos2][yPos2] = tempWord.charAt(0);
                        tempWord = tempWord.substring(1);
                    }
                }
                continue check1;
                case "Left":
                if (tamanhoPalavra <= (y + 1)){
                    for (int i = y; i > (y - tamanhoPalavra); i--) {
                        if(soupBlank[x][i] == '*'){
                            char xi = (char)x;
                            char yi = (char)y;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                        }
                        else if(soupBlank[x][i] == word.charAt(0)){
                            char xi = (char)x;
                            char yi = (char)y;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                        }
                        else{
                            continue check1;
                        }
                    }
                    for(int i=0; i<tamanhoPalavra;i++){
                        Character xPos= tempLocations.get(tempLocations.keySet().toArray()[i]);
                        Character yPos= (Character)tempLocations.values().toArray()[i];
                        int xPos2 = xPos;
                        int yPos2 = yPos;
                        soupBlank[xPos2][yPos2] = tempWord.charAt(0);
                        tempWord = tempWord.substring(1);
                    }
                }
                continue check1;
                case "DownLeft":
                if ((soupSize - x) >= tamanhoPalavra && tamanhoPalavra <= (y + 1)){
                    int p = x;
                    for (int i = y; i > (y - tamanhoPalavra); i--){
                        if(soupBlank[p][i] == '*'){
                            char xi = (char)p;
                            char yi = (char)i;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                            p+=1;
                        }
                        else if(soupBlank[p][i] == word.charAt(0)){
                            char xi = (char)p;
                            char yi = (char)i;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                            p+=1;
                        }
                        else{
                            continue check1;
                        }
                    }
                    for(int i=0; i<tamanhoPalavra;i++){
                        Character xPos= tempLocations.get(tempLocations.keySet().toArray()[i]);
                        Character yPos= (Character)tempLocations.values().toArray()[i];
                        int xPos2 = xPos;
                        int yPos2 = yPos;
                        soupBlank[xPos2][yPos2] = tempWord.charAt(0);
                        tempWord = tempWord.substring(1);
                    }
                }
                continue check1;
                case "Down":
                if ((soupSize - x) >= tamanhoPalavra){
                    for (int i = x; i < (x + tamanhoPalavra); i++) {
                        if(soupBlank[i][y] == '*'){
                            char xi = (char)i;
                            char yi = (char)y;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                        }
                        else if(soupBlank[i][y] == word.charAt(0)){
                            char xi = (char)i;
                            char yi = (char)y;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                        }
                        else{
                            continue check1;
                        }
                    }
                    for(int i=0; i<tamanhoPalavra;i++){
                        Character xPos= tempLocations.get(tempLocations.keySet().toArray()[i]);
                        Character yPos= (Character)tempLocations.values().toArray()[i];
                        int xPos2 = xPos;
                        int yPos2 = yPos;
                        soupBlank[xPos2][yPos2] = tempWord.charAt(0);
                        tempWord = tempWord.substring(1);
                    }
                }
                continue check1;
                case "DownRight":
                if ((soupSize - x) >= tamanhoPalavra
                    && tamanhoPalavra <= (soupSize - (y + 1))){
                    int p = x;
                    for (int i = y; i < (y + tamanhoPalavra); i++){
                        if(soupBlank[p][i] == '*'){
                            char xi = (char)p;
                            char yi = (char)i;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                            p+=1;
                        }
                        else if(soupBlank[p][i] == word.charAt(0)){
                            char xi = (char)p;
                            char yi = (char)i;
                            tempLocations.put(xi,yi);
                            word = word.substring(1);
                            p+=1;
                        }
                        else{
                            continue check1;
                        }
                    }
                    for(int i=0; i<tamanhoPalavra;i++){
                        Character xPos= tempLocations.get(tempLocations.keySet().toArray()[i]);
                        Character yPos= (Character)tempLocations.values().toArray()[i];
                        int xPos2 = xPos;
                        int yPos2 = yPos;
                        soupBlank[xPos2][yPos2] = tempWord.charAt(0);
                        tempWord = tempWord.substring(1);
                    }
                }
                    continue check1;    
            }
            //IR BUSCAR O VALOR AO TEMPLOCATION E ADICIONAR AO ARRAY BIDIMENSIONAL.
            
       
        }
        System.out.println();
        for (int n = 0 ; n < soupSize ; n++){
            String row2 = Arrays.toString(soupBlank[n]);
            row2 = row2.replace(",", " ").replace("[", " ").replace("]", " ");  //remove the commas, left brackets and right brackets
            row2.trim();            //remove trailing spaces from partially initialized arrays
            System.out.println(row2);
        }
   }
}