public class Main {
    public static void main(String... args) {
        productMajority(1E-2, 1.5E-1);
        System.out.println(1.5E-1);
    }

    public static double reactantMajority(double k, double r0, double r1) {
        // (4 * x2) / (r0 - x) (r1 - x) = k
        return quadraticFormula(4 - k, (r0 + r1) * k, -(r0 * r1 * k));
    }

    public static void reactantMajority(double k, double p0) {
        // (p0 - 2x)2 / x2 = k
        // (p0 - 2x) / x = sqrt(k)
        // p0 - 2x = x * sqrt(k)
        // p0 = 2x + x * sqrt(k)
        // p0 = x * (2 + sqrt(k))
        // x = p0 / (2 + sqrt(k))
        double x = p0 / (2 + Math.sqrt(k));
        System.out.println("r0: " + x);
        System.out.println("r1: " + x);
        System.out.println("p0: " + (p0 - 2 * x));
    }

    public static void productMajority(double k, double r0) {
        // x2 / (r0 - 2x)2 = k
        // x / (r0 - 2x) = sqrt(k)
        // x = r0 * sqrt(k) - 2x * sqrt(k)
        // x + 2x * sqrt(k) = r0 * sqrt(k)
        // x * (1 + 2sqrt(k)) = r0 * sqrt(k)
        // x = (r0 * sqrt(k)) / (1 + 2sqrt(k))
        double x = (r0 * Math.sqrt(k)) / (1 + 2 * Math.sqrt(k));
        
        System.out.println("r0: " + (r0 - 2 * x));
        System.out.println("p0: " + x);
        System.out.println("p1: " + x);
    }

    public static double productMajority(double k, double p0, double p1) {
        // (p0 - x) * (p1 - x) / (4 * x2) = k
        // c = p0 * p1
        // b = -(p0 + p1)
        // a = 1 - 4k
        return quadraticFormula(p0 * p1, -(p0 + p1), 1 - 4 * k);
    }

    public static double quadraticFormula(double a, double b, double c) {
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
        return (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    }
}
