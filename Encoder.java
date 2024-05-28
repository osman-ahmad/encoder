import java.util.HashMap;
import java.util.Scanner;

public class Encoder {
    
    private static final char[] chars = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'
    };

    private HashMap<Integer, Character> charMap = new HashMap<>();

    public Encoder() {
        for (int i = 0; i < chars.length; i++) {
            charMap.put(i, chars[i]);
        }
    }

    public String decode(String encodedText){
        int ref = 0; 
        String decodedText = "";
        Boolean offSetFound = false;
        char offSetChar = Character.toUpperCase(encodedText.charAt(0));
        StringBuilder sb = new StringBuilder();
        for (int offSetKey : charMap.keySet()) {
            if (charMap.get(offSetKey) == offSetChar) {
                ref = offSetKey;
                offSetFound = true;
                
                // System.out.println(ref);
                for (int i = 1; i < encodedText.length(); i++){
                    Boolean charFound = false;
                    char currentChar = Character.toUpperCase(encodedText.charAt(i));
                    for (int key : charMap.keySet()) {
                        if (charMap.get(key) == currentChar) {
                            int newKey = (key + ref) % 44;
                            if (newKey < 0) {
                                newKey += 44;
                            }
                            sb.append(charMap.get(newKey));
                            charFound = true;
                            break;
                        }
                    }
                    if (!charFound){
                        sb.append(currentChar);
                    }
        
                }
            }
            
            }
            if (!offSetFound){
                return encodedText;
        }
        
        decodedText = sb.toString();
        
        // System.out.println(decodedText);
        return decodedText;
    }

    public String encode(String plainText){
        int ref = 0;
        String encodedText = "";
        boolean offSetFound = false;
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the offset character: (A-Z , 0-9 , ()*+,-./)");
        char offSetChar = Character.toUpperCase(scanner.nextLine().charAt(0));
        sb.append(offSetChar);
        for (int offSetKey : charMap.keySet()) {
            if (charMap.get(offSetKey) == offSetChar) {
                ref = offSetKey;
                offSetFound = true;
                                
                for (int i = 0; i < plainText.length(); i++){
                    Boolean keyFound = false;
                    char currentChar = Character.toUpperCase(plainText.charAt(i));
                    for (int key : charMap.keySet()) {
                        if (charMap.get(key) == currentChar) {
                            int newKey = (key - ref) % 44;
                            if (newKey < 0) {
                                newKey += 44;
                            }
                            keyFound = true;
                            sb.append(charMap.get(newKey));
                            break;
                        }
                        
                    }
                    if (!keyFound){
                        sb.append(currentChar);
                        
                    }
                    
        
                }
                encodedText = sb.toString();
                // System.out.println(encodedText);
                // System.out.println(ref);
                
            } 
            }
            if(!offSetFound){
                return "Invalid Offset Character";
        }
        
        return encodedText;
    }
}
