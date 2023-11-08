import sys
from queue import PriorityQueue
input = sys.stdin.readline

pos = PriorityQueue()
neg = PriorityQueue()

N = int(input())

one = 0
for _ in range(N):
    a = int(input())
    if a == 1:
        one += 1
    elif a > 0:
        pos.put(-a)
    else:
        neg.put(a)

answer = 0
while pos.qsize() > 1:
    A = pos.get()
    B = pos.get()
    answer += A*B

if pos.qsize() > 0:
    answer += -pos.get()

while neg.qsize() > 1:
    A = neg.get()
    B = neg.get()
    answer += A * B

if neg.qsize() > 0:
    answer += neg.get()

answer += one
print(answer)