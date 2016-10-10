'''
Performs binary search an an array and returns False if the
number does not exist in the array, otherwise, it returns the
index of the number

Created by Richard Shen
'''

def binary_search(value, array, min, max):

    mid = (min+max)/2

    if array[mid] != value and (max-min) < 2:
        return False

    if (value < array[mid]):
        return binary_search(value, array, min, mid - 1)
    elif (value > array[mid]):
        return binary_search(value, array, mid + 1, max)
    else:
        return mid

# test
array = [1, 3, 25, 223, 500, 21341, 29410]

print binary_search(25, array, 0, 7)
print binary_search(24, array, 0, 7)
