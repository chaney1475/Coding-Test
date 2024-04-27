import sys
from itertools import permutations
input = sys.stdin.readline

N,M,K = map(int, input().split())
A = []

for _ in range(N):
    A.append(list(map(int, input().split())))


def rotate(s_x,s_y,e_x,e_y):
    saved = temp[s_x][s_y]
    for i in range(s_x,e_x):
        temp[i][s_y] = temp[i+1][s_y]
    for i in range(s_y,e_y):
        temp[e_x][i] = temp[e_x][i+1]
    for i in range(e_x,s_x,-1):
        temp[i][e_y] = temp[i-1][e_y]
    for i in range(e_y,s_y+1,-1):
        temp[s_x][i] = temp[s_x][i-1]
    temp[s_x][s_y+1] = saved

def full_rotate(x,y,s):
    for i in range(1,s+1):
        rotate(x-i,y-i,x+i,y+i)


R = []
for _ in range(K):
    r,c,s = map(int, input().split())
    R.append([r-1,c-1,s])

rotate_order = list(permutations([i for i in range(K)]))

def check():
    global answer
    for i in range(N):
        answer = min(sum(temp[i]),answer)


answer = sys.maxsize

for r in rotate_order:
    temp = [[N[i] for i in range(M)] for N in A]
    for i in r:
        full_rotate(R[i][0],R[i][1],R[i][2])
    check()

print(answer)