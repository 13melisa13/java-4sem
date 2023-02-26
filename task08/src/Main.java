import momento.File;
import momento.OperatingSystem;
import observer.GameRelease;
import observer.StorePage;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        System.out.println("Memento example: ");
        File file = new File();
        OperatingSystem linux = new OperatingSystem(228, "George");
        file.setBackup(linux.makeBackup());
        linux.deleteAllFiles();
        System.out.println(linux);
        linux.recover(file.getBackup());
        System.out.println(linux);
        System.out.println();

        System.out.println("Observer example: ");
        GameRelease gameRelease = new GameRelease("Караваны");
        gameRelease.changeReleaseDate(new GregorianCalendar(2021, Calendar.FEBRUARY, 21).getTime());
        StorePage storePage = new StorePage();
        gameRelease.attach(storePage);
        gameRelease.changeReleaseDate(new GregorianCalendar(2021, Calendar.APRIL, 21).getTime());
        gameRelease.detach(storePage);
        gameRelease.changeReleaseDate(new GregorianCalendar(2077, Calendar.DECEMBER, 3).getTime());
    }
}