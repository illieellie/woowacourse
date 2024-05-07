package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;


public class Application {
    int maxSize = 3;
    int ball = 0;
    int strike = 0;
    boolean done = false; // 게임 시작 여부

    int[] computer = new int[4];
    int[] user = new int[4];

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Application Game = new Application();
        while(true) {
            Game.Random();
            // 게임이 끝나기 전까지 반복
            if(Game.done)Game.UserInput();
            if(Game.done)break;
            while (!Game.done) {
                Game.UserInput();
                Game.CheckCondition();
                Game.Clear();
            }
        }
    }

        void Random(){
        boolean isOkay = false;
        while(!isOkay){
            int temp = Randoms.pickNumberInRange(1, 999);
            // Validation
            if(temp>100) {
                computer = Stream.of(String.valueOf(temp).split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                isOkay = RandomCheck();
            }
        }
        }
        boolean RandomCheck(){
            // 한번 더 체크 랜덤값에 0이 들어있으면 안됨, 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택
        boolean result = true;

        if(computer[0]==0||computer[1]==0||computer[2]==0||computer[0]==computer[1]||computer[0]==computer[2]||computer[1]==computer[2]) {
            result = false;
        }
        return result;
    }

        void UserInput(){
            try {
                if (done == false) {
                    // 처음 진행
                    System.out.print("숫자를 입력해주세요 : ");

                    //digits = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
                    String str = Console.readLine();
                    // validation
                    if(str.length()!=3)System.exit(0);
                    user = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();

                    //System.out.println("[Debug]"+user);

                } else {
                    // 끝나고 다시 할건지
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    int temp = Integer.parseInt(Console.readLine());
                    // Validation
                    if(temp!=1||temp!=2)System.exit(0);

                    if (temp == 1) this.done = false; // 1이면 끝내지 않는다.
                }}catch(IllegalArgumentException e){
                        System.exit(0);
                }

        }


        void CheckCondition() {
        //boolean result = false;
            for (int i = 0; i < maxSize; i++)
            {
                RetrieveRow(i);
            }
            PrintResult();
            if(strike==maxSize) {
                //result = true;
                done = true;
            }

            //return result;
        }


         void RetrieveRow(int i){
            for (int j = 0; j < maxSize; j++) {
              if(computer[i]==user[j] && i==j){
                  // strike
                  strike++;
              }
              else if(computer[i]==user[j] && i!=j)
              {
                  // ball
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
        {System.out.print("낫싱");}

        System.out.println();
    }

     void Clear(){
        ball = 0;
        strike = 0;
    }
}
