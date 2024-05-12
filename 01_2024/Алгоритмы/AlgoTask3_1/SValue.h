#pragma once

#include <string>

class SValue {
public:
	SValue(const std::string& value);

	static void Swap(SValue& first, SValue& second);

	std::string value() const {
		return value_;
	}

	bool sign() const {
		return sign_;
	}

	void set_sign(bool sign) {
		sign_ = sign;
	}

	std::string to_str() const {
		return (sign_ ? "" : "-" )+ value_;
	}

private:
	bool sign_;
	std::string value_;
};