str1, str2 = map(str, input().split())

counts = list()
for i in range(len(str2) - len(str1)+1):
    count = 0
    for j in range(len(str1)):
        if(str1[j] != str2[j+i]):
            count += 1
    counts.append(count)
print(min(counts))