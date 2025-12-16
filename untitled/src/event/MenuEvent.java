package event;

import user.User;

import java.util.ArrayList;
import java.util.InputMismatchException;

import monster.*;

public class MenuEvent {
    public static void checkStats(ArrayList userInfo, User user){
        while (true) {
            System.out.printf("""
            ===============
            이름: %s 
            레벨: %s 
            경험치: %s / %s 
            체력: %s 
            공격력: %s 
            방어력: %s 
            분배 포인트: %s
            ===============
            1. 스텟 분배
            2. 나가기
            ===============
            숫자 입력: """,
                    userInfo.get(0),
                    userInfo.get(1),
                    userInfo.get(2),
                    userInfo.get(3),
                    userInfo.get(4),
                    userInfo.get(5),
                    userInfo.get(6),
                    userInfo.get(7));
            try {
                int choice = Function.scan.nextInt();
                if(choice == 1){
                    UserEvents.usePoint(user);
                    break;
                } else if (choice == 2) {
                    break;
                }else{
                    System.out.println("1 or 2번를 선택해주세요.");
                }
            }catch(InputMismatchException e){
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
    public static void choiceMonster(User user){
        while (true){
            System.out.print("""
            ===============
            1. 고블린 
            2. 힘 고블린 
            3. 힘힘 고블린 
            4. 나가기
            ===============
            상대의 숫자를 입력해주세요.
            입력: """);
            try{
                int choice = Function.scan.nextInt();

                if(choice == 1){
                    Monster moster = new MonsterEasy();
                    Fight.fights(user, moster);
                } else if (choice == 2) {
                    Monster moster = new MonsterMiddle();
                    Fight.fights(user, moster);
                } else if (choice == 3) {
                    Monster moster = new MonsterHard();
                    Fight.fights(user, moster);
                } else if (choice == 4){
                    break;
                } else{
                    System.out.println("1 ~ 4번을 선택해주세요.");
                }

            }catch(InputMismatchException e){
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

}
