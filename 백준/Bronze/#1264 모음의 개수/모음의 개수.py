arr = []
collection = ['a','e','i','o','u','A','E','I','O','U']
col_count = 0
while True:
    str = input()
    if str == '#':
        break
    else :
        for i in str:
            if i in collection:
                col_count += 1
        print(col_count)
        col_count = 0