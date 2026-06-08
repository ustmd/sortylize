package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"time"
)

// Пузырьковая сортировка
func bubbleSort(arr []int) {
	n := len(arr)

	for i := 0; i < n; i++ {
		swapped := false

		for j := 0; j < n-i-1; j++ {
			if arr[j] > arr[j+1] {
				arr[j], arr[j+1] = arr[j+1], arr[j]
				swapped = true
			}
		}

		// Если обменов не было — массив уже отсортирован
		if !swapped {
			break
		}
	}
}

func main() {
	file, err := os.Open("numbers.txt")
	if err != nil {
		fmt.Println("Не удалось открыть файл:", err)
		return
	}
	defer file.Close()

	var numbers []int

	scanner := bufio.NewScanner(file)

	// Scanner читает построчно, поэтому увеличим буфер
	scanner.Split(bufio.ScanWords)

	for scanner.Scan() {
		num, err := strconv.Atoi(scanner.Text())
		if err != nil {
			fmt.Println("Ошибка чтения числа:", err)
			return
		}

		numbers = append(numbers, num)
	}

	if err := scanner.Err(); err != nil {
		fmt.Println("Ошибка чтения файла:", err)
		return
	}

	fmt.Println("Считано элементов:", len(numbers))

	// Замер времени
	start := time.Now()

	bubbleSort(numbers)

	elapsed := time.Since(start)

	fmt.Printf("Время выполнения сортировки: %v\n", elapsed)
}
