import sys
input = lambda: sys.stdin.readline().rstrip()
len_S, P = map(int, input().split())
S = list(input())
tmp = {"A": 0, "C": 0, "G": 0, "T": 0}
a,c,g,t = map(int, input().split())

answer = 0

for i in S[:P]:
    tmp[i] += 1

if tmp["A"] >= a and tmp["C"] >= c and tmp["G"] >= g and tmp["T"] >=t:
    answer += 1

for start in range(len_S - P):
    tmp[S[start]] -= 1
    tmp[S[start + P]] += 1
    if tmp["A"] >= a and tmp["C"] >= c and tmp["G"] >= g and tmp["T"] >= t:
        answer += 1

print(answer)
