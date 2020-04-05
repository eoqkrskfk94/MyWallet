# MyWallet Application

가계부나 자산관리 어플리케이션은 무수히 많다. 하지만 너무 복잡해서 나와 같은 귀찮니즘에 빠진 사람은 
__"작심삼일"__ 로 그 어플리케이션을 오래 사용하지 못한다.

그래서 정말 간단하지만 정말 편하고 쉽게 내가 얼마를 사용했고 사용했는지 알 수 있는 어플리케이션을 만들면 좋겠다라는 생각으로
이 어플리케이션을 개발했습니다.

__"정만 간단한 인터페이스, 쉬운 사용법, 많지 않은 버튼!"__

자신이 사용한 내역을 데이터베이스로 쉽게 적근하고 싶은 사람들은 간단하게 SQLite 데이터베이스 파일을 불러와 사용할 수 있습니다

### 어플리케이션 구성도 및 사용된 기술

<p align="center"> <img width="622" alt="선행" src="https://user-images.githubusercontent.com/37679062/77749427-59dec180-7065-11ea-8d4f-9aad51e920a5.JPG"> </p>

### 데이터베이스

해당 데이터베이스는 이 어플이 실행되고있는 스마트폰의 저장공간에 저장이된다. 즉 다른 스마트폰에서는 같은 기록을 볼 수 없으면 해당 데이터베이스 파일은 SQLite database를 사용하며 스마트폰의 저장공간에서 확인할 수 있다. 

<p align="center"> <img width="622" alt="선행" src="https://user-images.githubusercontent.com/37679062/77749877-251f3a00-7066-11ea-9d89-2bd3a8feff24.JPG"> </p>
<p align="center"> 해당 스크린샷은 실제 어플로 기록을 저장후 데이터베이스 파일을 받아와 database browser 프로그램으로 열어 본것이다.</p> 


### 스크린샷

<p align="center"> <img width="811" alt="스크린샷 2020-04-05 오후 3 12 07" src="https://user-images.githubusercontent.com/37679062/78468162-e10bf380-774f-11ea-87cb-e47918f2e4c5.png"> </p>


