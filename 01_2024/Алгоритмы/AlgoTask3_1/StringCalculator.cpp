#include "StringCalculator.h"
#include <iostream>

Expression::Expression(std::string& first, char action, std::string& second) :
	first_{ first },
	second_{ second },
	action_{ static_cast<Action>(action) }
 {
	if (action_ == Action::Subtraction) {
		action_ = Action::Addition;
		second_.set_sign(!second_.sign());
	}

	was_swapped = Reorder(first_, second_);
	result_sign = GetResultSign();

	if (first_.sign() == false) {
		first_.set_sign(!first_.sign());
		action_ = action_ == Action::Addition ? Action::Subtraction : Action::Addition;
	}

	if (second_.sign() == false) {
		second_.set_sign(!second_.sign());
		action_ = action_ == Action::Addition ? Action::Subtraction : Action::Addition;
	}
}

std::string Expression::LogState() const {
	std::stringstream out;
	out << first_.to_str() << " "
		<< static_cast<char>(action_) << " "
		<< second_.to_str();
	return out.str();
}

std::string Expression::Exec() const {
	if (action_ == Action::Addition) {
		return ExecAddition();
	}
	return ExecSubtraction();
}

std::string Expression::ExecAddition() const {
	std::string local_first = first_.value();
	std::string local_second = second_.value();
	std::reverse(local_first.begin(), local_first.end());
	std::reverse(local_second.begin(), local_second.end());

	int overhead = 0;
	std::string result;
	for (size_t i = 0; i < local_first.size(); i++) {
		int first{}, second{};
		first = local_first[i] - '0';
		if (i < local_second.size())
			second = local_second[i] - '0';

		int temp_res = first + second + overhead;
		result.push_back((temp_res % 10) + '0');
		overhead = temp_res / 10;
	}
	if (overhead)
		result.push_back(overhead + '0');
	if (result_sign == Action::Subtraction)
		result.push_back('-');

	std::reverse(result.begin(), result.end());
	return result;
}

std::string Expression::ExecSubtraction() const {
	if (first_.value() == second_.value()) {
		return "0";
	}

	std::string local_first = first_.value();
	std::string local_second = second_.value();
	std::reverse(local_first.begin(), local_first.end());
	std::reverse(local_second.begin(), local_second.end());

	int carry = 0;
	std::string result;
	for (size_t i = 0; i < local_first.size(); ++i) {
		int first{}, second{};
		first = local_first[i] - '0';
		if (i < local_second.size())
			second = local_second[i] - '0';

		int temp_res = first - second - carry;
		carry = (temp_res < 0);
		if (carry) {
			temp_res += 10;
		}
		result.push_back(temp_res + '0');
	}

	std::reverse(result.begin(), result.end());
	auto iter = std::find_if(result.begin(), result.end(), [](char symbol) {
		return symbol != '0';
	});
	if (iter != result.end())
		result.erase(result.begin(), iter);

	if (result_sign == Action::Subtraction)
		result = "-" + result;

	return result;
}

bool Expression::Reorder(SValue& first, SValue& second) {
	if (second.value().size() > first.value().size()) {
		SValue::Swap(first, second);
		return true;
	}
	else if (first.value().size() == second.value().size()) {
		if (second.value() > first.value()) {
			SValue::Swap(first, second);
			return true;
		}
	}
	return false;
}

Expression::Action Expression::GetResultSign() const {
	return first_.sign() ? Action::Addition : Action::Subtraction;
}
