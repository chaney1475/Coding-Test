T = int(input())


def dfs(n, left):
    global answer
    if left == 0:
        if int("".join(n)) > answer:
            answer = int("".join(n))
        return

    for i in range(length):
        for j in range(i + 1, length):
            n[i], n[j] = n[j], n[i]
            new_n = int("".join(n))
            if dic.get((new_n, left), 1):  # 없는 경우
                dic[(new_n,left)] = 0 #있는 경우 0으로
                dfs(n, left - 1)
            n[i], n[j] = n[j], n[i]


for t in range(1, T + 1):
    nums, cnt = input().split()
    nums = list(nums)
    cnt = int(cnt)
    length = len(nums)
    answer = -1

    # 회차에 등장했는지
    dic = {}
    dfs(nums, cnt)
    print(f"#{t} {answer}")
