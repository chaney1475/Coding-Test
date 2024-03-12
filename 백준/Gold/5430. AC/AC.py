from collections import deque
import sys

input = sys.stdin.readline

N = int(input())

def check(d_list, l):
    r = 0
    D = []

    for i in range(len(d_list)):
        if d_list[i] == 'R':
            r += 1
        else:
            if r % 2 == 0:
                D.append(0)
            else:
                D.append(-1)

    # 리스트를 deque로 변환
    dq = deque(l)

    for i in range(len(D)):
        if not dq:
            print("error")
            return
        dq.popleft() if D[i] == 0 else dq.pop()

    if r % 2 == 1:
        dq = list(dq)[::-1]
        print("[", end="")
        for i in range(len(dq)):
            print(dq[i], end="")
            if i != len(dq)-1:
                print(",", end="")
        print("]")
    else:
        print("[", end="")
        for i in range(len(dq)):
            print(dq[i], end="")
            if i != len(dq)-1:
                print(",", end="")
        print("]")

for _ in range(N):
    do = input().rstrip()
    n = int(input())

    # 리스트
    s = input().rstrip()
    lst = []
    if len(s) > 2:
        lst = [int(i) for i in s[1:-1].split(',')]

    check(do, lst)
