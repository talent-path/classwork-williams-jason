public class App {
    public static void main(String[] args) {

        int[] arr = {82, 95, 71, 6, 34};

        System.out.println(Aggregate.min(arr));
        System.out.println(Aggregate.max(arr));
        System.out.println(Aggregate.sum(arr));
        System.out.println(Aggregate.average(arr));
        System.out.println(Aggregate.standarddeviation(arr));



    }
}
