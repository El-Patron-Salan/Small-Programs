num = 600851475143

def primeNumb(x):
    i = 2
    while i * i <= x:
        if x % i:
            i += 1
        else:
            x //= i
    return x

print "Prime number is: ",(primeNumb(num))
