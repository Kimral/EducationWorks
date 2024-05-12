#include <string>
#include <iostream>

#include "tests.h"
#include "StringCalculator.h"

int main()
{
	std::string first, second;
	char action{};
	std::cin >> first >> action >> second;

	Expression task_data{ first, action, second };

	std::cout << task_data.LogState() << std::endl;
	std::cout << "===============" << std::endl;
	std::cout << task_data.Exec() << std::endl;
	

	//RunTest(25000);
}

