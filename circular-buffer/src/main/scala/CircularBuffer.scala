class EmptyBufferException() extends Exception {}

class FullBufferException() extends Exception {}

class CircularBuffer(var capacity: Int) {

  private val buffer = Array.fill[Option[Int]](capacity)(None)
  private var writePointer = 0
  private var readPointer = 0
  private var size = 0

  def write(value: Int): Unit = {
    if (size == capacity) throw new FullBufferException()
    buffer(writePointer) = Some(value)
    writePointer = (writePointer + 1) % capacity
    size += 1
  }

  def read(): Int = {
    if (size == 0) throw new EmptyBufferException()
    val value = buffer(readPointer).get
    buffer(readPointer) = None
    readPointer = (readPointer + 1) % capacity
    size -= 1
    value
  }

  def overwrite(value: Int): Unit = {
    if (size == capacity) {
      buffer(readPointer) = Some(value)
      readPointer = (readPointer + 1) % capacity
    } else {
      write(value)
    }
  }

  def clear(): Unit = {
    for (i <- buffer.indices) buffer(i) = None
    writePointer = 0
    readPointer = 0
    size = 0
  }
}
