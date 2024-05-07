public abstract class Num {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public abstract int getNumSystem();


    protected int toDec(String numSt, String regex){
        if (!numSt.matches(regex) || numSt.matches("[ .,;:]" ) ) {
            throw new IllegalArgumentException("Не подходит под формат данной системы счисления");
        }
        return Integer.parseInt(numSt, getNumSystem());
    }


    public String toStringAllSys(){
        return "Двоичное: " + Integer.toBinaryString(number) + "\n"+ "Восьмиричное: " + Integer.toOctalString(number) + "\n"+ "Десятичное: " + number + "\n"+
                "Шеснадчатиричное: " + Integer.toHexString(number) + "\n";
    }
}
