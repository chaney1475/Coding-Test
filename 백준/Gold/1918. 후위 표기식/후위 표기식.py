inlst = input()
lst = []
ans = ''
for i in inlst:
    if i == '(':
        lst.append(i)
    elif i == ')':
        while lst and lst[-1] != '(':
            ans += lst.pop()
        lst.pop()
    elif i == '*' or i == '/':
        while lst and (lst[-1] == '*' or lst[-1] == '/'):
            ans += lst.pop()
        lst.append(i)
    elif i == '+' or i == '-':
        while lst and lst[-1] != '(':
            ans += lst.pop()
        lst.append(i)
    else:
        ans += i
while lst:
    ans += lst.pop()
print(ans)