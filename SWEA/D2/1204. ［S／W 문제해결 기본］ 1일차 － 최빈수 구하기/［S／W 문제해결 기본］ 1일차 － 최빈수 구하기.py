#최빈수
from collections import Counter
t = int(input())

for _ in range(1,t+1):
    N = input()
    A = Counter(list(map(int, input().split())))
    sort_A = sorted(A.items(), key=lambda x : x[1], reverse=True)

    print(f"#{N} {sort_A[0][0]}")

