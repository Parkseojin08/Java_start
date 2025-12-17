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
            System.out.print("""
            ===============
            1. 고블린 
            2. 힘 고블린 
            3. 힘힘 고블린 
            4. 나가기
            > ?. 66111115115
            ===============
            상대의 숫자를 입력해주세요.
            입력: """);
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


    public static void checkEquipment(HashMap<String, Integer> items, User user){
        while (true){
            System.out.printf("""
                    =====================
                    장착한 창비
                    1. sword : %s 
                    2. helmet: %s
                    3. armor : %s
                    4. bottom: %s
                    =====================
                    1. 장비 리스트 확인
                    2. 장비 장착 및 해제
                    3. 나가기
                    
                    """,
                    !user.getSword()[0].isEmpty() ? user.getSword() : "없음",
                    !user.getHelmet()[0].isEmpty()  ? user.getHelmet() : "없음",
                    !user.getArmor()[0].isEmpty() ? user.getArmor() : "없음",
                    !user.getBottom()[0].isEmpty()  ? user.getBottom() : "없음");
            try{
                System.out.print("""
                        =====================
                        입력: """);
                int choice = Function.scan.nextInt();
                Function.scan.nextLine();
                if(choice == 1){
                    while (true) {
                        System.out.println("=====================");
                        items.forEach((key, value) -> {
                            String[] whatAb = key.split(" ");
                            System.out.printf("%s: ability: %s + %d \n",
                                    key,
                                    (whatAb[1].equals("검") ? "ATK" : whatAb[1].equals("갑옷") ? "HP": "DF")
                                    ,value);
                        });
                        System.out.println("=====================");
                        System.out.print("나가기(any): ");
                        String exte = Function.scan.nextLine();
                        if(!exte.trim().isEmpty()){
                            break;
                        }
                    }
                }else if(choice == 2){
                    while (true){
                        System.out.print("""
                                ====================
                                1. 장비 창작
                                2. 장비 해제
                                3. 나가기
                                ====================
                                입력: """);
                        try{
                            int choiceEQ = Function.scan.nextInt();
                            if(choiceEQ == 1){
                                while (true){
                                    System.out.printf("""
                                            =====================
                                            장착할 창비
                                            1. sword : %s
                                            2. helmet: %s
                                            3. armor : %s
                                            4. bottom: %s
                                            5. 나가기
                                            =====================
                                            장착할 장비 숫자
                                            입력: """);
                                    try{
                                        int choiceWahtEq = Function.scan.nextInt();
                                        if(choiceWahtEq == 1){
                                            while (true){
                                                final int[] i = {1};
                                                System.out.println("=====================");
                                                items.forEach((key, value) -> {
                                                    String[] whatAb = key.split(" ");
                                                    if(whatAb[1].equals("검")){
                                                        System.out.printf("%d. %s: ability: %s + %d \n",
                                                                i[0],
                                                                key,
                                                                (whatAb[1].equals("검") ? "ATK" : whatAb[1].equals("갑옷") ? "HP": "DF")
                                                                ,value);
                                                        i[0]++;
                                                    }
                                                });
                                                System.out.println("=====================");
                                                System.out.print("창작할 장비 숫자 입력: ");
                                                try {
                                                    int choiceList = Function.scan.nextInt();
                                                }catch (InputMismatchException e){
                                                    System.out.println("숫자를 입력해주세요");
                                                }
                                            }
                                        }
                                        else if(choiceWahtEq == 2){
                                            equipment(1)
                                        }
                                        else if(choiceWahtEq == 3){}
                                        else if(choiceWahtEq == 4){}
                                        else if (choiceWahtEq == 5) {
                                            break;
                                        }else {
                                            System.out.println("1 ~ 5의 숫자를 입력해줘");
                                        }
                                    }catch(InputMismatchException e){
                                        System.out.println("수잦를 입력해주세요.");
                                    }
                                }
                            } else if (choiceEQ == 2) {

                            } else if (choiceEQ == 3) {
                                break;
                            }else {
                                System.out.println("1 ~ 3의 숫자를 입력해주세요.");
                            }
                        }catch(InputMismatchException e){
                            System.out.println("숫자를 입력해주세요.");
                        }
                    }
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
