import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorMain {
    private final Scanner input;
    private final List<String> startMenu = Arrays.asList(
            "1.Двоичная","2.Восьмиричная","3.Десятичная","4.Шеснадчатиричная","5.Выход"
    );
    public CalculatorMain(){
        input = new Scanner(System.in);
    }

    public void performCalculation(Class<? extends Num> numClass,int num){
        boolean FirstCalc = false;
        boolean endwork = true;
        Num res = null,a,b;
        System.out.print("Введите первое значение в формате:  " + startMenu.get(num-1) + "\n");
        input.nextLine();
        try {
            String Fa = input.nextLine();
            if(Fa.matches("^(?!0).*$")) {
                a = numClass.getConstructor(String.class).newInstance(Fa);
            }
            else {
                System.out.println("Число не должно начинаться с 0");
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println();
        while (endwork) {
            if(FirstCalc){
                a = res;
            }
            FirstCalc = true;
            System.out.print("Введите операцию (+,-,/,*):  ");
            String oper = input.nextLine();
            System.out.println();
            System.out.print("Введите второе значение в формате: " + startMenu.get(num-1) + "\n" );
            try {
                String Sa = input.nextLine();
                if(Sa.matches("^(?!0).*$")) {
                    b = numClass.getConstructor(String.class).newInstance(Sa); // получает конструктор класса Num, который принимает аргумент типа String.
                }
                // создает новый объект класса Num, вызывая полученный конструктор с аргументом, который является результатом вызова метода nextLine() объекта input.
                else{
                    System.out.println("Ошибка ввода");
                    return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            System.out.println();
            try {
                res = numClass.getConstructor(int.class).newInstance(doOperation(a,b,oper));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            System.out.println(res.toStringAllSys());
            endwork = continueCalc();
        }
    }
    public void start(){
        while(true){
            try {
            startMenu.forEach(System.out::println);
                switch (input.next()) {
                    case ("4"):
                        performCalculation(HexNum.class,4);
                        break;
                    case ("3"):
                        performCalculation(DecNum.class,3);
                        break;
                    case ("2"):
                        performCalculation(OctNum.class,2);
                        break;
                    case ("1"):
                        performCalculation(BinNum.class,1);
                        break;
                    case ("5"):
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Выберите одну из предложенных систем.");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int doOperation(Num a, Num b, String op){

        return switch (op) {
            case "+" -> a.getNumber() + b.getNumber();
            case "-" -> a.getNumber() - b.getNumber();
            case "*" -> a.getNumber() * b.getNumber();
            case "/" -> a.getNumber() / b.getNumber();
            default -> throw new RuntimeException("Указан невалидный оператор");
        };
    }

    static boolean continueCalc(){
        Scanner input = new Scanner(System.in);
        System.out.println("Продолжить?    Да / Нет");
        String x = input.nextLine();
        if (x.equals("Да")|| x.equals("да")){
            return true;
        }
        else if(x.equals("Нет")|| x.equals("нет")) return false;
        return continueCalc();
    }
}
