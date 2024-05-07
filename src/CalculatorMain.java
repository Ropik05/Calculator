import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorMain {
    private final Calculation calc;
    private final Scanner input;
    private final List<String> startMenu = Arrays.asList(
            "1.Двоичная","2.Восьмиричная","3.Десятичная","4.Шеснадчатиричная","5.Выход"
    );
    private static final String FNum = "Введите первое число: ";
    private static final String SeccNum = "Введите второе число: ";
    private static final String Oper = "Введите операцию (+,-,/,*): ";

    public CalculatorMain(){
        input = new Scanner(System.in);
        calc = new Calculation();
    }

    public void performCalculation(Class<? extends Num> numClass){
        boolean FirstCalc = false;
        boolean endwork = true;
        System.out.print(FNum);
        input.nextLine();
        try {
            Num a = numClass.getConstructor(String.class).newInstance(input.nextLine());
            calc.setA(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println();
        while (endwork) {
            if(FirstCalc){
                calc.setA(calc.solution());
            }
            FirstCalc = true;
            System.out.print(Oper);
            calc.setOperation(input.nextLine());
            System.out.println();
            System.out.print(SeccNum);
            try {
                Num b = numClass.getConstructor(String.class).newInstance(input.nextLine()); // получает конструктор класса Num, который принимает аргумент типа String.
                // создает новый объект класса Num, вызывая полученный конструктор с аргументом, который является результатом вызова метода nextLine() объекта input.
                calc.setB(b);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            System.out.println();
            Num res = calc.solution();
            System.out.println(res.toStringAllSys());
            endwork = continueCalc();
        }
    }
    public void start(){
        boolean flag = true;
        while(flag){
            try {
            startMenu.forEach(System.out::println);
                switch (input.next()) {
                    case ("4"):
                        performCalculation(HexNum.class);
                        break;
                    case ("3"):
                        performCalculation(DecNum.class);
                        break;
                    case ("2"):
                        performCalculation(OctNum.class);
                        break;
                    case ("1"):
                        performCalculation(BinNum.class);
                        break;
                    case ("5"):
                        flag = false;
                        break;
                    default:
                        System.out.println("Не знаю такую операцию!");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
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
