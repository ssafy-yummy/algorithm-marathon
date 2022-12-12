def solution(people, limit):
    answer = 0
    people.sort()

    i = 0
    j = len(people) - 1

    while i <= j:
        sums = people[i] + people[j]
        if i == j:
            answer += 1
            break
        if sums > limit:
            answer += 1
            j -= 1
        else:  # 2명제한
            i += 1
            j -= 1
            answer += 1

    return answer