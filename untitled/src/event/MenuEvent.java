package event;

import user.User;

import java.util.ArrayList;
import java.util.HashMap;
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
            MenuEventSub.monsterChoiceUi();
            System.out.print("입력: ");
            try{
                long choice = Function.scan.nextLong();

                if(choice == 1){
                    Monster monster = new MonsterEasy();
                    Fight.fights(user, monster);
                } else if (choice == 2) {
                    Monster monster = new MonsterMiddle();
                    Fight.fights(user, monster);
                } else if (choice == 3) {
                    Monster monster = new MonsterHard();
                    Fight.fights(user, monster);
                } else if (choice == 66111115115L) {
                    Monster boss = new Boss();
                    Fight.fights(user, boss);
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

    public static void checkEquipment(User user){
        while (true){
            MenuEventSub.userEquipped(user);
            try{
                int choice = Function.scan.nextInt();
                Function.scan.nextLine();
                if(choice == 1){
                    MenuEventSub.itemListView(user.getInventoryItem());
                }else if(choice == 2){
                    MenuEventSub.userEQManagement(user);
                }else if(choice == 3){
                    break;
                }else{
                    System.out.println("1 ~ 3의 숫자를 선택해주세요.");
                }
            }catch(InputMismatchException e){
                System.out.println("숫자를 입력해주세요.");
            }
        }

    }

}
