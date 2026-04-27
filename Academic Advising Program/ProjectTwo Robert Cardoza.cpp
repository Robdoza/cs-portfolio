#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

//Courses structure
struct Course {
	string courseNumber;
	string courseTitle;
	vector <string> prerequisites;
};

struct Node {
	Course course;
	Node* left;
	Node* right;

	Node(Course c) {
		course = c;
		left = nullptr;
		right = nullptr;
	}
};

//Insert function
Node* insertNode(Node* root, Course course) {
	if (root == nullptr) {
		return new Node(course);
	}

	if (course.courseNumber < root->course.courseNumber) {
		root->left = insertNode(root->left, course);
	}
	else {
		root->right = insertNode(root->right, course);
	}

	return root;
}

//Search function
Course* searchCourse(Node* root, string courseNumber) {
	if (root == nullptr) {
		return nullptr;
	}

	if (root->course.courseNumber == courseNumber) {
		return &root->course;
	}

	if (courseNumber < root->course.courseNumber) {
		return searchCourse(root->left, courseNumber);
	}
	else {
		return searchCourse(root->right, courseNumber);
	}
}

//Print All Courses
void printInOrder(Node* root) {
	if (root == nullptr) return;

	printInOrder(root->left);
	cout << root->course.courseNumber << ", "
		<< root->course.courseTitle << endl;
	printInOrder(root->right);
}

void deleteTree(Node* root) {
	if (root == nullptr) return;

	deleteTree(root->left);
	deleteTree(root->right);
	delete root;
}

//Load Files
void loadCourses(string fileName, Node*& root) {
	ifstream file(fileName);

	if (!file.is_open()) {
		cout << "Error opening file." << endl;
		return;
	}

	vector<string> courseNumbers;
	string line;

	//Collect course numbers
	while (getline(file, line)) {
		stringstream ss(line);
		string token;
		getline(ss, token, ',');
		courseNumbers.push_back(token);
	}

	file.clear();
	file.seekg(0);

	//Build courses
	while (getline(file, line)) {
		stringstream ss(line);
		vector<string> tokens;
		string token;

		while (getline(ss, token, ',')) {
			tokens.push_back(token);
		}

		if (tokens.size() < 2) {
			cout << "Invalid line format." << endl;
			continue;
		}

		Course course;
		course.courseNumber = tokens[0];
		course.courseTitle = tokens[1];

		for (int i = 2; i < tokens.size(); i++) {
			// skip empty tokens

			if (tokens[i].empty()) {
				continue;
			}

			tokens[i].erase(remove(tokens[i].begin(), tokens[i].end(), '\r'), tokens[i].end());

			if (find(courseNumbers.begin(), courseNumbers.end(), tokens[i]) == courseNumbers.end()) {
				cout << "Invalid prerequisite: " << tokens[i] << endl;
				continue;
			}

			course.prerequisites.push_back(tokens[i]);
		}

		root = insertNode(root, course);
	}

	file.close();
	cout << "Courses loaded successfully." << endl;
}

//Print one course
void printCourse(Node* root, Course* course) {
	if (course == nullptr) {
		cout << "Course not found." << endl;
	}

	cout << course->courseNumber << ", "
		<< course->courseTitle << endl;

	//if no prerequisites
	if (course->prerequisites.empty()) {
		cout << "Prerequisites: None" << endl;
		return;
	}

	cout << "Prerequisites:" << endl;

	//Print prerequisites with their titles
	for (string prereq : course->prerequisites) {
		Course* prereqCourse = searchCourse(root, prereq);

		if (prereqCourse != nullptr) {
			cout << prereqCourse->courseNumber << ", "
				<< prereqCourse->courseTitle << endl;
		}
		else {
			cout << prereq << " (not found)" << endl;
		}
	}
}

int main() {
	Node* root = nullptr;
	int choice;
	string fileName;
	string courseNumber;
	bool dataLoaded = false;

	cout << "Welcome to the ABCU course planner!" << endl;

	do {
		cout << "\n1. Load Data Structure." << endl;
		cout << "2. Print Course List." << endl;
		cout << "3. Print Course." << endl;
		cout << "9. Exit" << endl;
		cout << "WHat would you like to do? ";
		cin >> choice;

		if (cin.fail()) {
			cin.clear();
			cin.ignore(numeric_limits<streamsize>::max(), '\n');
			choice = 0;
		}

		switch (choice) {
		case 1:
			cout << "Enter file name: ";
			cin.ignore(numeric_limits<streamsize>::max(), '\n');
			getline(cin, fileName);
			loadCourses(fileName, root);
			dataLoaded = true;
			break;

		case 2:
			if (!dataLoaded) {
				cout << "Please load data first." << endl;
			}

			cout << "Here is the sample schedule:" << endl;
			printInOrder(root);
			break;

		case 3:
			if (!dataLoaded) {
				cout << "Please load data first." << endl;
			}

			cout << "What course do you want to know more about?";
			cin >> courseNumber;

			transform(courseNumber.begin(), courseNumber.end(), courseNumber.begin(), ::toupper);

			printCourse(root, searchCourse(root, courseNumber));
			break;

		case 9:
			cout << "Thank you for using the ABCU course planer!" << endl;
			break;

		default:
			cout << choice << " is not a valid option." << endl;
		}
	} while (choice != 9);

	deleteTree(root);
	return 0;
}