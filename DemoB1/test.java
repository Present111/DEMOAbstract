package DemoB1;
// Product
class Meal {
    private String burger;
    private String drink;
    private String fries;
    private String dessert;
    private String salad;

    private Meal() {} // hạn chế khởi tạo trực tiếp

    @Override
    public String toString() {
        return "Meal{" +
                "burger='" + burger + '\'' +
                ", drink='" + drink + '\'' +
                ", fries='" + fries + '\'' +
                ", dessert='" + dessert + '\'' +
                ", salad='" + salad + '\'' +
                '}';
    }

    // Builder (fluent)
    public static class Builder {
        private final Meal meal = new Meal();

        public Builder burger(String val)  { meal.burger = val; return this; }
        public Builder drink(String val)   { meal.drink = val; return this; }
        public Builder fries(String val)   { meal.fries = val; return this; }
        public Builder dessert(String val) { meal.dessert = val; return this; }
        public Builder salad(String val)   { meal.salad = val; return this; }

        // Có thể chèn validate/normalize tại đây trước khi build()
        public Meal build() { return meal; }
    }
}

// (Tùy chọn) Director: đóng gói các "combo" dựng sẵn
class MealDirector {
    public Meal makeKidsCombo() {
        return new Meal.Builder()
                .burger("Kids Burger")
                .drink("Milk")
                .fries("Small Fries")
                .dessert("Chocolate Pudding")
                .build();
    }

    public Meal makeFitnessCombo() {
        return new Meal.Builder()
                .burger("Grilled Chicken")
                .drink("Water")
                .salad("Green Salad")
                .build();
    }
}

public class BuilderMealDemo {
    public static void main(String[] args) {
        // Tự build linh hoạt:
        Meal custom = new Meal.Builder()
                .burger("Beef")
                .drink("Coke")
                .fries("Large Fries")
                .build();

        // Dùng Director cho preset:
        MealDirector director = new MealDirector();
        Meal kids = director.makeKidsCombo();
        Meal fitness = director.makeFitnessCombo();

        System.out.println(custom);
        System.out.println(kids);
        System.out.println(fitness);
    }
}
