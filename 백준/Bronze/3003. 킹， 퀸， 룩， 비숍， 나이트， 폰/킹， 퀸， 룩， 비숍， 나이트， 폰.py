king, queen, look, bishop, knight, pawn = map(int, input().split())
tot_king = 1
tot_queen = 1
tot_look = 2
tot_bishop = 2
tot_knight = 2
tot_pawn = 8
print(tot_king - king, tot_queen-queen, tot_look - look, tot_bishop - bishop, tot_knight - knight, tot_pawn-pawn)