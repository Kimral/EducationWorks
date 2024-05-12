#pragma once
#include <random>
#include <cassert>
#include <iostream>
#include <limits>

#include "StringCalculator.h"

void RunTest(size_t counter) {
	std::random_device rd;
	std::mt19937 gen(rd());
	std::uniform_int_distribution<long long int> dis(
		std::numeric_limits<long long int>::min() / 2, 
		std::numeric_limits<long long int>::max() / 2);

	for (; counter; counter--) {
		long long int a = dis(gen);
		long long int b = dis(gen);

		long long int sum = a + b;
		long long int diff = a - b;

		std::string a_str = std::to_string(a);
		std::string b_str = std::to_string(b);

		Expression data_sum{ a_str, '+', b_str };
		std::string sum_res = data_sum.Exec();
		std::cout << data_sum.LogState() << " -> " << sum_res << std::endl;
		assert(data_sum.Exec() == std::to_string(sum));

		Expression data_diff{ a_str, '-', b_str };
		std::string diff_res = data_diff.Exec();
		std::cout << data_diff.LogState() << " -> " << diff_res << std::endl;
		assert(data_diff.Exec() == std::to_string(diff));
	}
}