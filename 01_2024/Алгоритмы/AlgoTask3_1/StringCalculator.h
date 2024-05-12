#pragma once

#include <string>
#include <sstream>

#include "SValue.h"

class Expression {
	enum class Action {
		None = 0,
		Addition = 43,
		Subtraction = 45
	};

public:
	Expression(std::string& first, char action, std::string& second);
	std::string LogState() const; 
	std::string Exec() const;

private:
	std::string ExecAddition() const;
	std::string ExecSubtraction() const;
	Action GetResultSign() const;
	bool Reorder(SValue& first, SValue& second);
	
private:
	SValue first_;
	SValue second_;

	Action action_{Action::None};
	Action result_sign{};
	bool was_swapped{};
};