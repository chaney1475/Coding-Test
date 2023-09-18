import sys

budget_l = []

def getBudget(lis, b):
    lis.sort()
    avr = b // len(lis)
    if avr < lis[0]:
        return avr
    else:
        sum = 0
        for index, value in enumerate(lis):
            sum += value
            if sum + value * (len(lis) - index - 1) > b:
                return (b - sum + value) // (len(lis) - index)

        return lis[-1]


n = int(sys.stdin.readline())
budget_l = list(map(int, sys.stdin.readline().split()))
budget = int(sys.stdin.readline())
print(getBudget(budget_l, budget))
