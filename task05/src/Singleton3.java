public class Singleton3 { // synchronized accessor
        private static final Singleton3 instance = new Singleton3();
        private Singleton3(){};
        public static Singleton3 getInstance() {
            return instance;
        }

}
