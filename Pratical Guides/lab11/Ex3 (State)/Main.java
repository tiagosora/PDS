package Ex3;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        Book books[] = {
            new Book("Java Anti-Stress", "Omodionah", 1, 1),
            new Book("A Guerra dos Padrões", "Jorge Omel", 2, 2),
            new Book("A Procura da Luz", "Khumatkli", 3, 3)
        };
        while (!input.toLowerCase().equals("exit")){
            System.out.println("*** Biblioteca ***");
            for (int i = 0; i < books.length; i++){
                System.out.printf("%d   %-20s    %-10s  [%s]\n", i, books[i].getTitle(), books[i].getAuthor(), books[i].getState().toString());
            }
            System.out.println(">> <book,operation> : (1)register; (2)request; (3)refund; (4)reserve; (5)cancelReservation; (exit)");
            input = sc.nextLine();
            String inputSplited[] = input.split(",");
            if (inputSplited.length != 2){
                continue;
            }
            switch (inputSplited[1].toLowerCase()) {
                case "1":
                    books[Integer.parseInt(inputSplited[0])].register();
                    break;
                case "2":
                    books[Integer.parseInt(inputSplited[0])].request();
                    break;
                case "3":
                    books[Integer.parseInt(inputSplited[0])].refund();
                    break;
                case "4":
                    books[Integer.parseInt(inputSplited[0])].reserve();
                    break;
                case "5":
                    books[Integer.parseInt(inputSplited[0])].cancelReservation();
                    break;
                case "exit":
                    sc.close();
                    System.exit(1);
            }
        }
        sc.close();
    }
}