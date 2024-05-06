import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorMain {
    private final Calculation calc;
    private final Scanner scanner;
    private boolean EndWork = true;
    private final List<String> startMenu = Arrays.asList(
            "1.Двоичная","2.Восьмиричная","3.Десятичная","4.Шеснадчатиричная","5.Выход"
    );
    private static final String FNum = "Введите первое число: ";
    private static final String SeccNum = "Введите второе число: ";
    private static final String Oper = "Введите операцию (+,-,/,*): ";

    public CalculatorMain(){
        scanner = new Scanner(System.in);
        calc = new Calculation();
    }

    public void performCalculation(Class<? extends Num> numClass){
        System.out.print(FNum);
        scanner.nextLine();
        try {
            Num a = numClass.getConstructor(String.class).newInstance(scanner.nextLine());
            calc.setA(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println();
        System.out.print(Oper);
        calc.setOperation(scanner.nextLine());
        System.out.println();
        System.out.print(SeccNum);
        try {
            Num b = numClass.getConstructor(String.class).newInstance(scanner.nextLine());
            calc.setB(b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println();
        Num res = calc.solution();
        System.out.println(calc);
        System.out.println(res.toStringAllSys());
    }
    public void start(){
        boolean flag = true;
        while(flag){
            try {
            startMenu.forEach(System.out::println);
                switch (scanner.next()) {
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
}
