
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
git commit -m "BOJ : 13460 구슬 탈출 2"
```

- 이미 커밋한 코드 수정 시

```jsx
git commit -m "Fix : BOJ 13460 구슬 탈출 2, 탐색 방법 수정"
```

- [README.md](http://README.md) 작성 및 수정 시

```jsx
git commit -m "Docs : BOJ 13460 구슬 탈출 2"
```

- 파일 삭제 시

```jsx
git commit -m "Remove : BOJ 13460 구슬 탈출 2"
```

- 플랫폼 통일
  - BOJ : 백준
  - PG : 프로그래머스
  - LTC : 리트코드
  - CFS : 코드포스
  - SWEA : 삼성 SW Expert Academy

### ✔Project Convention

- 프로젝트는 각자 개인 패키지에서 작업하고 구조는 다음과 같이 구성합니다.

	- 이름/week 번호/ 플랫폼_문제번호_레벨_문제이름.java

```jsx
wonjoon / week3 / BOJ_13460_G1_구슬탈출2.java

wonjoon / week3 / PG_43162_LV3_네트워크.java
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

- 최소 주 1 회 이상 일요일 풀이 마감 이전에 PR 을 진행합니다.
- 코드 리뷰는 자율적으로 진행하고 추가 피드백을 원하면 README.md 혹은 comment를 작성합니다.
- 파일 명, 주석 등은 규칙에 맞게 작성해서 다른 사람이 보기 쉽게 하도록 합니다.
- 해당 문제의 Label을 등록해서 어떤 분류의 문제인지 알기 쉽게 합니다.

- PR 제목은 다음과 같이 통일합니다.
  - 이름 : 문제플랫폼 문제번호 문제등급 문제이름

```jsx
WONJOON : BOJ 13460 G1 구슬 탈출2
```

### 🏃🏻‍♂️week 1

| Type | 문제  | 제목                                                     | 유형        | 등급 |
| ---- | ----- | -------------------------------------------------------- | ----------- | ----------- |
| BOJ  | 1920  | [수 찾기](https://www.acmicpc.net/problem/1920)          | 이분탐색    | S4          |
| BOJ  | 14501 | [퇴사](https://www.acmicpc.net/problem/14501)            | 브루트포스  | S3          |
| BOJ  | 3190  | [뱀](https://www.acmicpc.net/problem/3190)               | 덱/큐          | G4          |
| BOJ  | 2667  | [단지 번호 붙이기](https://www.acmicpc.net/problem/2667) | 그래프 탐색 | S1          |
