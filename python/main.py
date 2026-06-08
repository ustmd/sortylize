import random
import time

# Генерация массива из 100000 случайных чисел
SIZE = 100000
array = [random.randint(0, 100000) for _ in range(SIZE)]

# Сохранение в txt файл
with open("numbers.txt", "w") as file:
    file.write(" ".join(map(str, array)))

print("Массив сохранён в numbers.txt")


def bubble_sort(arr):
    n = len(arr)

    for i in range(n):
        swapped = False

        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True

        if not swapped:
            break

    return arr


# Копия массива для сортировки
arr_copy = array.copy()

# Замер времени
start_time = time.time()

bubble_sort(arr_copy)

end_time = time.time()

print(f"Время выполнения пузырьковой сортировки: {end_time - start_time:.2f} секунд")