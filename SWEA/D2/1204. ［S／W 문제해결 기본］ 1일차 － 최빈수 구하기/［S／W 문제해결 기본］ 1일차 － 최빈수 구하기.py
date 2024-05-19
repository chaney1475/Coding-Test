T = int(input())

for t in range(1, T+1):
    t = int(input())
    student = list(map(int, input().split()))
    score = [0] * 101
    for s in student:
        score[s] += 1

    ll = []

    for i in range(1, 101):
        ll.append([score[i], i])

    ll.sort(reverse=True)
    max_cnt = ll[0][0]
    maxs = []
    for cnt, num in ll:
        if cnt == max_cnt:
            maxs.append(num)
        else:
            break

    print(f"#{t} {max(maxs)}")