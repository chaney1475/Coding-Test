import sys
input = sys.stdin.readline

X,Y = map(int, input().split())
ori = (Y* 100) //X

left = 0
right = X
res = X
if ori >= 99:
    print(-1)
else:
    while left <= right:
        mid = (left+right) // 2
        if (100 * (Y+mid)) // (X+mid) > ori:
            res = mid
            right = mid - 1
        else:
            left = mid + 1

    print(res)
