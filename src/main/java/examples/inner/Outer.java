package examples.inner;

class Outer {
    private static int staticValue = 5;
    private int value = 2;

    public void localMethod() {
        class LocalHuman {
            private String firstName;

            public LocalHuman(String firstName) {
                this.firstName = firstName;
            }

            public String getFirstName() {
                return firstName;
            }
        }

        LocalHuman marcin = new LocalHuman("Marcin");
        System.out.println(marcin);
    }

    class Inner {
        private int innerValue = 1;
        private int value = 3;

        public void innerMethod() {
            System.out.println("Outer value: " + Outer.this.value);
//            System.out.println("Outer value: " + value);
            System.out.println("Inner value: " + innerValue);
        }
    }

    static class InnerStatic {

        private int innerStaticValue = 4;

        public void innerMethod() {
            System.out.println("Inner static value: " + innerStaticValue);
            System.out.println("Outer value: " + staticValue);
        }
    }
}
