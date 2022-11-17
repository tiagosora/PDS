import java.io.*;
import java.util.*;


public class WSSolver {
    public ArrayList<String> getWordList(File thisFile, int numLinhas) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(thisFile);

        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < numLinhas; i++) {
            fileScanner.nextLine();
        }
        while (fileScanner.hasNextLine()) {
            String currentLine = fileScanner.nextLine();

            String[] currentWords = currentLine.split("[,; ]");
            for (int i = 0; i < currentWords.length; i++) {
                words.add(currentWords[i]);
            }
        }

        fileScanner.close();
        return words;
    }

    public Character[][] getSoupList(File thisFile, int numLinhas) throws FileNotFoundException {
        Scanner sc = new Scanner(thisFile);

        Character[][] soup = new Character[numLinhas][numLinhas]; // define dimensão do array de caracteres
                                                                  // multidimensional
        for (int i = 0; i < numLinhas; i++) {
            String currentLine = sc.nextLine();
            for (int j = 0; j < numLinhas; j++) {
                soup[i][j] = currentLine.charAt(j);
                
            }
        }

        sc.close();
        return soup;
    }
    public Character[][] getSoupResolvedList(File thisFile, int numLinhas) throws FileNotFoundException {
        Scanner sc = new Scanner(thisFile);

        Character[][] soupResolved = new Character[numLinhas][numLinhas]; // define dimensão do array de caracteres
                                                                  // multidimensional
        for (int i = 0; i < numLinhas; i++) {
            String currentLine = "*";
            for (int j = 0; j < numLinhas; j++) {
                soupResolved[i][j] = currentLine.charAt(0);
            }
        }

        sc.close();
        return soupResolved;
    }

    public String[] findWord(Character[][] sopa, String word) {
        int tamanhoLinhas = sopa.length;
        word = word.toUpperCase();
        int tamanhoPalavra = word.length();

        String[] posicoes = new String[3];
        char init = word.charAt(0);
    for (int x = 0; x < tamanhoLinhas; x++) {
            for (int y = 0; y < tamanhoLinhas; y++) {
                if (init == sopa[x][y]) {
                check1 :if (tamanhoPalavra <= (tamanhoLinhas - y)) { /* RIGHT */
                        StringBuilder sb = new StringBuilder();
                        for (int i = y; i < (y + tamanhoPalavra); i++) {
                            sb.append(sopa[x][i]);
                        }
                        String tempWord = sb.toString();
                        if (tempWord.equals(word)) {
                            posicoes[0] = String.valueOf(x);
                            posicoes[1] = String.valueOf(y);
                            posicoes[2] = "Right";
                            return posicoes;
                        } 
                        if (!tempWord.equals(word)) {
                            break check1; 
                        }
                        
                    }
                    check2:if ((x + 1) >= tamanhoPalavra && tamanhoPalavra <= (tamanhoLinhas - (y + 1))) { /* UPRIGHT */
                        StringBuilder sb = new StringBuilder();
                        int p = x;
                        for (int i = y; i < (y + tamanhoPalavra); i++) {
                            sb.append(sopa[p][i]);
                            p -= 1;
                        }
                        String tempWord = sb.toString();
                        if (tempWord.equals(word)) {
                            posicoes[0] = String.valueOf(x);
                            posicoes[1] = String.valueOf(y);
                            posicoes[2] = "UpRight";
                            return posicoes;
                        }
                        if (!tempWord.equals(word)) {
                            break check2; 
                        }
                    }
                     
                    check3: if ((x + 1) >= tamanhoPalavra) { /* UP */
                        StringBuilder sb = new StringBuilder();
                        for (int i = x; i > (x - tamanhoPalavra); i--) {
                            sb.append(sopa[i][y]);

                        }
                        String tempWord = sb.toString();
                        if (tempWord.equals(word)) {
                            posicoes[0] = String.valueOf(x);
                            posicoes[1] = String.valueOf(y);
                            posicoes[2] = "Up";
                            return posicoes;
                        } 
                        if (!tempWord.equals(word)) {
                            break check3; 
                        }                          

                    } 
                    check4: if ((x + 1) >= tamanhoPalavra && tamanhoPalavra <= (y + 1)) { /* UPLEFT */
                        StringBuilder sb = new StringBuilder();
                        int p = x;
                        for (int i = y; i > (y - tamanhoPalavra); i--) {
                            sb.append(sopa[p][i]);
                            p -= 1;
                        }
                        String tempWord = sb.toString();
                        if (tempWord.equals(word)) {
                            posicoes[0] = String.valueOf(x);
                            posicoes[1] = String.valueOf(y);
                            posicoes[2] = "UpLeft";
                            return posicoes;
                        } 
                        if (!tempWord.equals(word)) {
                            break check4; 
                        }
                    } 
                    check5: if (tamanhoPalavra <= (y + 1)) { /* LEFT */
                        StringBuilder sb = new StringBuilder();
                        for (int i = y; i > (y - tamanhoPalavra); i--) {
                            sb.append(sopa[x][i]);
                        }
                        String tempWord = sb.toString();
                        if (tempWord.equals(word)) {
                            posicoes[0] = String.valueOf(x);
                            posicoes[1] = String.valueOf(y);
                            posicoes[2] = "Left";
                            return posicoes;
                        } 
                        if (!tempWord.equals(word)) {
                            break check5; 
                        }
                    } 
                    check6: if ((tamanhoLinhas - x) >= tamanhoPalavra && tamanhoPalavra <= (y + 1)) { /* DOWNLEFT */
                        StringBuilder sb = new StringBuilder();
                        int p = x;
                        for (int i = y; i > (y - tamanhoPalavra); i--) {
                            sb.append(sopa[p][i]);
                            p += 1;
                        }
                        String tempWord = sb.toString();
                        if (tempWord.equals(word)) {
                            posicoes[0] = String.valueOf(x);
                            posicoes[1] = String.valueOf(y);
                            posicoes[2] = "DownLeft";
                            return posicoes;
                        } 
                        if (!tempWord.equals(word)) {
                            break check6; 
                        }
                    } 
                    check7: if ((tamanhoLinhas - x) >= tamanhoPalavra) { /* Down */
                        StringBuilder sb = new StringBuilder();
                        for (int i = x; i < (x + tamanhoPalavra); i++) {
                            sb.append(sopa[i][y]);

                        }
                        String tempWord = sb.toString();
                        if (tempWord.equals(word)) {
                            posicoes[0] = String.valueOf(x);
                            posicoes[1] = String.valueOf(y);
                            posicoes[2] = "Down";
                            return posicoes;
                        } if (!tempWord.equals(word)) {
                            break check7; 
                        }
                    } 
                    if ((tamanhoLinhas - x) >= tamanhoPalavra
                            && tamanhoPalavra <= (tamanhoLinhas - (y + 1))) { /* DOWNRIGHT */
                        StringBuilder sb = new StringBuilder();
                        int p = x;
                        for (int i = y; i < (y + tamanhoPalavra); i++) {
                            sb.append(sopa[p][i]);
                            p += 1;
                        }
                        String tempWord = sb.toString();
                        if (tempWord.equals(word)) {
                            posicoes[0] = String.valueOf(x);
                            posicoes[1] = String.valueOf(y);
                            posicoes[2] = "DownRight";
                            return posicoes;
                        } else {
                            break;
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        System.out.printf("ERROR: Word %s not found or doesn't exist on the puzzle!\n", word);
        System.exit(1);
        return null;
    }

}