package com.bulider;

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    /**
     * 静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。
     * 静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，
     * 并且它不能使用外部类的非static成员变量或者方法，这点很好理解，
     * 因为在没有外部类的对象的情况下，可以创建静态内部类的对象，
     * 如果允许访问外部类的非static成员就会产生矛盾，
     * 因为外部类的非static成员必须依附于具体的对象。
     */
    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    public NutritionFacts(Builder builder) {
        System.out.println(this.getClass());
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts
                .Builder(1, 2)
                .calories(1)
                .carbohydrate(2)
                .fat(3)
                .build();
    }
}
