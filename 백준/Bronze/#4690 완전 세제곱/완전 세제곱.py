temp = [i**3 for i in range(0,101)]

for a in range(2,101):
    for b in range(2, a):
        for c in range(b+1, a):
            for d in range(c+1, a):
                if temp[a] == temp[b] + temp[c] + temp[d]:
                    print("Cube = "+ str(a) +", Triple = ("+ str(b) +","+ str(c) +","+ str(d) +")")