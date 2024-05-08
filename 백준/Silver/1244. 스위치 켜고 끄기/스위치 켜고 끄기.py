import sys
input = sys.stdin.readline

N = int(input())

switch = [0]
switch += list(map(int,input().split()))


M = int(input())
for _ in range(M):
    a, b = map(int,input().split())
    if a == 1:
        for i in range(b,N+1,b):
            switch[i] = (switch[i]+1) % 2
    else:
        i = b
        switch[i] = (switch[i]+1) % 2
        s,e = b-1, b+1
        while s > 0 and e <= N:
            if switch[s] == switch[e]:
                switch[s] = (switch[s] + 1) % 2
                switch[e] = (switch[e] + 1) % 2
                e += 1
                s -= 1
            else:
                break
length = N // 20 if N % 20 == 0 else N // 20 + 1
for i in range(length):
    if i != length - 1:
        print(*switch[i * 20 + 1: (i+1) * 20 + 1])
    else:
        print(*switch[i * 20+1: N+1])

