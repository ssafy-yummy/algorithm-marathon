## 알고리즘 기록

- 알고리즘 스터디 기록을 위한 저장소입니다.

### ✔Rule

- 각각 다른 분류로 구성된 문제들로 선정하여 진행합니다
- **일주일 목표 문제량 : 4문제**
- **문제 풀이 : 일요일 23 : 59 까지**
- **코드 리뷰 : 월요일 23 : 59 까지**

### ✔Commit Convention

- 한 문제 해결 시 commit을 진행합니다

```jsx
Docs : README.md 등 문서 작성 및 수정
BOJ : 문제 플랫폼 약칭
Fix : 코드 수정
Add : 파일 추가
Remove : 파일 삭제
```

- 문제를 풀고 난 뒤

```jsx
git commit -m "BOJ : 13460 G1 구슬 탈출 2"
```

- 이미 커밋한 코드 수정 시

```jsx
git commit -m "Fix : BOJ 13460 G1 구슬 탈출 2, 탐색 방법 수정"
```

- [README.md](http://README.md) 작성 및 수정 시

```jsx
git commit -m "Docs : BOJ 13460 G1 구슬 탈출 2"
```

- 파일 삭제 시

```jsx
git commit -m "Remove : 구슬 탈출 2"
```

- 플랫폼 통일
  - BOJ : 백준
  - PG : 프로그래머스
  - LTC : 리트코드
  - CFS : 코드포스
  - SWEA : 삼성 SW Expert Academy

### ✔Project Convention

- 프로젝트는 각자 개인 패키지에서 작업하고 구조는 다음과 같이 구성합니다.

  - 이름/week 번호/ 플랫폼*문제번호*레벨\_문제이름.java

```jsx
wonjoon / week3 / BOJ_13460_G1_구슬탈출2.java;

wonjoon / week3 / PG_43162_LV3_네트워크.java;
```

### ✔Code Convention

- 작성한 코드의 목적을 주석으로 작성합니다.
- 변수와 함수 이름 작명 시 역할을 알기 쉽도록 간단한 주석을 덧붙입니다.

```jsx
// dfs로 타켓을 찾는 함수
static void findTarget(){
	...
}
```

### ✔Pull Request Convention

<!-- - 최소 주 1 회 이상 일요일 풀이 마감 이전에 PR 을 진행합니다.
- 코드 리뷰는 자율적으로 진행하고 추가 피드백을 원하면 README.md 혹은 comment를 작성합니다.
- 파일 명, 주석 등은 규칙에 맞게 작성해서 다른 사람이 보기 쉽게 하도록 합니다.
- 해당 문제의 Label을 등록해서 어떤 분류의 문제인지 알기 쉽게 합니다. -->

- 한 문제를 풀고 한 문제 당 Commit & PR을 진행합니다.
- 코드 리뷰는 자율적으로 진행하지만 README.md 혹은 comment를 통해 문제 원본 및 출력을 그대로 "복사 & 붙여넣기" 하고 하단에 자신이 풀이와 접근한 방법, 걸린 시간을 기재합니다.
- 파일 명, 주석 등은 규칙에 맞게 작성해서 다른 사람이 보기 쉽게 하도록 합니다.
- 해당 문제의 Label을 등록해서 어떤 분류의 문제인지 알기 쉽게 합니다. -->

- PR 제목은 다음과 같이 통일합니다.
  - 이름 : 문제플랫폼 문제번호 문제등급 문제이름

```jsx
WONJOON : BOJ 13460 G1 구슬 탈출2
```

### 🏃🏻‍♂️week 1

| Type | 문제  | 제목                                                     | 유형        | 등급 |
| ---- | ----- | -------------------------------------------------------- | ----------- | ---- |
| BOJ  | 1920  | [수 찾기](https://www.acmicpc.net/problem/1920)          | 이분탐색    | S4   |
| BOJ  | 14501 | [퇴사](https://www.acmicpc.net/problem/14501)            | 브루트포스  | S3   |
| BOJ  | 3190  | [뱀](https://www.acmicpc.net/problem/3190)               | 덱/큐       | G4   |
| BOJ  | 2667  | [단지 번호 붙이기](https://www.acmicpc.net/problem/2667) | 그래프 탐색 | S1   |

### 🏃🏻‍♂️week 2

| Type | 문제  | 제목                                                 | 유형         | 등급 |
| ---- | ----- | ---------------------------------------------------- | ------------ | ---- |
| BOJ  | 1991  | [트리 순회](https://www.acmicpc.net/problem/1991)    | 트리         | S1   |
| BOJ  | 1992  | [쿼드트리](https://www.acmicpc.net/problem/1992)     | 분할 정복    | S1   |
| BOJ  | 12865 | [평범한 배낭](https://www.acmicpc.net/problem/12865) | DP, 배낭     | G5   |
| BOJ  | 14502 | [연구소](https://www.acmicpc.net/problem/14502)      | 그래프, 구현 | G4   |

### 🏃🏻‍♂️week 3

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| BOJ  | 13305 | [주유소](https://www.acmicpc.net/problem/13305)        | 그리디     | S4   |
| BOJ  | 14889 | [스타트와 링크](https://www.acmicpc.net/problem/14889) | 백트랙킹   | S2   |
| BOJ  | 2293  | [동전 1](https://www.acmicpc.net/problem/2293)         | DP         | G5   |
| BOJ  | 17281 | [⚾](https://www.acmicpc.net/problem/17281)            | 완탐, 구현 | G4   |

### 🏃🏻‍♂️week 4

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| BOJ  | 2805  | [나무 자르기](https://www.acmicpc.net/problem/2805)    	| 이분 탐색       | S2   |
| BOJ  | 14888 | [연산자 끼워넣기](https://www.acmicpc.net/problem/14888)    | 백트래킹   	    | S1   |
| BOJ  | 7576  | [토마토](https://www.acmicpc.net/problem/7576)              | 그래프 탐색     | G5   |
| BOJ  | 1915  | [가장 큰 정사각형](https://www.acmicpc.net/problem/1915)    | DP 		| G4   |

### 🏃🏻‍♂️week 5

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| BOJ  | 5567  | [결혼식](https://www.acmicpc.net/problem/5567)    	| 그래프 탐색    | S2   |
| BOJ  | 18352 | [특정 거리의 도시 찾기](https://www.acmicpc.net/problem/18352)    | 최단거리 | S2   |
| BOJ  | 14503  | [로봇 청소기](https://www.acmicpc.net/problem/14503) | 구현     | G5   |
| BOJ  | 2011  | [암호코드](https://www.acmicpc.net/problem/2011)    | DP 		| G5   |

### 🏃🏻‍♂️week 6

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| BOJ  | 3184  | [양](https://www.acmicpc.net/problem/3184)    	| 그래프 탐색    | S1   |
| BOJ  | 20055 | [컨베이어 벨트 위의 로봇](https://www.acmicpc.net/problem/20055)    | 구현 | G5   |
| BOJ  | 1106  | [호텔](https://www.acmicpc.net/problem/1106) | DP     | G5   |
| BOJ  | 20115  | [에너지 드링크](https://www.acmicpc.net/problem/20115)    | 그리디 		| S3   |

### 🏃🏻‍♂️week 7

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| BOJ  | 12100  | [2048 (Easy)](https://www.acmicpc.net/problem/12100)    	| 구현    | G2   |
| BOJ  | 17413 | [단어 뒤집기 2](https://www.acmicpc.net/problem/17413)    | 문자열 | S3   |
| BOJ  | 1182  | [부분수열의 합](https://www.acmicpc.net/problem/1182) | 백트래킹     | S2   |
| BOJ  | 1715   | [카드 정렬하기](https://www.acmicpc.net/problem/1715)    | 우선순위큐 | G4   |

### 🏃🏻‍♂️week 8

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| SWEA  | 1953  | [탈주범 검거](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq&categoryId=AV5PpLlKAQ4DFAUq&categoryType=CODE&problemTitle=%ED%83%88%EC%A3%BC&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&)    	| 구현 | 모의 |
| PG | 92342 | [양궁 대회](https://school.programmers.co.kr/learn/courses/30/lessons/92342)    | 구현 | Lv.2   |
| BOJ  | 16928 | [뱀과 사다리 게임](https://www.acmicpc.net/problem/16928) | 구현,그래프 | G5   |
| BOJ  | 15685 | [드래곤 커브](https://www.acmicpc.net/problem/15685)    | 구현 | G4 |


### 🏃🏻‍♂️week 9

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| BOJ  | 1916  | [최소 비용 구하기](https://www.acmicpc.net/problem/1916)    	| 다익스트라 | G5 |
| BOJ | 2252 | [줄 세우기](https://www.acmicpc.net/problem/2252)    | 위상 정렬 | G3   |
| BOJ  | 1976 | [여행 가자](https://www.acmicpc.net/problem/1976) | 그래프,분리 집합 |  G4  |
| **BOJ**  | **16234** | **[인구 이동](https://www.acmicpc.net/problem/16234)**    | **구현** | **G5** |


### 🏃🏻‍♂️week 10

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| BOJ  | 20207  | [달력](https://www.acmicpc.net/problem/20207)    	| 구현     | S1  |
| BOJ | 21608 | [상어 초등학교](https://www.acmicpc.net/problem/21608)    | 구현     | G5  |
| BOJ  | 2225 | [합분해](https://www.acmicpc.net/problem/2225)    | DP     |  G5   |
| BOJ  | 1309 | [동물원](https://www.acmicpc.net/problem/1309)     | DP     | S1  |

### 🏃🏻‍♂️week 11

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| BOJ  | 2573  | [빙산](https://www.acmicpc.net/problem/2573)    	| 구현     | G4  |
| BOJ | 1405 | [미친 로봇](https://www.acmicpc.net/problem/1405)    | 그래프     | G5  |
| BOJ  | 14719 | [빗물](https://www.acmicpc.net/problem/14719)    | 구현     |  G5   |
| SWEA  | 5653 | [줄기세포배양](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo&categoryId=AWXRJ8EKe48DFAUo&categoryType=CODE&problemTitle=5653&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)     | 구현     | 모의  |

 ### 🏃🏻‍♂️week 12

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| BOJ  | 20546  | [기적의 매매법](https://www.acmicpc.net/problem/20546)    	| 시뮬레이션     | S5  |
| BOJ | 2564 | [경비원](https://www.acmicpc.net/problem/2564)    | 많은 조건 분기     | S1  |
| BOJ  | 2436 | [공약수](https://www.acmicpc.net/problem/2436)    | 정수론     |  G5   |
| BOJ  | 14565 | [역원 구하기](https://www.acmicpc.net/problem/14565)    | 정수론    | G2  |

 ### 🏃🏻‍♂️week 13

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| SWEA  | 4193  | [수영대회 결승전](https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWKaG6_6AGQDFARV&categoryId=AWKaG6_6AGQDFARV&categoryType=CODE)    	| 완탐, 구현     | D4  |
| SWEA | 2503 | [베스킨라빈스_N](https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AV6h-SF6pisDFAXN&categoryId=AV6h-SF6pisDFAXN&categoryType=CODE)    | 구현     | D3  |
| BOJ  | 12904 | [A와 B](https://www.acmicpc.net/problem/12904)    | 그리디     |  G5   |
| BOJ  | 23843 | [콘센트](https://www.acmicpc.net/problem/23843)    | 그리디    | G5  |

 ### 🏃🏻‍♂️week 14

| Type | 문제  | 제목                                                   | 유형       | 등급 |
| ---- | ----- | ------------------------------------------------------ | ---------- | ---- |
| BOJ  | 2116  | [주사위 쌓기](https://www.acmicpc.net/problem/2116)    	| 구현, 브루트포스 | G5 |
| BOJ | 8394 | [악수](https://www.acmicpc.net/problem/8394)    | 수학, 다이나믹 프로그래밍    | S3  |
| PG  | 카카오 블라인드 | [캐시](https://school.programmers.co.kr/learn/courses/30/lessons/17680?language=python3)    | LRU     |  LV2   |
| BOJ  | 11048 | [이동하기](https://www.acmicpc.net/problem/11048)    | DP    | S2  |

### 🏃Week 15
|Type | 문제 | 제목 | 유형 | 등급|
|--- | --- | --- | --- | ---|
|SWEA| 2105| [디저트 카페](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu&) | 시뮬레이션, 브루트포스 | G5|
|BOJ | 23291| [어항 정리](https://www.acmicpc.net/problem/23291)| 구현,시뮬레이션 | P5|
|PROGRAMMERS | 연습문제 | [전력망을 둘로 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/86971)| 완전탐색 | LV2|
|BOJ | 20922| [겹치는 건 싫어](https://www.acmicpc.net/problem/20922)| 투포인터 | S1|

### 🏃Week 16
|Type | 문제 | 제목 | 유형 | 등급|
|--- | --- | --- | --- | ---|
|SWEA| 2115| [벌꿀채취](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu) | 시뮬레이션 | 모의|
|BOJ | 1079| [마피아](https://www.acmicpc.net/problem/1079)| 완전탐색 | G2|
|PROGRAMMERS | 연습문제 | [구명보트](https://school.programmers.co.kr/learn/courses/30/lessons/42885)| 그리디 | LV2|
|BOJ | 2665| [미로 만들기](https://www.acmicpc.net/problem/2665)| 그래프 | G4|

### 🏃Week 17
|Type | 문제 | 제목 | 유형 | 등급|
|--- | --- | --- | --- | ---|
|SWEA| 5658| [보물상자 비밀번호](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo&categoryId=AWXRUN9KfZ8DFAUo&categoryType=CODE&problemTitle=5658&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1) | 구현 | 모의|
|BOJ | 16235| [나무 재테크](https://www.acmicpc.net/problem/16235)| 구현, 자료구조 | G3|
|BOJ | 17140 | [이차원 배열과 연산](https://www.acmicpc.net/problem/17140)| 구현, 정렬 | G4|
|BOJ | 21924| [도시 건설](https://www.acmicpc.net/problem/21924)| 그래프 이론, 최소 스패닝 트리 | G4|

### 🏃Week 18
|Type | 문제 | 제목 | 유형 | 등급|
|--- | --- | --- | --- | ---|
|BOJ| 13335| [트럭](https://www.acmicpc.net/problem/13335) | 자료구조 | S1|
|BOJ | 2792| [보석 상자](https://www.acmicpc.net/problem/2792)| 자료구조 | S2|
|PG | Summer/Winter Coding | [점프와 순간 이동](https://school.programmers.co.kr/learn/courses/30/lessons/12980)| - | LV2|
|PG | 2018 KAKAO BLIND| [방금그곡](https://school.programmers.co.kr/learn/courses/30/lessons/17683)| - | LV2|

### 🏃Week 19
|Type | 문제 | 제목 | 유형 | 등급|
|--- | --- | --- | --- | ---|
|BOJ | 6549 | [히스토그램에서 가장 큰 직사각형 분할정복](https://www.acmicpc.net/problem/6549) | 세그먼트 트리, 분할 정복 | P5|
|PG | 탐욕법(Greedy) | [조이스틱](https://school.programmers.co.kr/learn/courses/30/lessons/42860) | 그리디 | LV2|
|BOJ | 2251 | [물통](https://www.acmicpc.net/problem/2251) | 너비우선 탐색| G5|
|BOJ | 13164 | [행복 유치원](https://www.acmicpc.net/problem/13164) | 정렬|G5|

### 🏃Week 20
|Type | 문제 | 제목 | 유형 | 등급|
|--- | --- | --- | --- | ---|
|BOJ | 2110 | [공유기 설치](https://www.acmicpc.net/problem/2110) | 세그먼트 트리, 분할 정복 | G4|
|PG | 2021 Dev-Matching | [행렬 테두리 회전하기](https://school.programmers.co.kr/learn/courses/30/lessons/77485) | - | LV2|
|PG | 2022 KAKAO TECH INTERNSHIP | [두 큐 합 같게 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/118667) | - | LV2|
|BOJ | 14621 | [나만 안되는 연애](https://www.acmicpc.net/problem/14621) | MST|G3|

### 🏃Week 21
|Type | 문제 | 제목 | 유형 | 등급|
|--- | --- | --- | --- | ---|
|BOJ | 14500 | [테트로미노](https://www.acmicpc.net/problem/14500) | 세그먼트 트리, 분할 정복 | G4|
|PG | 연습문제 | [할인 행사](https://school.programmers.co.kr/learn/courses/30/lessons/131127) | - | -|
|BOJ | 연습문제 | [귤 고르기](https://school.programmers.co.kr/learn/courses/30/lessons/138476) | -| -|
|BOJ | 16988 | [Baaaduk2](https://www.acmicpc.net/problem/16988) | 정렬|G3|

