from __future__ import absolute_import

def selection_sort(array):
	for i in range(len(array)):
		# index of smallest element
		smallest = i

		for j in range(i+1, len(array)):
			if array[smallest] > array[j]:
				smallest = j
		
		array[i], array[smallest] = array[smallest], array[i]
		print array
	return array