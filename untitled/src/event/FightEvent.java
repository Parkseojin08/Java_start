package event;

import monster.Monster;
import user.User;

import java.util.HashMap;

public class FightEvent {
    public static void dropItem(Monster monster, User user){
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

    public static void battleUi(User user, Monster monster){
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

    public static void userWin(User user, Monster monster){
        System.out.printf("""
                        ===============
                        %s님이 %s에게 승리하였습니다.
                        exp: + %d
                        ===============""", user.getName(), monster.getName(), monster.getDropExp());

        user.setHp(user.getMaxHp());
        user.setExp(user.getExp() + monster.getDropExp());
    }

    public static void userDefeat(User user, Monster monster){
        System.out.printf("""
                        ===============
                        %s님이(이)가 %s님에게 패배하였습니다.
                        ===============""", user.getName(), monster.getName());
        user.setHp(user.getMaxHp());
    }
}
