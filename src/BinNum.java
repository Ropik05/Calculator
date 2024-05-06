public class BinNum extends Num{
    public BinNum(String value){
        setNumber(toDec(value,"^[-]?[0-1]+$"));
    }

    @Override
    public int getNumSystem() {
        return 2;
    }
}
