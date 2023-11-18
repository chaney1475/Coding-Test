#단조증가하는 수

T = int(input())


def check(n):
    former = 0
    for c in str(n):
        if int(c) < former:
            return False
        former = int(c)

    return True


for test_case in range(1, T+1):
    N = int(input())
    A = list(map(int, input().split()))
    A.sort()
    B = A[::-1]
    answer = -1

    for i in range(0, N):
        for j in range(i+1, N):
            k = B[i] * B[j]
            if check(k):
                if answer < k:
                    answer = k

    print(f"#{test_case} {answer}")
