def fibonacci(num):
    fib = {}
    for i in range(1, num+1):
        if i <= 2:
            f = 1
        else:
            f = fib[i-1] + fib[i-2]
        fib[i] = f
    return fib[num]

