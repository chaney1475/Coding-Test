import sys
from itertools import combinations
input = sys.stdin.readline

V,P,L = map(int,input().split())
village = list(map(int, input().split()))

index = [i for i in range(V)]

comb = list(combinations(index,P))

answer = sys.maxsize
l_answer = []


def check(c):
    global answer
    global l_answer
    temp = 0
    for i in range(V):
        if i in c:
            continue
        left = i - 1
        right = i + 1
        while 1:
            if left < 0:
                left = V - 1
            if left in c:
                dist1 = min(abs(village[left] - village[i]), L - abs(village[left] - village[i]))
                break
            left -= 1

        while 1:
            if right >= V:
                right = 0
            if right in c:
                dist2 = min(abs(village[right] - village[i]), L - abs(village[right] - village[i]))
                break
            right += 1
        temp += min(dist1, dist2)

    if temp < answer:
        answer = temp
        l_answer = c

for c in comb:
    check(c)
print(answer)
print(* [village[i] for i in l_answer])
