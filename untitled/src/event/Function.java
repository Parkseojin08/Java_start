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
        ran.setSeed(max^min+max^now.getNano());
        int result = (ran.nextInt(max-min)*+1)+min;
        return result;
    }
}
