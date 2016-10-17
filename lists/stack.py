class Stack(object):

    # Consider the "top" of the stack as the end of the array

    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        self.items.pop()

    def peek(self):
        return self.items[-1]

    def isEmpty(self):
        return self.items == []

    def size(self):
        return len(self.items)


# New stack object
testing = Stack()
print testing.isEmpty()
testing.push(1)
print testing.items
print testing.peek()
testing.pop()
print testing.items
