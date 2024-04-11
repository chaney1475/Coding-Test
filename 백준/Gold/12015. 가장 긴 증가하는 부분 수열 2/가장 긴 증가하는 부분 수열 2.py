import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

def lengthOfLIS(nums):
    LIS = []

    # 주어진 수열의 각 원소에 대해 순회합니다.
    for num in nums:
        # 이분 탐색을 이용하여 현재 원소가 들어갈 위치를 찾습니다.
        left, right = 0, len(LIS)
        while left < right:
            mid = (left + right) // 2
            if LIS[mid] < num:
                left = mid + 1
            else:
                right = mid
        # 만약 현재 원소가 LIS의 모든 원소보다 크다면 LIS에 추가합니다.
        if left == len(LIS):
            LIS.append(num)
        # 그렇지 않다면, 현재 원소보다 크거나 같은 첫 번째 원소를 현재 원소로 업데이트합니다.
        else:
            LIS[left] = num

    # LIS 배열의 길이가 가장 긴 증가하는 부분 수열의 길이입니다.
    return len(LIS)

print(lengthOfLIS(A))