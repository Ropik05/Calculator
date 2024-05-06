import java.util.Arrays;
import java.util.List;

public class Calculation {
    private Num a;
    private Num b;
    private String operation;

    private Num solution;

    private final List<String> operations = Arrays.asList("+","-","*","/");

    public Calculation(){
        this.a = new DecNum("0");
        this.b = new DecNum("0");
        this.operation = "+";
        solution();
    }

    public Num getA() {
        return a;
    }

    public void setA(Num a) {
        this.a = a;
    }

    public Num getB() {
        return b;
    }

    public void setB(Num b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation){
        if(operations.contains(operation))
            this.operation = operation;
        else
            throw new IllegalArgumentException("Не могу выполнить такую операцию");
    }

    public Num solution(){
        switch (operation) {
            case ("+"):
                solution = createNum(a.getNumber() + b.getNumber(), a.getNumSystem());
                return solution;
            case ("-"):
                solution = createNum(a.getNumber() - b.getNumber(), a.getNumSystem());
                return  solution;
            case ("*"):
                solution = createNum(a.getNumber() * b.getNumber(), a.getNumSystem());
                return  solution;
            case ("/"):
                if(b.getNumber() != 0) {
                    solution = createNum(a.getNumber() / b.getNumber(), a.getNumSystem());
                    return solution;
                }
                else
                    throw new IllegalArgumentException("На 0 делить нельзя");
            default:
                System.out.println("Как оно сюда попало???");
                break;
        }
        throw new IllegalArgumentException("Нельзя выполнить!");
    }


    private Num createNum(int value, int system){
        String temp;
        return switch (system) {
            case (2) -> {
                if (value >= 0)
                    temp = Integer.toBinaryString(value);
                else {
                    temp = Integer.toBinaryString(value * -1);
                    temp = '-' + temp;
                }
                yield new BinNum(temp);
            }
            case (8) -> {
                if (value >= 0)
                    temp = Integer.toOctalString(value);
                else {
                    temp = Integer.toOctalString(value * -1);
                    temp = '-' + temp;
                }
                yield new OctNum(temp);
            }
            case (10) -> new DecNum(Integer.toString(value));
            case (16) -> {
                if (value >= 0)
                    temp = Integer.toHexString(value);
                else {
                    temp = Integer.toHexString(value * -1);
                    temp = '-' + temp;
                }
                yield new HexNum(temp);
            }
            default -> throw new IllegalArgumentException("Данная система счисления не поддерживается!");
        };
    }
    @Override
    public String toString() {
        return getA().toString() + " " + getOperation() + " " + getB().toString() + " = " + solution;
    }
}
