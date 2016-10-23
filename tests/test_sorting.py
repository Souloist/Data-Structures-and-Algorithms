from __future__ import absolute_import

import unittest

from sorting import (
    selection_sort,
    insertion_sort,
    bubble_sort,
    quick_sort,
)

class TestSorting(unittest.TestCase):

    def setUp(self):
        self.unsorted_array = [0, 9, 2, 5, 6, 8]
        self.sorted_array = [0, 2, 5, 6, 8, 9]

    def test_selection_sort(self):
        selection_sort(self.unsorted_array)
        self.assertEqual(
            self.unsorted_array,
            self.sorted_array,
        )

    def test_insertion_sort(self):
        insertion_sort(self.unsorted_array)
        self.assertEqual(
            self.unsorted_array,
            self.sorted_array,
        )

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