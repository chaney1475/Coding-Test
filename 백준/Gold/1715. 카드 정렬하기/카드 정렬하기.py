from queue import PriorityQueue
import sys

input = sys.stdin.readline
N = int(input().rstrip())
pq = PriorityQueue()

for _ in range(0, N):
    date = int(input())
    pq.put(date)

n = 0

while pq.qsize() > 1:
    A = pq.get()
    B = pq.get()
    n = n + A + B
    pq.put(A + B)

print(n)
