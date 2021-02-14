
import math
sal =1000000
exp=700000

sal_fix=sal
exp_fix=exp
sav= sal-exp

total_sav=300000

# pre retirement


age=25
life_exp= 85
ans=0

lo = age
hi= life_exp
while(lo<=hi ):
    retd= math.ceil((lo+hi)/2)
    print(lo,hi,retd)
    if(retd==hi):
        break
    # print(age,total_sav)
    total_sav = sal_fix-exp_fix
    sal=sal_fix
    exp=exp_fix
    
    for i in range(retd-age):
        # age=age+1
        total_sav=total_sav*1.1
        sal=sal*1.06
        exp=exp*1.06    
        total_sav=total_sav+(sal-exp)
        # print(age,round(total_sav,2))
        
    #postretirement
    
    # print("postretirement")
    for i in range(life_exp-retd):
        # age=age+1
        exp=exp*1.06
        total_sav = total_sav - exp
        total_sav=total_sav*1.1
        # print(age,int(total_sav))
    print(total_sav)
    if(total_sav>0):
        ans=retd
        hi=retd
    else:
        lo=retd 
        
print(ans,"ans")




retd = ans

total_sav = sal_fix-exp_fix
sal=sal_fix
exp=exp_fix

for i in range(retd-age):
    age=age+1
    total_sav=total_sav*1.1
    sal=sal*1.06
    exp=exp*1.06    
    total_sav=total_sav+(sal-exp)
    print(age,round(total_sav,2))
    
# postretirement

print("postretirement")
for i in range(life_exp-retd):
    age=age+1
    exp=exp*1.06
    total_sav = total_sav - exp
    total_sav=total_sav*1.1
    print(age,int(total_sav))
# print(age,total_sav)
