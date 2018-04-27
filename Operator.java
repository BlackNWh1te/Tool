package Tool;

public class Operator extends Node {

    public static Operator build(char expectedChar) {

        switch (expectedChar) {

            case '-':
                return new Operator(3, expectedChar);
            case '+':
                return new Operator(3, expectedChar);

            case '*':
                return new Operator(2, expectedChar);
            case '/':
                return new Operator(2, expectedChar);

            default:
                return null;
        }


    }


    private Operator(int priority, char value) {
        super(priority);
        this.value = "" + value;
    }

    private final String value;


    public Number calculate(Number num1, Number num2) {
        Double temp;
        switch (this.getValue()) {
            case "-": {
                 temp = num1.getValue() - num2.getValue();
                return new Number(temp);
            }

            case "+": {
                 temp = num1.getValue() + num2.getValue();

                return new Number(temp);



            }

            case "/": {
                if (num2.getValue() == 0.0) return null; //Деление на ноль. Ошибка
                temp = num1.getValue() / num2.getValue();
                return new Number(temp);
            }

            case "*": {
                temp = num1.getValue() * num2.getValue();
                return new Number(temp);
            }





        }
        return null;
    }

    @Override
    public String toString() {
        return "\nValue: " + this.getValue() + "\nPriority: " + this.getPriority();
    }

    @Override
    public String getValue() {
        return this.value;
    }


}
