public class Main {
    public static void main(String[] args) {
        Market<String, Integer> market1 = new Market<>(new String[] {"A", "B"}, new Integer[]{1, 2}, new Integer[]{2, 2});

        System.out.println(market1.doesIdExists("F"));
        System.out.println(market1.totalMarketValue()); // 1*2 + 2*2 = 6.0
        try {
            market1.addProduct("B", 5, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        market1.addProduct("F", 5, 1);
        System.out.println(market1.totalMarketValue());
    }
}