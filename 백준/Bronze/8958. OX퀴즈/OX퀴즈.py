import sys
input = sys.stdin.readline



def check(S):
    total = 0
    cnt = 1
    for s in S:
        if s == 'O':
            total += cnt
            cnt += 1
        else:
            cnt = 1

    return total


t = int(input())


for _ in range(t):
    n = input().rstrip()
    print(check(n))
