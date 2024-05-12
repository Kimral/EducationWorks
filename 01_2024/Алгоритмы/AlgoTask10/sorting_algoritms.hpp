#pragma once

#include <vector>
#include <execution>

void countingSort(std::vector<unsigned int>& array) {
    // Находим максимальное значение в массиве для определения размера вспомогательного массива
    unsigned int maxVal = *max_element(array.begin(), array.end());

    // Создаем вспомогательный массив для подсчёта
    std::vector<unsigned int> count(maxVal + 1, 0);

    // Считаем количество вхождений каждого элемента
    for (unsigned int num : array) {
        count[num]++;
    }

    // Заполняем исходный массив отсортированными значениями
    size_t index = 0;
    for (size_t i = 0; i < count.size(); ++i) {
        while (count[i] > 0) {
            array[index++] = i;
            count[i]--;
        }
    }
}

void blockSort(std::vector<unsigned int>& arr, int blockSize) {
    std::vector<std::vector<unsigned int>> blocks;
    // Деление входного массива на блоки размером blockSize
    for (int i = 0; i < arr.size(); i += blockSize) {
        std::vector<unsigned int> block;
        for (int j = i; j < i + blockSize && j < arr.size(); j++) {
            block.push_back(arr[j]);
        }
        // Сортировка каждого блока и добавление его в список отсортированных блоков
        std::sort(std::execution::par, block.begin(), block.end());

        blocks.insert(blocks.end(), block.begin(), block.end());
    }
    // Слияние отсортированных блоков в один отсортированный список
    std::vector<unsigned int> result;
    while (!blocks.empty()) {
        // Нахождение наименьшего элемента в первом блоке каждого отсортированного блока
        int minIdx = 0;
        for (int i = 1; i < blocks.size(); i++) {
            if (blocks[i][0] < blocks[minIdx][0]) {
                minIdx = i;
            }
        }
        // Удаление наименьшего элемента и добавление его в результат
        result.push_back(blocks[minIdx][0]);
        blocks[minIdx].erase(blocks[minIdx].begin());
        // Если блок стал пустым, удаляем его из списка отсортированных блоков
        if (blocks[minIdx].empty()) {
            blocks.erase(blocks.begin() + minIdx);
        }
    }
    arr = result;
}

// Функция подсчета сортировки для одного разряда
void countSort(std::vector<unsigned int>& arr, unsigned int exp, std::vector<unsigned int>& output, std::array<unsigned int, 10>& count) {
    int n = arr.size();
    for (auto& value : count)
        value = 0;

    // Подсчет вхождений каждой цифры
    for (int i = 0; i < n; ++i)
        count[(arr[i] / exp) % 10]++;

    // Обновление значений в массиве count, чтобы они представляли индексы для размещения элементов в отсортированном массиве
    for (int i = 1; i < 10; ++i)
        count[i] += count[i - 1];

    // Размещение элементов в отсортированном массиве
    for (int i = n - 1; i >= 0; --i) {

        unsigned int value = (arr[i] / exp) % 10;
        output[count[value] - 1] = arr[i];
        count[value]--;
    }

    // Копирование отсортированных элементов обратно в исходный массив
    arr.swap(output);
}

// Функция Radix Sort
void radixSort(std::vector<unsigned int>& arr) {
    // Находим максимальное число в массиве для определения количества разрядов
    unsigned int maxVal = *std::max_element(arr.begin(), arr.end());

    // Выполняем countSort для каждого разряда
    std::array<unsigned int, 10> count{};
    std::vector<unsigned int> output(arr.size());
    for (unsigned int exp = 1; maxVal / exp > 0; exp *= 10)
        countSort(arr, exp, output, count);
}