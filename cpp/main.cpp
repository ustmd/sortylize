#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>

using namespace std;

// Пузырьковая сортировка
void bubbleSort(vector<int>& arr) {
    int n = arr.size();

    for (int i = 0; i < n; i++) {
        bool swapped = false;

        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
                swapped = true;
            }
        }

        // Если обменов не было — массив отсортирован
        if (!swapped) {
            break;
        }
    }
}

int main() {
    vector<int> numbers;

    // Открываем файл
    ifstream file("numbers.txt");

    if (!file.is_open()) {
        cout << "Не удалось открыть файл!" << endl;
        return 1;
    }

    int number;

    // Читаем числа из файла
    while (file >> number) {
        numbers.push_back(number);
    }

    file.close();

    cout << "Считано элементов: " << numbers.size() << endl;

    // Замер времени
    auto start = chrono::high_resolution_clock::now();

    bubbleSort(numbers);

    auto end = chrono::high_resolution_clock::now();

    chrono::duration<double> duration = end - start;

    cout << "Время выполнения сортировки: "
         << duration.count()
         << " секунд" << endl;

    return 0;
}