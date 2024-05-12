public abstract class Num {
    private int number;
    protected Num (int val, int sys,String regix){
        reg = regix;
        system = sys;
        number = val;
    }
    protected Num(String val,int sys,String regix){
        reg = regix;
        system = sys;
        number = toInt(val,regix);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    protected int system;
    protected String reg;

    public int getNumSystem()
    {
        return system;
    }


    protected int toInt(String numSt, String regex){
        if (!numSt.matches(regex) || numSt.matches("[ .,;:]" ) ) {
            throw new IllegalArgumentException("Не подходит под формат данной системы счисления" + system);
        }
        return Integer.parseInt(numSt, getNumSystem());
    }


    public String toStringAllSys(){
        return "Двоичное: " + Integer.toBinaryString(number) + "\n"+ "Восьмиричное: " + Integer.toOctalString(number) + "\n"+ "Десятичное: " + number + "\n"+
                "Шеснадчатиричное: " + Integer.toHexString(number) + "\n";
    }
}
