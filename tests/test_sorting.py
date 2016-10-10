import os, sys
sys.path.append(os.path.join(os.getcwd(), os.path.pardir))

import unittest

from sorting import (
    bubble_sort,
    quick_sort,
)

class TestSorting(unittest.TestCase):

    def setUp(self):
        self.unsorted_array = [0, 9, 2, 5, 6, 8]
        self.sorted_array = [0, 2, 5, 6, 8, 9]

    def test_selection_sort(self):
        pass

    def test_insertion_sort(self):
        pass

    def test_bubble_sort(self):
        bubble_sort(self.unsorted_array)
        self.assertEqual(
            self.unsorted_array,
            self.sorted_array,
        )

    def test_merge_sort(self):
        pass

    def test_quick_sort(self):
        self.assertEqual(
            quick_sort(self.unsorted_array),
            self.sorted_array,
        )

    def test_heap_sort(self):
        pass

if __name__ == '__main__':
    unittest.main()
