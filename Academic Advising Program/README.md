# Academic Advising Program for ABCU

## Overview

This project was developed as part of my coursework in data structures and algorithms. The goal was to design and implement a command-line advising assistance program for a university’s Computer Science department. The program reads course data from a file, organizes it using an efficient data structure, and allows users to view a sorted list of courses or retrieve detailed course information, including prerequisites.

## How did I approach the problem?
To approach this problem, I evaluated several data structures, including vectors, hash tables, and binary search trees, to determine which would best meet the program’s requirements. I ultimately selected a binary search tree because it provides efficient search performance while maintaining data in sorted order without requiring additional sorting. This decision highlighted the importance of understanding data structures and their trade-offs, as each structure offers different strengths depending on the problem. By designing the program around a binary search tree, I was able to efficiently insert, search, and display course data using in-order traversal.

## How did I overcome challenges?
Throughout the project, I encountered several challenges that required careful debugging and problem-solving. One of the main issues involved handling user input, particularly when reading file names that contained spaces, which required switching to `getline()` and properly managing the input buffer. Another challenge was parsing the CSV file and validating prerequisite relationships, where trailing commas and hidden characters caused incorrect data processing. I addressed these issues by cleaning input tokens and adding validation checks. I also improved the program by ensuring that prerequisite courses displayed both their course number and title by searching the binary search tree for each prerequisite, which enhanced the usability of the program.

## How did this project expand my approach to software design?
This project expanded my approach to software design by reinforcing the importance of planning before coding. I learned to think more critically about selecting appropriate data structures based on performance requirements and how those decisions impact the overall efficiency of a program. It also helped me understand how to break down a problem into smaller, manageable components, such as file parsing, data storage, and user interaction, which made the development process more structured and effective.

## How has my programming improved?
Working on this project has improved how I write maintainable, readable, and adaptable code. I focused on using clear naming conventions, organizing code into logical functions, and adding comments to improve readability. I also incorporated input validation and error handling to make the program more robust. Additionally, implementing memory cleanup reinforced the importance of responsible resource management. Overall, this project helped me develop better coding habits and a more thoughtful approach to building scalable and maintainable software.
