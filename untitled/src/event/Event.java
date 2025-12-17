package event;

import user.User;

import java.util.InputMismatchException;

public class Event {
    public static void menuScreen(User user){
        menu:
        while (true) {
            System.out.printf("""
                    ================
                    이름: %s  레벨: %d 경험치: %d / %d
                    1. 전투
                    2. 장비
                    3. 스텟
                    4. 종료
                    ================ \n""",user.getName(), user.getlevel(), user.getExp(), user.getExpPlus());
            try {
                System.out.println("숫자를 선택해주세요! ");
                System.out.print("입력: ");
                int choice = Function.scan.nextInt();
                if(choice == 1){
                    MenuEvent.choiceMonster(user);
                }
                else if (choice == 2) {
                    MenuEvent.checkEquipment(user.getInventoryItem(), user);
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
