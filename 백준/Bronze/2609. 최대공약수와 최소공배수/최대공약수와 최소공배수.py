import math
a,b = map(int,input().split())
common = math.gcd(a,b)
print(common)
print(a*b// common)