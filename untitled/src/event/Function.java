package event;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Random;

public class Function {
    static Scanner scan = new Scanner(System.in);
    static Random ran = new Random();

    // 랜덤
    public static int ranInt(int max, int min){
        LocalTime now = LocalTime.now();
        ran.setSeed(max+min+now.getNano());
        return ran.nextInt(max-min) + min;
    }
}
