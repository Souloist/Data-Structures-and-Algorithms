from __future__ import absolute_import

import unittest

from dp import (
    fibonacci
)

class TestDp(unittest.TestCase):

    def test_fibonacci(self):
        fib = fibonacci(5)
        self.assertEqual(
            fib,
            5
        )

