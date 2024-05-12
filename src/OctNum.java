public class OctNum extends Num{
    public OctNum(String value){
        super(value,8,"^[-]?[0-7]+$");
    }
    public OctNum(int value){
        super(value,8,"^[-]?[0-7]+$");
    }
}
