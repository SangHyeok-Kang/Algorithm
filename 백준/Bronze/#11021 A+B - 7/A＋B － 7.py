count = int(input())
sum = []
for i in range(count):
    A,B = map(int, input().split())
    sum.append(A+B)
for j in range(count):
    print(f"Case #{j+1}:", sum[j])