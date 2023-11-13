def max_n(n):  # 최대값 구하는 함수
    num = 0
    for i in range(len(n)):
        if num < n[i]:
            num = n[i]
    return num


def min_n(n):  # 최소값 구하는 함수
    nums = n[0]
    for i in range(len(n)):
        if nums > n[i]:
            nums = n[i]
    return nums


for case in range(1, 11):
    dump = int(input())
    l = list(map(int, input().split()))

    for _ in range(dump):
        num_m = l[0]  # 최대값 구하기
        num_x = l[0]  # 최소값 구하기
        pos_min = 0  # 최소값의 인덱스
        pos_max = 0  # 최대값의 인덱스
        # 최대값의 위치에서 1개를 빼서 최소값의 위치에 1개씩 쌓는 과정
        for i in range(100):
            if num_m < l[i]:
                num_m = l[i]
                pos_min = i
            if num_x > l[i]:
                num_x = l[i]
                pos_max = i
        l[pos_max] += 1
        l[pos_min] -= 1
    print(f'#{case} {max_n(l) - min_n(l)}')  # 최종적으로 두개의 차이 반환