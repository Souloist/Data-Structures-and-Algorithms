'''
bubbleSort sorts an array by iterating through and swapping consecutive pairs of numbers if they are out of over.
This algorithm will take O(n^2) time and O(n) space.
'''

def bubble_sort(array):

    for i in reversed(range(len(array))):

        swaps = 0

        for j in range(i):
            if array[j] > array[j+1]:
                array[j], array[j+1] = array[j+1], array[j]
                swaps += 1

        if swaps == 0:
                return
