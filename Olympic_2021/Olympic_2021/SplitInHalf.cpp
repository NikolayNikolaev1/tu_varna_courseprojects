#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void Input(int& input_count, vector<int>& numbers, int& sum);
void Output(int& sum, vector<int> numbers);

int SplitInHalf() {
	vector<int> numbers;
	int input_count = 0;
	int half, sum = 0;

	while (!cin.eof()) {
		cin >> input_count;
		if (input_count == 0) {
			break;
		}

		Input(input_count, numbers, sum);
		half = sum / 2;
		Output(half, numbers);

		input_count = 0;
		sum = 0;
		numbers.erase(numbers.begin(), numbers.end());
	}

	return 0;
}

void Input(int& input_count, vector<int>& numbers, int& sum) {
	int input;

	while (input_count--) {
		cin >> input;
		numbers.push_back(input);
		sum += input;
	}
}


void Output(int& half, vector<int> numbers) {
	int output = 0;

	sort(numbers.begin(), numbers.end(), greater<int>());

	int counter = 0;

	for (int current_num : numbers) {
		output += current_num;

		if (output > half) {
			output -= current_num;
			counter++;
		}
	}

	if (counter == numbers.size() - 1 &&
		numbers.size() - 1 > 2) {
		// Check if only the first element is in the output.
		// Do the algorithm again while skipping the first element(biggest).
		numbers.erase(numbers.begin());
		Output(half, numbers);
	}
	else {
		cout << output << endl;
	}

}
