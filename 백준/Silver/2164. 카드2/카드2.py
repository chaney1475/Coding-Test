import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

queue = deque(range(1, n + 1))

while len(queue) > 1:
    queue.popleft()  # 큐의 맨 앞 요소 제거
    queue.rotate(-1)  # 큐를 왼쪽으로 한 칸 회전

# 큐의 최종 상태 출력
print(queue[0])
