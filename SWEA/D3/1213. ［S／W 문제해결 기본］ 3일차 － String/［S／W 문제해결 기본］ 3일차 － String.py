
for _ in range(1, 10+1):
    test_case = int(input())
    string = input().rstrip()
    A = input().rstrip()

    find = []
    count = 0

    for a in A:
        find.append(a)
        if "".join(find[-len(string):]) == string:
            count += 1
            find = []

    print(f"#{test_case} {count}")