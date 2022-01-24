public class GasEquilibrium {

    // TODO: Fix productMajority(k, p0, p1)
    public static void main(String... args) {
        // reactantMajority(0, 0, 0);
        // reactantMajority(0, 0);
        // productMajority(0, 0);
        // productMajority(1E-1, 3E-2, 3E-2);
        // quadraticFormula(0, 0, 0);
    }

    public static void reactantMajority(double k, double r0, double r1) {
        // (2x)2 / (r0 - x) (r1 - x) = k
        // (4 * x2) / (r0 * r1 - r0 * x - r1 * x + x2) = k
        // 4 * x2 = k * r0 * r1 - k * x * (r0 + r1) + k * x2
        // 4 * x2 - k * x2 + k * x * (r0 + r1) - k * r0 * r1
        // x2 * (4 - k) + x * ((r0 + r1) * k) - (r0 * r1 * k)
        // a = 4 - k
        // b = (r0 - r1) * k
        // c = -r0 * r1 * k
        double x = quadraticFormula(4 - k, (r0 + r1) * k, -r0 * r1 * k);
        System.out.println("r0: " + (r0 - x));
        System.out.println("r1: " + (r1 - x));
        System.out.println("p0: " + (2 * x));
    }

    // TODO: Check for correctness

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

    public static void productMajority(double k, double p0, double p1) {
        // (p0 - x) * (p1 - x) / (2x)2 = k
        // p0 * p1 - x * (p0 + p1) + x2 = 4 * k * x2
        // x2 - x2 * 4 * k - x * (p0 + p1) + p0 * p1 = 0
        // x2 * (1 - 4k) - x * (p0 + p1) + p0 * p1 = 0
        // a = 1 - 4k
        // b = -(p0 + p1)
        // c = p0 * p1
        double x = quadraticFormula(1 - 4 * k, -(p0 + p1), p0 * p1);
        System.out.println("r0: " + (2 * x));
        System.out.println("p0: " + (p0 - x));
        System.out.println("p1: " + (p1 - x));

        /*
         * System.out.println(x);
         * System.out.println(p0 + p1);
         * System.out.println((2 * x) + (p0 - x) + (p1 - x));
         */

    }

    public static double quadraticFormula(double a, double b, double c) {

        // System.out.println("A: " + a);
        // System.out.println("B: " + b);
        // System.out.println("C: " + c);

        double sqrt = Math.sqrt(b * b - 4 * a * c);
        return Math.max((-b + sqrt) / (2 * a), (-b - sqrt) / (2 * a));
    }
}
