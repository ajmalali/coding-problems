# Author: Ajmal Ali
from random import randint


def init(array_size, values_range):
    array = []
    for i in range(array_size):
        array.append(randint(0, values_range))

    return array


def products(array):
    # Products of every element before ith element
    prefixes = [array[0]]
    for num in array[1:]:
        prefixes.append(prefixes[-1] * num)

    # Products of every element after ith element
    suffixes = [array[-1]]
    for num in reversed(array[:-1]):
        suffixes.insert(0, suffixes[0] * num)

    # Result = products before ith element * products after ith element
    result = []
    for i in range(len(array)):
        if i == 0:
            result.append(suffixes[i + 1])
        elif i == len(array) - 1:
            result.append(prefixes[i - 1])
        else:
            result.append(prefixes[i - 1] * suffixes[i + 1])

    return result


array = init(5, 10)
print array
print products(array)
