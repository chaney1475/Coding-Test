import sys
input = sys.stdin.readline

N, M, L = map(int, input().split())

cnt = [0] * (N+1)

s = 1
cnt[s] += 1
answer = 0
while M != cnt[s]:
    if cnt[s] % 2 == 0:
        next = s - L
    else:
        next = s + L
    if next < 1:
        next = next + N
    if next > N:
        next = next - N
    cnt[next] += 1
    answer += 1
    if cnt[next] == M:
        break
    s = next

print(answer)