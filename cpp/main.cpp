#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <algorithm>

using namespace std;

void bubbleSort(vector<int> &arr)
{
    size_t n = arr.size();

    for (size_t i = 0; i < n - 1; i++)
    {
        bool swapped = false;

        for (size_t j = 0; j < n - i - 1; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                swap(arr[j], arr[j + 1]);
                swapped = true;
            }
        }

        if (!swapped)
        {
            break;
        }
    }
}

int main()
{
    vector<int> numbers;

    ifstream file("numbers.txt");

    if (!file.is_open())
    {
        cout << "Не удалось открыть файл!" << endl;
        return 1;
    }

    int number;

    while (file >> number)
    {
        numbers.push_back(number);
    }

    file.close();

    cout << "Считано элементов: " << numbers.size() << endl;

    auto start = chrono::high_resolution_clock::now();

    bubbleSort(numbers);

    auto end = chrono::high_resolution_clock::now();

    chrono::duration<double> duration = end - start;

    cout << "Время выполнения сортировки: "
         << duration.count()
         << " секунд" << endl;

    return 0;
}