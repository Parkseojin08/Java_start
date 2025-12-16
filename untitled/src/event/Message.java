package event;
public class Message {

    public static boolean startMessage(){
        System.out.println("게임을 시작하시겠습니까? yes or no");
        boolean yourChoice;
        while (true){
            System.out.print("입력: ");
            String choiceStart = event.Function.scan.nextLine().toLowerCase();
            if(choiceStart.equals("yes") || choiceStart.equals("y")){
                yourChoice = true;
                break;
            }
            else if(choiceStart.equals("no") || choiceStart.equals("n")){
                yourChoice = false;
                break;
            }
            else{
                System.out.println("Yes or No 를 선택해 주세요.");
            }
        }
        return yourChoice;
    }
}
