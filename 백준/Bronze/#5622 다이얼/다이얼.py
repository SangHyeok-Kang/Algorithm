arr = ['ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']
number = list(input())
time = 0 
for i in number:
    for j in arr:
        if i in j:
            time += arr.index(j)+3
print(time)