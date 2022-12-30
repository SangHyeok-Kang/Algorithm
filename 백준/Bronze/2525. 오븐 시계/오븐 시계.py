hour, minute = map(int, input().split())
cookmin = int(input())

endcookmin = minute + cookmin
while True:
    if endcookmin >= 60 :
        hour += 1
        endcookmin -= 60
        if endcookmin >= 60:
            hour += 1
            endcookmin -= 60
        else :
            break
    else :
            break
       
if hour >=24 :
    hour -= 24

    
print(hour, endcookmin)
