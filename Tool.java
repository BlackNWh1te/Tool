package Tool;

import java.util.Scanner;

public class Tool {


    public String[] parseString(String expectedString) {

        String[] words = expectedString.split(",");

        for (int i = 0; i < words.length; i++)
            words[i] = words[i].trim();


        return words;

    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");

        String newString = scanner.nextLine();

        Calculator.evaluate(newString);
        /*List<Node> list =Calculator.stringParser(newString);

        for (Node eachNode: list)
              {

            System.out.print(eachNode.getValue());

        }

        System.out.println("\nList size  "+ list.size());*/














    }
}
