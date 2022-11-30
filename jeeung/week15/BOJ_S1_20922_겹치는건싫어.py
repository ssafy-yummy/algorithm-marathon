n, k = map(int, input().split())
li = list(map(int, input().split()))

l, r = 0, 0

num_count = [0] * int(1e5+1)

max_val = 0
while r < n:
    num_count[li[r]] += 1
    while num_count[li[r]] > k:
        num_count[li[l]] -= 1
        l += 1

    max_val = max(max_val, r-l+1)
    r += 1
print(max_val)
