package event;

import user.User;
import event.*;
import java.util.InputMismatchException;

public class Event {
    public static void menuScreen(User user){
        menu:
        while (true) {
            event.MenuEventSub.menuUi(user);
            try {
                System.out.println("숫자를 선택해주세요! ");
                System.out.print("입력: ");
                int choice = Function.scan.nextInt();
                if(choice == 1){
                    MenuEvent.choiceMonster(user);
                }
                else if (choice == 2) {
                    MenuEvent.checkEquipment( user);
                }
                else if (choice == 3) {
                    MenuEvent.checkStats(user.getAll(), user);
                }
                else if (choice == 4) {
                    System.out.println("================");
                    System.out.println("게임을 종료합니다.");
                    System.out.println("================");
                    break menu;
                }
                else {
                    System.out.println("1 ~ 4번을 선택해주세요!");
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해 주세요");
                Function.scan.nextLine();
            }
            System.out.println("================");
        }

    }
}
