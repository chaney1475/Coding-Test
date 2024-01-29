import sys
input = sys.stdin.readline

N = int(input())
A = set(map(int,input().split()))


M = int(input())
L = list(map(int,input().split()))

for l in L:
    print(1 if l in A else 0, end=" ")
