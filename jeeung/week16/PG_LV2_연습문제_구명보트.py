def solution(people, limit):
    answer = 0
    people.sort(reverse=True)
    
    i, j = 0, len(people) - 1
    
    while i <= j:
        if people[i] + people[j] <= limit:
            j -= 1
        i += 1
        answer += 1
    
    return answer