import sys
from collections import deque


def bfs():
  queue = deque()
  queue.append(1)
  visited[1] = True
  while queue:
    value = queue.popleft()
    for i in graph[value]:
      # i가 방문되지 않았으면, i의 부모는 value이다.
      if not visited[i]:
        data[i] = value
        queue.append(i)
        visited[i] = True


# n 입력 받기
n = int(sys.stdin.readline().rstrip())

# graph에 정보 입력 받기
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
  a, b = map(int, sys.stdin.readline().rstrip().split())
  graph[a].append(b)
  graph[b].append(a)

# data 리스트에는 자신의 부모 값이 들어간다. 초기화
data = [0] * (n + 1)
# 방문 했는지 여부 확인하는 visited 리스트
visited = [False] * (n + 1)

# bfs 함수 실행
bfs()

# 2부터 n까지 정답 출력
for i in range(2, n + 1):
  print(data[i])