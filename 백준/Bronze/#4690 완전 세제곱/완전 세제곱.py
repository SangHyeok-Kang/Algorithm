for a in range(6,101):
    tmp = a**3
    for b in range(2, a):
        tmp2 = b**3
        for c in range(b+1, a):
            tmp3 = c**3
            for d in range(c+1, a):
                tmp4 = d**3
                if tmp == tmp2 + tmp3 + tmp4:
                    print("Cube = "+ str(a) +", Triple = ("+ str(b) +","+ str(c) +","+ str(d) +")")

