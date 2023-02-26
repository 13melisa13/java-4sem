public class Singleton1 { // synchronized accessor
        private static Singleton1 instance;
        private Singleton1 (){};
        public static synchronized Singleton1 getInstance() {
            if(instance == null) {
                instance = new Singleton1();
                return instance;
            }
            return instance;
        }

}