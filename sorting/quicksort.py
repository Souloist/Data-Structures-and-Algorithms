def quickSort(array):
  less = []
  equal = []
  greater = []

  if len(array) > 1:
      pivot = array[0]
      for x in array:
          if x < pivot:
              less.append(x)
          if x == pivot:
              equal.append(x)
          if x > pivot:
              greater.append(x)
      return quickSort(less)+equal+quickSort(greater)
  else:
      return array
