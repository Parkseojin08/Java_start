package event;

import user.User;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class MenuEventSub {


    public static void menuUi(User user){
        System.out.printf("""
                    ================
                    이름: %s  레벨: %d 경험치: %d / %d
                    1. 전투
                    2. 장비
                    3. 스텟
                    4. 종료
                    ================
                    """,user.getName(), user.getlevel(), user.getExp(), user.getExpPlus());
    }

    public static void userEquipped(User user){
        EQEquippedChoiceMessage(user);
        System.out.printf("""
                    1. 장비 리스트 확인
                    2. 장비 장착 및 해제
                    3. 나가기
                    =====================
                        입력: """);
    }

    public static void monsterChoiceUi(){
        System.out.print("""
            ===============
            1. 고블린 
            2. 힘 고블린 
            3. 힘힘 고블린 
            4. 나가기
            > ?. 66111115115
            ===============
            상대의 숫자를 입력해주세요.
            """);
    }

    public static void itemListView(HashMap<String, Integer> inventory){
        while (true) {
            UserEvents.itemList(inventory, "ALL");
            System.out.print("나가기(any): ");
            String exte = Function.scan.nextLine();
            if(!exte.trim().isEmpty()){
                break;
            }
        }
    }


    // 장비 관리임 시작 -
    public static void userEQManagement(User user){
        while (true){
            EQEquippedChoiceMessage(user);
            EQFunctionChoice();
            try{
                int choiceEQ = Function.scan.nextInt();
                if(choiceEQ == 1){
                    EQEquipped(user);
                } else if (choiceEQ == 2) {
                    unEquipped(user);
                } else if (choiceEQ == 3) {
                    break;
                }else {
                    System.out.println("1 ~ 3의 숫자를 입력해주세요.");
                }
            }catch(InputMismatchException e){
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }


    // 밑은 로직

    public static void EQFunctionChoice(){
        System.out.print("""
                                ====================
                                1. 장비 창작
                                2. 장비 해제
                                3. 나가기
                                ====================
                                입력: """);
    }

    public static void unEquipped(User user){
        EQEquippedChoiceMessage(user);
        System.out.print("""
                해제할 장비 
                입력:""");
        try {
            int choice = Function.scan.nextInt();
            switch (choice){
                case 1:
                    user.unEquipment("검", user.getSword()[1]);
                    break;
                case 2:
                    user.unEquipment("헬멧", user.getSword()[1]);
                    break;
                case 3:
                    user.unEquipment("갑옷", user.getSword()[1]);
                    break;
                case 4:
                    user.unEquipment("하의", user.getSword()[1]);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("1 ~ 5를 선택해주세요.");
            }

        }catch(InputMismatchException e){
            System.out.println("숫자를 입력해주세요.");
        }

    }
    public static void EQEquipped(User user){
        while (true){
            EQEquippedChoiceMessage(user);
            System.out.println("""
            장착할 장비 숫자
            입력: """);
            try{
                int choiceWahtEq = Function.scan.nextInt();
                if(choiceWahtEq == 1){
                    EQEquippedWhat("검" ,user);
                }
                else if(choiceWahtEq == 2){
                    EQEquippedWhat("헬멧" ,user);
                }
                else if(choiceWahtEq == 3){
                    EQEquippedWhat("갑옷", user);
                }
                else if(choiceWahtEq == 4){
                    EQEquippedWhat("하의", user);
                }
                else if (choiceWahtEq == 5) {
                    break;
                }else {
                    System.out.println("1 ~ 5의 숫자를 입력해줘");
                }
            }catch(InputMismatchException e){
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    public static void EQEquippedChoiceMessage(User user){
        System.out.printf("""
=====================
장착한 장비
1. sword : %s
2. helmet: %s
3. armor : %s
4. bottom: %s
5. 나가기
=====================
""",
                !user.getSword()[0].isEmpty() ? user.getSword()[0] : "없음",
                !user.getHelmet()[0].isEmpty()  ? user.getHelmet()[0] : "없음",
                !user.getArmor()[0].isEmpty() ? user.getArmor()[0] : "없음",
                !user.getBottom()[0].isEmpty()  ? user.getBottom()[0] : "없음");
    }

    public static void EQEquippedWhat(String choiceEQ, User user){
        while (true){
            if(user.getInventoryItem().isEmpty()) {
                System.out.println("창작할 장비가 없습니다!");
                break;
            }
            HashMap<String, Integer> indexItem = UserEvents.itemList(user.getInventoryItem(), choiceEQ);

            if(indexItem.isEmpty()){
                System.out.println("창작할 장비가 없습니다!");
                break;
            }
            System.out.print("창작할 장비 숫자 입력(나가기: 0): ");
            try {
                int choiceList = Function.scan.nextInt();
                if(choiceList == 0){
                    break;
                }
                if(choiceList >= 1 && choiceList <= indexItem.size() ){
                    Map.Entry<String, Integer> value = getItem(indexItem, choiceList);
                    if(value != null){
                        String name = value.getKey();
                        String ability = String.valueOf(value.getValue());
                        user.equipment(choiceEQ, name, ability);
                        break;
                    }else{
                        System.out.println("번호를 다시 입력해줘");
                    }
                }else{
                    System.out.println("번호를 다시 입렿해주세요");
                }
            }catch (InputMismatchException e){
                System.out.println("숫자를 입력해주세요");
            }
        }
    }


    public static Map.Entry<String, Integer> getItem(HashMap<String, Integer> indexItem, int choiceList){
        if(choiceList < 1 || choiceList > indexItem.size()){
            return null;
        }
        int index = 1;
        for(Map.Entry<String, Integer> entry : indexItem.entrySet()){
            if(index == choiceList){
                return entry;
            }
            index++;
        }
        return null;
    }
}