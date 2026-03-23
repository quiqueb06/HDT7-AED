import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();

        // 1. Leer diccionario.txt e insertar en el árbol
        try {
            Scanner dictScanner = new Scanner(new File("diccionario.txt"));
            while (dictScanner.hasNextLine()) {
                String line = dictScanner.nextLine().trim();
                if (!line.isEmpty()) {

                    line = line.replace("(", "").replace(")", "");
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String eng = parts[0].trim().toLowerCase();
                        String spa = parts[1].trim().toLowerCase();
                        dictionary.insert(new Association<>(eng, spa));
                    }
                }
            }
            dictScanner.close();
        } catch (Exception e) {
            System.out.println("Error leyendo diccionario.txt");
        }

        // 2. Imprimir recorrido in-order
        System.out.println("Diccionario en In-Order:");
        dictionary.inOrder();

        // 3. Traducir texto.txt
        System.out.println("Traducción:");
        try {
            Scanner textScanner = new Scanner(new File("texto.txt"));
            while (textScanner.hasNext()) {
                String word = textScanner.next();

                String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                
                Association<String, String> searchDummy = new Association<>(cleanWord, null);
                Association<String, String> result = dictionary.search(searchDummy);
                
                if (result != null) {
                    System.out.print(result.getValue() + " ");
                } else {
                    System.out.print("*" + cleanWord + "* ");
                }
            }
            textScanner.close();
        } catch (Exception e) {
            System.out.println("Error leyendo texto.txt");
        }
    }
}