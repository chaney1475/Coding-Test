import sys

readline = sys.stdin.readline

def dfs(num, arr):
    arr[num] = -2
    for i in range(len):
        if num == arr[i]:
            dfs(i, arr)


len = int(readline())
nodes = list(map(int, readline().split()))
index = int(readline())

dfs(index, nodes)
count = 0
for i in range(len):
    if nodes[i] != -2 and i not in nodes:
        count += 1
print(count)
