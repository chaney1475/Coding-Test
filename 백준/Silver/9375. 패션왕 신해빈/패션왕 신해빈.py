import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    clothes = dict()
    for _ in range(N):
        a,b = input().split()
        if b in clothes:
            clothes[b] += 1
        else:
            clothes[b] = 1

    answer = 1
    for i in clothes.values():
        answer *= (i+1)
    print(answer - 1)