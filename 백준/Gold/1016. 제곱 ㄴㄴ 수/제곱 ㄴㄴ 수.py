def count_square_free(Min, Max):
    is_square_free = [True] * (Max - Min + 1)

    for i in range(2, int(Max**0.5) + 1):
        pow_num = i * i
        start_index = (Min + pow_num - 1) // pow_num

        for j in range(start_index, (Max // pow_num) + 1):
            is_square_free[j * pow_num - Min] = False

    count = sum(1 for x in is_square_free if x)
    return count

# 입력
Min, Max = map(int, input().split())

# 결과 출력
result = count_square_free(Min, Max)
print(result)
