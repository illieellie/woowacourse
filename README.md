# woowacourse
Baseball game

조건
1. 외부 api 사용 (랜덤, 입력)
2. 사용자가 잘못된 값을 입력할 경우 Exception 발생 후 종료
3. 함수로 최대한 기능 분리
4. Depth 규약 및 개발 컨벤션


구현 및 공부
1. string -> int 형 배열로 변환 : Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
2. Exception 발생 : throw new IllegalArgumentException();


문제 및 해결
1. TestCode와 UserCode 간 데이터 입력 방식 상이 
: Readme만 읽고 랜덤api로 랜덤값을 추출할때 3자리 한번에 받아옴
테스트 하려고 보니 테스트코드는 한자리씩 랜덤하게 불러오고 있어서 코드가 제대로 실행이 안 되었음 
2. 버전문제
: "unable to determine if the scanner is closed."
사용자 입력을 2번째부터 받을 때 마다, 해당 문장이 계속해서 출력되는 것을 발견.
입력받을때 사용한 api에서는 scanner를 사용했고 문제는 열었던 Scanner를 닫지않고 다시 받으려고해서 발생하는 문제였음.
구글링 해본 결과 정확한 버전은 모르겠으나 버전 16이상은 이 에러가 동일하게 일어난 다는 것을 발견. 
Java 버전을 11로 낮춰 실행하니 문제 해결. 


느낀점
1. 문제만 읽지 말고 테스트코드를 보고 입력값이 정확히 어떻게 들어오는지 부터 파악 후 코딩
2. 버전 문제에 대해 많이 경험하고 훈련하기 ^_^ 


보완할 점 
1. 자바 컨벤션 적용
2. 불필요한 변수 선언 줄이기 - 메모리
3. 들여쓰기, 코드라인 엔터 (.)당 한줄
4. (나중) thread 동시성 생각해서 코딩
5. 변수, 메소드 private이 기본, 상속 및 외부에서 접근할 일이 있을 때 protected, public 순으로 접근 제한자 변경하여 사용    


추가 공부
1. Exception 추가 실습 
2. 우테코 test 메소드 explore
3. 함수형, 람다식







