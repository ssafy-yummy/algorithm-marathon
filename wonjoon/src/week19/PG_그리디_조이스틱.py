def solution(name):
    # 조이스틱 조작 횟수
    ans = 0

    # 기본 최소 좌우 이동 횟수 = 길이 -1
    min_move = len(name) - 1

    for i, chr in enumerate(name):  # 문자열을 돌면서 매순간 좌우 어느 방향에서 접근하는게 빠른지 판단한다.
        # 해당 알파벳 변경 최솟값 추가
        # A부터 올라가는 방식 / Z에서 내려오는 방식 비교
        ans += min(ord(chr) - ord('A'), ord('Z') - ord(chr) + 1)

        # 해당 알파벳 다음부터 연속된 A문자열 찾기
        nxt = i + 1
        while nxt < len(name) and name[nxt] == 'A':  # A가 끝날때까지 돌린다
            nxt += 1

        non_A = len(name) - nxt  # A 문자열을 제외한 길이
        left = (2 * i) + non_A  # A문자열의 왼편으로 이동(우측 이동)해서 다시 왼쪽(2 * i)으로 이동하는 방법
        right = i + (2 * non_A)  # A문자열의 오른편으로 이동(좌측 이동)해서 다시 오른쪽(2 * non_A)으로 이동하는 방법
        min_move = min(min_move, left, right)

    ans += min_move
    return ans


# print(solution("JAZ"))
print(solution("BBABAAAB"))
