# 1

# Даны положительные числа A и B (A > B).
# На отрезке длины A размещено максимально возможное количество отрезков длины
# B (без наложений). Не используя операции умножения и деления, найти длину незанятой части отрезка A.

import random
A = random.randrange(50,100)
B = random.randrange(1,A)
print('A = ', A)
print('B = ', B)
r = A - B
while r >= B:
    r -= B
print("Остаток: ", r)

# 2

# Даны положительные числа A и B (A > B). На отрезке длины A размещено максимально возможное количество отрезков длины B (без наложений). Не используя операции умножения и деления, найти количество
# отрезков B, размещенных на отрезке A.

import random

A = random.randrange(50, 100)
B = random.randrange(1, A)
print('A = ', A)
print('B = ', B)
r = A - B
n = 1
while r >= B:
    r -= B
    n += 1
print("Количество размещений B в A: ", n)
print("Остаток: ", r)


# 3

# Даны целые положительные числа N и K. Используя только операции
# сложения и вычитания, найти частное от деления нацело N на K, а также
# остаток от этого деления.

import random

N = random.randrange(1, 99)
K = random.randrange(1, 99)
print('N = ', N)
print('K = ', K)
r = N
q = 0
while r >= K:
    r -= K
    q += 1
print("Частное: ", q)
print("Остаток: ", r)


# 4

# Дано целое число N (> 0). Если оно является степенью числа 3, то
# вывести TRUE, если не является — вывести FALSE.

import random

N = random.randrange(1,1000)
N = 81
print('N = ', N)
while N >= 3:
    N /= 3
print("Является степенью 3: ", (N == 1))


# 5

# Дано целое число N (> 0), являющееся некоторой степенью числа 2:
# N = 2K. Найти целое число K — показатель этой степени.

import random

K = random.randrange(1, 30)
N = 2 ** K
print('K = ', K)
print('N = ', N)
K_new = 0
while N >= 2:
    N /= 2
    K_new += 1
print("K = ", K_new)