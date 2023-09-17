import sys

heap = []


def min_heap(k):
    if k == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heap[0])
            heap[0] = heap[-1]
            heap.pop()
            min_i = 0
            while True:
                left_child = 2 * min_i + 1
                right_child = 2 * min_i + 2
                smallest = min_i

                if left_child < len(heap) and heap[left_child] < heap[smallest]:
                    smallest = left_child

                if right_child < len(heap) and heap[right_child] < heap[smallest]:
                    smallest = right_child

                if smallest == min_i:
                    break

                heap[min_i], heap[smallest] = heap[smallest], heap[min_i]
                min_i = smallest

    else:
        heap.append(k)
        last = len(heap) - 1
        while last > 0:
            parent = (last - 1) // 2
            if heap[last] < heap[parent]:
                heap[last], heap[parent] = heap[parent], heap[last]
                last = parent
            else:
                break


n = int(sys.stdin.readline())
for i in range(n):
    num = sys.stdin.readline()
    min_heap(int(num))
