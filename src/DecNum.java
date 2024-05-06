public class DecNum extends Num{
    public DecNum(String value){
        setNumber(toDec(value,"^-?\\d+$"));
    }

    @Override
    public int getNumSystem() {
        return 10;
    }
}
