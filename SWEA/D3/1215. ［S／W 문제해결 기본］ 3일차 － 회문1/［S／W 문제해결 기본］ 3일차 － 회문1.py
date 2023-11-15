# 회문1
def is_palindrome(A):
    while len(A) > 1:
        if A.pop() != A.pop(0):
            return False
    return True


for test_case in range(1, 11):
    answer = 0
    N = int(input())

    A = []
    for j in range(8):
        A.append([c for c in input()])

    if N == 1:
        print(f"#{test_case} 64")
    else:
        for j in range(8):
            for k in range(0, 9 - N):
                str = A[j][k:k + N]
                if is_palindrome(str):
                    answer += 1
                str = []
                for i in range(0,N):
                    str.append(A[i+k][j])
                if is_palindrome(str):
                    answer += 1

        print(f"#{test_case} {answer}")
