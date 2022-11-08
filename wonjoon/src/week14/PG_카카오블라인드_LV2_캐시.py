def solution(cacheSize, cities):
    ans = 0
    arr = []
    city_lower = []

    if cacheSize == 0:
        return len(cities) * 5

    for i in cities:
        city_lower.append(i.lower())

    for s in city_lower:
        if s in arr:  # cache hit
            # 이미 있으면 뒤로 빼준다
            arr.remove(s)
            arr.append(s)
            ans += 1

        else:  # cache miss
            ans += 5
            # 자리가 없으면 앞에꺼 빼고 추가
            if len(arr) == cacheSize:
                del arr[0]
                arr.append(s)
            else:
                # 자리가 있으면 그냥 추가
                arr.append(s)

    return ans


"""
완탐
1. 모든 자리에 차례대로 도시를 대입해본다
2. 리스트에 값이 있으면 1을 더하고 return?
3. 없으면 5를 더하고 next
4. 한 바퀴 돌면 다시 처음부터 
-> 말이 안됨, 느림ㅠ

LRU 사용
1. 리스트에 없으면 끝에 대입한다 +5 
2. 있으면 맨 뒤로 뺀다 +1
3. 자리가 없으면 맨 앞에 있는걸 지우고 끝에 대입한다 +5
"""