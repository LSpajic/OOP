public class Market <A , B extends Number>{
    private final A ids;
    private final B value;
    int[] amounts;
    public Market(A ids,B value ,int[] amounts) {
        this.amounts = amounts;
        this.ids = ids;
        this.value = value;
    }

    public Boolean doesIdExist<C c>{
        for (int i = 0; i < amounts.length; i++) {
            if (A[i].toString() == c.toString()){
                return True;
            }
            return False;
        }

    }
}
