class Deque:

    # Back of array is front of line
    def __init__(self):
        self.line = []

    def addFront(self,item):
        self.line.append(item)

    def removeFront(self):
        self.line.pop()

    def addRear(self,item):
        self.line.insert(0,item)

    def removeRear(self):
        self.line = self.line[1::]

    def isEmpty(self):
        return len(self.line) == 0

    def size(self):
        return len(self.line)

# testing

line = Deque()
print line.isEmpty()
line.addRear("Fred")
line.addRear("Richard")
print line.line
line.addFront("Eric")
line.addFront("Steph")
print line.line
print line.size()
line.removeFront()
print line.line
line.removeRear()
print line.line
