import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list1 = List.of("Gorgonzola", "Pecorino", "Windrush", "Cantal");
        List<String> list2 = List.of("Peppers", "Courgettes", "Aubergine");
        List<String> list3 = List.of("Mushroom", "Tofu");
        List<String> list4 = List.of("Olives", "Anchovies", "Pineapple", "Jalapeno", "Bacon");

        List<List<String>> listList = List.of(list1, list2, list3, list4);

        CartesianProduct<String> pizzaVarieties = new CartesianProduct<>(listList);

        while (pizzaVarieties.hasNextList()) {
            System.out.println("Next Set of Pizza Toppings: ");
            pizzaVarieties.getNextList().forEach(System.out::println);
            System.out.println("------");
            System.out.println();
        }
    }
}