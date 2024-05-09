import sys

input = sys.stdin.readline

N = int(input())

animal = list(map(int, input().split()))
big_l = max(animal) + 1  # 더 많은 동물의 수
small_l = N - big_l  # animal list가 유효할 경우 적은 동물의 수


def check():
    # 가능한 리스트인지 확인
    if big_l > N:
        return False
    for i in range(big_l):
        if i in temp:
            temp.remove(i)
        else:
            return False
    for i in range(small_l):
        if i in temp:
            temp.remove(i)
        else:
            return False
    if len(temp) != 0:
        return False

    return True


temp = [i for i in animal]


def make_comb():
    answer = 2 ** small_l
    if small_l != big_l:
        answer *= 2
    return answer


if not check():
    print(0)
    sys.exit()
else:
    print(make_comb())
