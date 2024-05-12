#pragma once

#include <cassert>
#include <iostream>
#include <random>
#include <limits>

#include "AlgoTask10.hpp"


void RunTests() {
	assert(DoTask({ 5, 7, 13, 100 }) == 77);
}

void RunManyTest() {
	std::random_device rd;
	std::mt19937 gen(rd());
	std::uniform_int_distribution<uint32_t> n_dist(60000000, 60000000);
	uint32_t max = std::numeric_limits<uint32_t>::max();
	std::uniform_int_distribution<uint32_t> other_dist(0, max);

	std::vector<double> times;
	size_t count = 5;
	while (count--) {
		Args args{
			n_dist(gen),
			other_dist(gen),
			other_dist(gen),
			other_dist(gen)
		};
		std::cout <<
			"n: " << args.n << " " << 
			"m: " << args.m << " " <<
			"l: " << args.l << " " <<
			"k: " << args.k << std::endl;
		times.push_back(DoTask(args));
	}

	double average = std::accumulate(times.begin(), times.end(), 0) / 100.0;
	std::cout << "Average time: " << average << std::endl;
}