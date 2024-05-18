T = int(input())
grade = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]

for t in range(1, T + 1):
    # 학생수와 번호
    N, K = map(int, input().split())
    # K-1이 K번째
    score = []
    for i in range(N):
        a, b, c = map(int, input().split())
        total = a * 35 + b * 45 + c * 20
        score.append([total, i])

    score.sort(reverse=True)

    answer = -1

    for i in range(N):
        s, k = score[i]
        if k + 1 == K:
            answer = grade[i//(N//10)]
            break
    print(f"#{t} {answer}")
