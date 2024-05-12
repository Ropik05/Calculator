public class DecNum extends Num{
    public DecNum(String value){
        super(value,10,"^-?\\d+$");
    }
    public DecNum(int value){
        super(value,10,"^-?\\d+$");
    }
}
