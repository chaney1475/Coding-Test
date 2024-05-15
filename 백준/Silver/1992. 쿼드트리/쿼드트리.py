import sys
input = sys.stdin.readline

N = int(input())
A = []

for _ in range(N):
    A.append(list(map(int, input().rstrip())))

def check(x,y, leng):
    c = A[x][y]
    for i in range(leng):
        for j in range(leng):
            if c != A[x+i][y+j]:
                return False
    return True


def compression(a,b,l):
    temp = []
    if l == 1 or check(a,b,l):
        return str(A[a][b])
    else:
        temp.append(compression(a,b,l//2))
        temp.append(compression(a,b+l//2,l//2))
        temp.append(compression(a+l//2,b,l//2))
        temp.append(compression(a+l//2,b+l//2,l//2))

    answer = ""
    for t in temp:
        answer += str(t)

    return "(" + answer + ")"


print(compression(0,0,N))

