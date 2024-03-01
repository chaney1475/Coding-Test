import sys
import heapq

input = sys.stdin.readline

N = int(input())


len_a = [set() for _ in range(51)]


for _ in range(N):
    a = input().strip()
    len_a[len(a)].add(a)


for i in range(51):
    if len(len_a[i]) > 0:
        len_a[i] = sorted(len_a[i])
    for s in len_a[i]:
        print(s)