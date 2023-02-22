public class Main {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton1Copy = Singleton1.getInstance();

        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton2Copy = Singleton2.getInstance();
        Singleton2 singleton2AnotherCopy = Singleton2.INSTANCE;

        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton3 singleton3Copy = Singleton3.getInstance();

        MyClass obj = new MyClass();
        MyClass objCopy = new MyClass();

        System.out.println("Hash code Singleton1:");
        System.out.println(singleton1.hashCode() + " " + singleton1Copy.hashCode());

        System.out.println("Hash code Singleton2:");
        System.out.println(singleton2.hashCode() + " " +
                singleton2Copy.hashCode() + " " + singleton2AnotherCopy.hashCode());

        System.out.println("Hash code Singleton3:");
        System.out.println(singleton3.hashCode() + " " +
                singleton3Copy.hashCode());

        System.out.println("Hash code MyClass:");
        System.out.println(obj.hashCode() + " " +
                objCopy.hashCode());



    }
}