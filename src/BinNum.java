public class BinNum extends Num{
    public BinNum(String value){
        super(value,2,"^[-]?[0-1]+$");
    }
    public BinNum(int value){
        super(value,2,"^[-]?[0-1]+$");
    }
}
