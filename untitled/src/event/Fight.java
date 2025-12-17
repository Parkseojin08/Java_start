package event;


import user.User;

import monster.*;

import java.util.HashMap;
import java.util.InputMismatchException;

public class Fight{

    public static void fights(User user, Monster monster){
        while (true) {
            if (monster.getHp() <= 0) {
                System.out.printf("""
                        ===============
                        %s님이 %s에게 승리하였습니다.
                        exp: + %d
                        ===============""", user.getName(), monster.getName(), monster.getDropExp());

                user.setHp(user.getMaxHp());
                user.setExp(user.getExp() + monster.getDropExp());

                if( Function.ranInt(101,1) >= 70){
                    int ranInts = Function.ranInt(monster.getDropItemLength(),0);
                    HashMap<String, Integer> monsterItemList = monster.getDropItemAll();
                    HashMap<String, Integer> userItemList = user.getInventoryItem();

                    String dropItem = (String) monsterItemList.keySet().toArray()[ranInts];
                    int ability = monsterItemList.get(dropItem);

                    if(!userItemList.containsKey(dropItem)){
                        user.setInventory(dropItem, ability);
                    }
                    System.out.printf("""
                            ===============
                            %s(이)가 %s를 드랍했습니다!
                            ===============
                            """,monster.getName(), dropItem);
                }

                if(user.getExp() >= user.getExpPlus()){
                    System.out.printf("""
                            =========================
                            %s님 축하드립니다! 
                            레벨업 하셨습니다!
                            Level: %d -> %d
                            exp: %d -> %d
                            expMax: %d -> %d
                            HP + 2, ATK + 1, DF + 1
                            =========================
                            """
                            ,user.getName(),
                            user.getlevel(), user.getlevel()+1,
                            user.getExp(), user.getExp() - user.getExpPlus(),
                            user.getExpPlus(), user.getExpPlus() * (user.getLevel() + 1));

                    user.setExp(user.getExp() - user.getExpPlus());
                    user.setLevel(user.getlevel() + 1);
                    user.setPoint(user.getPoint() + 3);
                    user.setExpPlus(user.getExpPlus() * user.getLevel());
                    user.setAll(user.getName(), user.getHp() + 2, user.getAtk() + 1, user.getDf() + 1);
                }else if(user.getHp() <= 0){
                    System.out.printf("""
                        ===============
                        %s님이(이)가 %s님에게 패배하였습니다.
                        ===============""", user.getName(), monster.getName());
                    user.setHp(user.getMaxHp());
                    break;
                }

                break;
            }
            System.out.printf("""
                            ==============================
                            이름: %s
                            HP: %d ATK: %d DF: %d
                            
                            USER: %s
                            HP: %d ATK: %d DF: %d
                            LEVEL: %d exp: %d / %d
                            ============================== 
                            1. 공격 2. 도망
                            입력: """,
                    monster.getName(), monster.getHp(), monster.getAtk(), monster.getDf(),
                    user.getName(), user.getHp(), user.getAtk(), user.getDf(), user.getlevel(), user.getExp(), user.getExpPlus());
            try{
                int choice = Function.scan.nextInt();
                if(choice == 1){
                  monster.setHp(monster.getHp() - fightAtk(user.getName(), monster.getName(),user.getAtk(), monster.getDf() ));
                  user.setHp(user.getHp() - fightAtk(monster.getName(), user.getName(),monster.getAtk(), user.getDf() ));
                } else if (choice == 2) {
                    System.out.println("도망쳤다!");
                    user.setHp(user.getMaxHp());
                    break;
                }else {
                    System.out.println("1 or 2를 숫자를 입력해주세요.");
                }
            }catch(InputMismatchException e){
                System.out.println("1 or 2를 선택해주세요.");
            }
        }
    }
    static int fightAtk(String atkName, String defName, int atk, int def){
        int result = atk - def;
        if(result <= 0){
            result = 1;
        }else {
        }
        System.out.printf("""
                    ===============
                    %s가 %s에게 데이지 %d을 주었습니다. 
                    ===============
                    """,atkName, defName, result);
        return result;

    };
}
