package user;

import java.util.*;

public class User {
    private String name;
    private int level;
    private int exp;
    private int expPlus;
    private int hp;
    private int maxHp;
    private int atk;
    private int df;
    private int point;

    private String[] sword;
    private String[] helmet;
    private String[] armor;
    private String[] bottom;

    private HashMap<String, Integer> inventory;

     public User(){
        this.name = "";
        this.level = 1;
        this.exp = 0;
        this.expPlus = this.level * 100;
        this.hp = 0;
        this.maxHp = 0;
        this.atk = 0;
        this.df = 0;
        this.point = 3;
        this.inventory = new LinkedHashMap <>();
        this.inventory.put("소 갑옷", 4);
        this.inventory.put("소 헬멧", 2);
        this.inventory.put("소 하의", 2);

        this.sword = new String[2];
        this.helmet = new String[2];
        this.armor = new String[2];
        this.bottom = new String[2];
     }

    public void setAll(String name, int hp, int atk, int df){
         this.name = name;
         this.hp = hp;
         this.atk = atk;
         this.df = df;
    }

    public ArrayList<String> getAll(){
         ArrayList<String> lists = new ArrayList<>(Arrays.asList(
                 name,
                 String.valueOf(level),
                 String.valueOf(exp),
                 String.valueOf(expPlus),
                 String.valueOf(hp),
                 String.valueOf(atk),
                 String.valueOf(df),
                 String.valueOf(point)));
         return lists;
    }



    // 장비관련
    public void unEquipment(int choice,String name, String ability){
        if(choice == 1){
            sword[0] = "";
            sword[1] = "";
        } else if (choice == 2) {
            helmet[0] = "";
            helmet[1] = "";
        } else if (choice == 3){
            armor[0] = "";
            armor[1] = "";
        } else if (choice == 4) {
            bottom[0] = "";
            bottom[1] ="";
        }else {
            System.out.println("1 ~ 4의 숫자를 넣어주세요");
        }
    }


    public void equipment(int choice,String name, String ability){
         if(choice == 1){
             sword[0] = name;
             sword[1] = ability;
         } else if (choice == 2) {
             helmet[0] = name;
             helmet[1] = ability;
         } else if (choice == 3){
             armor[0] = name;
             armor[1] = ability;
         } else if (choice == 4) {
             bottom[0] = name;
             bottom[1] = ability;
         }else {
             System.out.println("1 ~ 4의 숫자를 넣어주세요");
         }
    }

    public HashMap<String, Integer> getInventoryItem(){
        return inventory;
    }

    public void setInventory(String Item, Integer ability) {
         inventory.put(Item, ability);
    }

    public String[] getSword() {
        return sword;
    }

    public void setSword(String sword, int num) {
        this.sword[num] = sword;
    }

    public String[] getBottom() {
        return bottom;
    }

    public void setBottom(String bottom, int num) {
        this.bottom[num] = bottom;
    }

    public String[] getArmor() {
        return armor;
    }

    public void setArmor(String armor, int num) {
        this.armor[num] = armor;
    }

    public String[] getHelmet() {
        return helmet;
    }

    public void setHelmet(String helmet, int num) {
        this.helmet[num] = helmet;
    }

    // 셋터

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExp(int exp){this.exp = exp;}

    public void setExpPlus(int expPlus) {
        this.expPlus = expPlus;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    };
    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDf(int df) {
        this.df = df;
    }

    public void setPoint(int point){
         this.point = point;
    }

    // 겟터
    public int getLevel() {
        return level;
    }
    public int getMaxHp() {
        return maxHp;
    }



    public int getExp() {
        return exp;
    }

    public int getExpPlus() {
        return expPlus;
    }

    public int getDf() {
        return df;
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public int getHp() {
        return hp;
    }

    public int getPoint(){return point;}

    public int getlevel() {
        return level;
     }
}
