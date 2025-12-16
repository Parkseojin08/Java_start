package event;

import user.User;

public class Start {
    public static void start() {
        User user = new User();
        while(true){
            boolean start = Message.startMessage();
            UserEvents.choiceUserStats(user, start);
            System.out.println(user.getAll());
            break;
        }
    }
}
