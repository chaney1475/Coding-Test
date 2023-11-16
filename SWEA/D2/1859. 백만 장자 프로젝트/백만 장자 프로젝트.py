#백만장자 프로젝트

t = int(input())

for test_case in range(1, t+1):
    N = int(input())
    A = list(map(int, input().split()))
    B = []
    answer = 0
    for i in A[::-1]:
        if not B:
            B.append(i)
            continue
        if B[-1] > i:
            answer += (B[-1] - i)
        else:
            B.pop()
            B.append(i)

    print(f"#{test_case} {answer}")
