package Tool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Calculator {


    //private static String stack;




    private static LinkedList<Number> packer(List<Node> expectedList) {

        if (expectedList == null) {
            System.out.println("\nUnsupported operator or incorrect expression");
            return null;
        }
        LinkedList<Operator> operatorList = new LinkedList<>();
        LinkedList<Number> numberList = new LinkedList<>();

        for (int i = 0, k = expectedList.size() - 1; i < k; i++) {

            Node currentNode = expectedList.get(i);


            if (currentNode.getPriority() > 3) {

                numberList.add((Number) currentNode);
                if (i == k-1) {
                    int listSize = numberList.size();
                    Number result = operatorList.getLast().calculate(numberList.get(listSize - 2), numberList.getLast());
                    numberList.removeLast();
                    numberList.removeLast();
                    numberList.add(result);
                    System.out.println(numberList.getLast().getValue());

                }
            } else { //Попался оператор
                    //если список операторов пустой или приоритет последнего в списке ниже текущего, добавляем оператор в конец списка
                if (operatorList.isEmpty() || ((operatorList.getLast().getPriority()) > currentNode.getPriority())){

                    operatorList.add((Operator) currentNode);
                    System.out.println(operatorList.getLast().getValue());}

                else { //приоритет текущего оператора выше последнего в списке
                    //получаю размер списка чисел
                    int listSize = numberList.size();

                    while (!operatorList.isEmpty()) {

                        Number result = operatorList.getLast().calculate(numberList.get(listSize - 2), numberList.getLast());
                        numberList.removeLast();
                        numberList.removeLast();
                        numberList.add(result);
                        listSize--;

                        operatorList.removeLast();


                    }

                    operatorList.add((Operator) currentNode);


                }


            }

        }

        return numberList;


    }

    public static void evaluate(String expectedString) {



        List<Node>  result;

        String stringToParse = new String();
        for (String eachString : expectedString.split(" ")) {
            stringToParse += eachString;}

            System.out.println(stringToParse);
           result = stringParser(stringToParse);

        for (Node each: result
             ) {
            System.out.print(each.getValue()+" ");

        }
        System.out.println("\nNumber of objects in list "+ result.size());

           LinkedList<Number> finalResult;


           finalResult = packer(result);

        if(!finalResult.isEmpty()){
            for(Number num : finalResult){
                System.out.println(num.getValue());
            }
        }

           /*for (Number each : finalResult){

               System.out.print(each.getValue());


           }
        System.out.println("\n"+result.size());



           /*if (result != null) {
                for (Number eachNumber : result) {
                    System.out.println(eachNumber.getValue());
                }


            } else System.out.println("Result of packer foo is null");*/

    }


    public static List<Node> stringParser(String parsedString) {
        String stack = null;
        boolean isFractional= false;

        List<Node> tokenList = new ArrayList<>();

        for (int i = 0; i < parsedString.length(); i++) {

            char currentChar = parsedString.charAt(i);


            if (currentChar >='0' & currentChar <='9') {
                if (stack == null) stack = currentChar + "";
                else if (stack != null) stack += currentChar;
                if (i == ((parsedString.length() - 1))) {
                    tokenList.add(new Number(Double.valueOf(stack)));
                    break;


                }
                continue;


            } else if (currentChar == '-' || currentChar == '+' || currentChar == '*' || currentChar == '/') {

                if (stack == null || (stack.charAt(stack.length() - 1)) == '.' || (i == parsedString.length() - 1)) {

                    return null;
                } else {
                    //if (isFractional) tokenList.add(new Number(Double.valueOf(stack)));
                   // else
                        tokenList.add(new Number(Double.valueOf(stack)));

                    isFractional = false;
                    tokenList.add(Operator.build(currentChar));
                    stack = null;
                    continue;


                }


            } else if (currentChar == ',' || currentChar == '.') {
                if (stack == null || (isFractional) || (i == parsedString.length() - 1)) return null;

                else {
                    stack += ".";
                    isFractional = true;
                    continue;


                }

            } else {
                System.out.println(currentChar);
                return null;
            }


        }
        return tokenList;
    }


}
