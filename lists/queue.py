class Queue:

	# List can be used for queue. The back of the array is the front of the queue.
	def __init__(self):
		self.line = []

	def isEmpty(self):
		return len(self.line)==0

	def enqueue(self,item):
		self.line.insert(0,item)

	def dequeue(self):
		self.line.pop()

	def size(self):
		return len(self.line)

line = Queue()
print line.isEmpty()
line.enqueue("Richard")
line.enqueue("Fred")
print line.line
print line.size()
line.dequeue()
print line.line	
