import sys

heap = []


def max_heap(k):
    if k == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heap[0])
            heap[0] = heap[-1]
            heap.pop()
            max_i = 0
            while True:
                left_child = 2 * max_i + 1
                right_child = 2 * max_i + 2
                largest = max_i

                if left_child < len(heap) and heap[left_child] > heap[largest]:
                    largest = left_child

                if right_child < len(heap) and heap[right_child] > heap[largest]:
                    largest = right_child

                if largest == max_i:
                    break

                heap[max_i], heap[largest] = heap[largest], heap[max_i]
                max_i = largest

    else:
        heap.append(k)
        last = len(heap) - 1
        while last > 0:
            parent = (last - 1) // 2
            if heap[last] > heap[parent]:
                heap[last], heap[parent] = heap[parent], heap[last]
                last = parent
            else:
                break


n = int(sys.stdin.readline())
for i in range(n):
    num = sys.stdin.readline()
    max_heap(int(num))
