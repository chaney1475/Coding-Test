import sys
input = sys.stdin.readline

#조약돌 종류 수
N = int(input())

#조약돌 모음
rocks = list(map(int, input().split()))

probability = [0] * (51)
#꺼낼 갯수
K = int(input())

total_rocks = sum(rocks)

answer = 0

for r in rocks:
    
    temp = 1
    if r >= K:
        for k in range(0,K):
            temp *= (r-k) / (total_rocks-k)
        answer += temp

print(answer)
