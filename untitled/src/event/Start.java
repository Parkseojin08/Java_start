package event;

import user.User;

public class Start {
    public static void start() {
        User user = new User();
        while(true){
            boolean start = Message.startMessage();
            if(!start){
                System.out.println("게임을 종료합니다.");
                break;
            }
            while (true) {
                UserEvents.choiceUserStats(user);
                System.out.println(user.getAll());
                Event.menuScreen(user);
                break;
            }
        }
    }
}
