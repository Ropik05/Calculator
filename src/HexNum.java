public class HexNum extends Num{
    public HexNum(String value){
        super(value,16,"[-]?[0-9A-Fa-f]+");
    }
    public HexNum(int value){
        super(value,16,"[-]?[0-9A-Fa-f]+");
    }
}
