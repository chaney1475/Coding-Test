import sys
line = sys.stdin.readline().rstrip()
word = sys.stdin.readline().rstrip()

stack = []
ex_len = len(word)

for i in range(len(line)):
    stack.append(line[i])
    if ''.join(stack[-ex_len:]) == word:
        for _ in range(ex_len):
            stack.pop()
if stack:
    print(''.join(stack))
else:
    print("FRULA")
