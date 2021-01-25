public enum WinType {
    ROYALFLUSH(0),
    STRAIGHTFLUSH(1),
    FOUROFKIND(2),
    FULLHOUSE(3),
    FLUSH(4),
    STRAIGHT(5),
    THREEOFKIND(6),
    TWOPAIR(7),
    ONEPAIR(8),
    HIGHCARD(9);



    public int value = -1;

    WinType( int value ){
        this.value = value;
    }
}
