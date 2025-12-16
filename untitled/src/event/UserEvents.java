package event;
import user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class UserEvents {

    public static void choiceUserStats(User user){
        System.out.println("===============");
        System.out.println("게임을 시작합니다.");
        System.out.println("===============");

        statsOur:while (true) {
            System.out.println("이름일 입력해주세요!");
            System.out.print("입력: ");
            String userName = Function.scan.nextLine();
            while (true) {
                ArrayList<Integer> lists = new ArrayList<>(Arrays.asList(30,10,5,3));
                final int hp = Function.ranInt(lists.get(0), lists.get(1));
                final int atk = Function.ranInt(lists.get(1), lists.get(2));
                final int df = Function.ranInt(lists.get(2), lists.get(3));
                System.out.printf("=============== %n 이름: %s %n 체력: %d / 최대 체력: %d %n 공격력: %d / 최대 공격력: %d %n 방어력: %d / 최대 방어력: %d %n", userName, hp, lists.get(0),atk, lists.get(1), df, lists.get(2));
                while (true){
                    System.out.println("===============");
                    System.out.println("최종 선택: yes or no");
                    System.out.print("입력: ");
                    String choice = Function.scan.nextLine().toLowerCase();
                    if (choice.equals("yes") || choice.equals("y")) {
                        user.setAll(userName, hp, atk, df);
                        user.setMaxHp(hp);
                        System.out.println("캐릭터 생성을 종료합니다.");
                        System.out.println("===============");
                        break statsOur;
                    } else if (choice.equals("no") || choice.equals("n")) {
                        System.out.println("스텟을 재분배합니다.");
                        break;
                    } else {
                        System.out.println("yes or no를 선택해주세요.");
                    }
                }
            }
        }

    }

    public static void usePoint(User user){
        while (true) {
            System.out.printf("""
            ===============
            잔여 포인트: %d 
            1. 현재 체력: %d + 2 
            2. 현재 공격력: %d + 1 
            3. 현재 방어력: %d + 1  
            4. 나가기
            ===============
            어떤 능력치를 올릴까요?
            숫자 입력: """, user.getPoint() ,user.getHp(), user.getAtk(), user.getDf());
            try{
                int choice = Function.scan.nextInt();
                if(user.getPoint() <= 0){
                    System.out.println("사용 가능한 포인트가 없습니다.");
                    break;
                }
                if(choice == 1){
                    user.setHp(user.getHp() + 2);
                    user.setMaxHp(user.getHp());
                } else if (choice == 2) {
                    user.setAtk(user.getAtk() + 1);
                } else if (choice == 3){
                    user.setDf(user.getDf() + 1);
                } else if (choice == 4) {
                    break;
                }else {
                    System.out.println("1 ~ 4까지의 숫자를 입력해주세요.");
                }
                if( 0 < choice && choice < 4){
                    user.setPoint(user.getPoint()-1);
                }

            }catch(InputMismatchException e){
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}
