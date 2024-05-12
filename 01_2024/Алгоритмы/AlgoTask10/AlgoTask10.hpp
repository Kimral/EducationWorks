#pragma once

#include <stdint.h>
#include <vector>
#include <algorithm>
#include <iostream>
#include <array>
#include <functional>

#include "sorting_algoritms.hpp"

struct Args {
    uint32_t n{ 0 };
    uint32_t k{ 0 };
    uint32_t m{ 0 };
    uint32_t l{ 0 };
};

double CountTime(const std::string& label, std::function<void()> func) {
    clock_t start, end;
    start = clock();
    func();
    end = clock();
    double time = double(end - start) / double(CLOCKS_PER_SEC);
    #if true // log enable
        std::cout << label << ": " << time << std::endl;
    #endif
    return time;
}

Args GetArgs() {
    Args args;
    std::cin >> args.n >> args.k >> args.m >> args.l;
    return args;
}

void CreateValuesVector(std::vector<unsigned int>& values, const Args& args) {
    CountTime("Gen data", [&]() {
        /*
        values.reserve(args.n);
        values.push_back(args.k);
        for (int i = 0; i < args.n - 1; ++i)
            values.push_back((unsigned int)((values[i] * (unsigned long long)args.m) & 0xFFFFFFFFU) % args.l);
        */

        values.resize(args.n);
        values[0] = args.k;
        for (int i = 0; i < args.n - 1; ++i)
            values[i + 1] = (unsigned int)((values[i] * (unsigned long long)args.m) & 0xFFFFFFFFU) % args.l;
    });
}

void SortValuesVector(std::vector<unsigned int>& values) {
    CountTime("Sort Data", [&]() {
        //countingSort(values);
        //std::sort(values.begin(), values.end());
        //blockSort(values, 500000);
        radixSort(values);
    });
}

uint32_t GetOddsSum(const std::vector<unsigned int>& values, const Args& args) {
    uint32_t sum{};
    CountTime("Get sum", [&]() {
        bool is_odd = true;
        for (auto value : values) {
            if (is_odd)
                sum += value;
            is_odd = !is_odd;
        }
        sum %= args.l;
    });
    return sum;
}

uint32_t DoTask(const Args& args) {
    uint32_t sum;
    CountTime("Total task time", [&]() {
        std::vector<unsigned int> values;
        CreateValuesVector(values, args);
        CountTime("Total (no gen) task time", [&]() {
            SortValuesVector(values);
            sum = GetOddsSum(values, args);
        });
    });
    return sum;
 }