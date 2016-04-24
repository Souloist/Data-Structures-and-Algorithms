''' 
bubbleSort sorts an array by iterating through and swapping consecutive pairs of numbers if they are out of over.
This algorithm will take O(n^2) time and O(n) space.
'''

def bubbleSort(array):

 	for i in reversed(range(len(array))):
 		
 		swaps = 0
		
		for j in range(i):
			if array[j] > array[j+1]:
				temp = array[j+1]
				array[j+1] = array[j]
				array[j] = temp
				swaps += 1
		
		if swaps == 0:
			return


# test
array = [1, 2, 3, 6, 3,2, 6, 3, 2, 1]

print "Unsorted: " + str(array)

bubbleSort(array)

print "Sorted:   " + str(array)