import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Encoder code = new Encoder();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter A: To Decode or Enter B: To Encode or type 'exit' to quit");
            String input = scanner.nextLine().trim().toLowerCase();
            
            if (input.equals("exit")) {
                break;
            }
            if (input.equals("a")) {
                System.out.print("Decode Text: ");
                String decodeText = scanner.nextLine();
                System.out.println(code.decode(decodeText));

            } else if (input.equals("b")){
                System.out.print("Encode Text: ");
                String encodeText = scanner.nextLine();
                System.out.println(code.encode(encodeText));

            } else {
                System.out.println("Invalid Option.");
            }
        }
        scanner.close();
    }
}
