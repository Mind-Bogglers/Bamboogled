public class Calculator {
    private static Calculator instance = null;

    public static int add(int x, int y) {
        return x + y;

    }

    public static int multiply(int x, int y) {
        return x * y;

    }

    public static int subtract(int x, int y){
        return x - y;
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }


}
