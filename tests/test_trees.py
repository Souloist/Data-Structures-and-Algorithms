from __future__ import absolute_import

import unittest

from trees import (
    BinarySearchTree
)

class TestSorting(unittest.TestCase):

    def setUp(self):
        pass

    def test_selection_sort(self):
        bst = BinarySearchTree()
        bst[3] = "richard"
        bst[4] = "shen"
        bst[1] = "should"
        bst[2] = "sleep"
