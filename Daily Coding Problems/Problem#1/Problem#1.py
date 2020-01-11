# Author: Ajmal Ali

from random import randint

# Generates random list and k value
def init(list_size, values_range):
    list = []
    for i in range(list_size):
        list.append(randint(0, values_range+1))

    k = randint(0, values_range+1)

    return (list, k)


def two_sum(list, k):
    to_find = set() # Set of numbers we need to find (k - num)
    for num in list:
        if num in to_find:
            return True

        to_find.add(k - num) # Add the number we need to find

    return False


list_size = 10
values_range = 15
list, k = init(list_size, values_range)

print "List: {}".format(list)
print "k: {}".format(k)

print two_sum(list, k)
