dic = dict()

dic['0001101'] = 0
dic['0011001'] = 1
dic['0010011'] = 2
dic['0111101'] = 3
dic['0100011'] = 4
dic['0110001'] = 5
dic['0101111'] = 6
dic['0111011'] = 7
dic['0110111'] = 8
dic['0001011'] = 9


def check(b):
    x = 0  # 홀수 더하기
    y = 0  # 짝수 더하기

    for i in range(0, 56, 7):
        if i % 2 == 0:
            tmp = dic.get(b[i:i + 7], -1)
            if tmp == -1:
                return -1
            else:
                x += tmp
        else:
            tmp = dic.get(b[i:i + 7], -1)
            if tmp == -1:
                return -1
            else:
                y += tmp

    if (x * 3 + y) % 10 == 0:
        return x + y
    else:
        return 0


T = int(input())
for t in range(1, T + 1):
    N, M = map(int, input().split())

    for i in range(N):
        s = input().rstrip()
        s_nums = [int(ss) for ss in s]
        if sum(s_nums) != 0:
            bacode = s

    ends = []

    for i in range(M - 1, -1, -1):
        if bacode[i] == "1":
            ends.append(i)

    answer = -1
    for e in ends:
        extracted = bacode[e - 55:e + 1]
        tt = check(extracted)
        if tt != -1:
            answer = tt
            break

    print(f'#{t} {answer}')
