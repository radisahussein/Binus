def generate_n_chars(n, c):
    a = c
    for i in range(n):
        c += a
    print(c)

generate_n_chars(10, "x")