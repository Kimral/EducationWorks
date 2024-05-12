#include "SValue.h"

SValue::SValue(const std::string& value) :
	value_{value} {
	if (!(sign_ = (value_[0] != '-')))
		value_.erase(value_.begin());
}

void SValue::Swap(SValue& first, SValue& second) {
	std::swap(first.value_, second.value_);
	std::swap(first.sign_, second.sign_);
}
