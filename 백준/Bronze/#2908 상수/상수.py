num1, num2 = map(str, input().split())
reverse_num1 = ''
reverse_num2 = ''

for i in num1:
    reverse_num1 = i + reverse_num1
for j in num2:
    reverse_num2 = j + reverse_num2
    
if int(reverse_num1) > int(reverse_num2):
    print(reverse_num1)
else :
    print(reverse_num2)