package examples.inner;

public class Main {
    public static void main(String[] args) {
//        Outer outer = new Outer();
//        Outer.Inner inner = outer.new Inner();
        Outer.Inner inner = new Outer().new Inner();
        inner.innerMethod();

        Company company = new Company();
        company.addEmployee("Marcin");
        company.addEmployee("Rafał");

        for (String employee : company) {
            System.out.println(employee);
        }

        System.out.println("---------------------------------------");

        Outer.InnerStatic innerStatic = new Outer.InnerStatic();
        innerStatic.innerMethod();

        System.out.println("---------------------------------------");

        Calculator calculator = new Calculator() {
            @Override
            public int add(int firstNumber, int secondNumber) {
                return firstNumber + secondNumber;
            }
        };

        int add = calculator.add(1, 2);
        System.out.println(add);
    }
}
