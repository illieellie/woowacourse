package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;


public class Application {
    int maxSize = 3;
    int ball = 0;
    int strike = 0;
    boolean done = false; // 게임 시작 여부

    int[] computer = new int[3];
    int[] user = new int[3];

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Application Game = new Application();

            while (true) {
                Game.ClearAll();
                Game.Random();
                // 게임이 끝나기 전까지 반복
                if (Game.done) {
                    Game.UserInputAgain();
                }
                if (Game.done) break;
                while (!Game.done) {
                    Game.UserInputStart();
                    Game.CheckCondition();
                    Game.ClearRepeat();
                }
            }

    }

        void Random(){
            for(int i = 0; i<maxSize;i++) {
                int temp = Randoms.pickNumberInRange(1, 9);
                // Validation
                if (RandomCheck(i, temp)) {
                    computer[i] = temp;
                }
            }
        }

        boolean RandomCheck(int idx, int num){
        // 이미 숫자가 있는지 검증
            boolean result = true;
            for(int i = 0; i<idx; i++){
                if(computer[i]==num) result=false;
            }
          return result;
        }

        void UserInputStart()throws IllegalArgumentException{
             // 처음 진행
            System.out.print("숫자를 입력해주세요 : ");

            String str = Console.readLine();
            if(str.length()>maxSize) {
                throw new IllegalArgumentException();
            }
            user = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();

        }

        void UserInputAgain(){
            // 끝나고 다시 할건지
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int temp = Integer.parseInt(Console.readLine());
            // Validation

            if (temp == 1) done = false; // 1이면 끝내지 않는다.
        }


        void CheckCondition() {
        //boolean result = false;
            for (int i = 0; i < maxSize; i++) {
                RetrieveRow(i);
            }
            PrintResult();
            if(strike==maxSize) {
                done = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }

        }

         void RetrieveRow(int i){
            for (int j = 0; j < maxSize; j++) {
              if(computer[i]==user[j] && i==j){
                  strike++;
              }else if(computer[i]==user[j] && i!=j) {
                  ball++;
              }
            }
        }


    void PrintResult(){
        if(ball!=0)
        {
            System.out.print(ball + "볼 ");
        }
        if(strike!=0)
        {
            System.out.print(strike + "스트라이크");
        }
        if(ball==0&&strike==0)
        {
            System.out.print("낫싱");
        }
        System.out.println();
    }

     void ClearRepeat(){
        ball = 0;
        strike = 0;
    }


    void ClearAll(){
        ClearRepeat();
        computer = new int[3];
    }
}
