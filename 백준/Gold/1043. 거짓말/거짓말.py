import sys

input = sys.stdin.readline

# 사람수 = N, 파티수 = M
N, M = map(int, input().split())

T = list(map(int, input().split()))
# 진실을 아는 사람수
cnt_t = T[0]

# 진실을 아는 사람 번호
T = T[1:]


def find(x):
    if x != A[x]:
        A[x] = find(A[x])
    return A[x]


def union(a, b):

    x = find(a)
    y = find(b)

    if B[x]:
        A[y] = x
    elif B[y]:
        A[x] = y
    elif x <= y:
        A[y] = x
    else:
        A[x] = y


# 초기화
A = [x for x in range(N + 1)]
B = [False] * (N+1)

for t in T:
    B[t] = True

Ps = []
for _ in range(M):
    P = list(map(int, input().split()))
    # 파티 사람수
    cnt_p = P[0]
    # 파티 사람 번호
    P = P[1:]
    Ps.append(P)
    for i in range(0, cnt_p-1):
        union(P[i], P[i+1])

cnt = M

for i in range(M):
    for p in Ps[i]:
        if B[find(p)]:
            cnt -= 1
            break

print(cnt)