# 🎓 University Management System (UMS)

## 🌟 Project Overview
This project is a console-based application developed in Java to manage core administrative tasks within a university setting. It provides functionalities to manage academic entities like students, professors, and courses, with data persistence handled via file serialization.

### Motivation
The goal was to apply Object-Oriented Programming (OOP) principles, including **Abstraction**, **Inheritance**, **Polymorphism**, and **Encapsulation**, along with file handling for data persistence.

## ⚙️ Tech Stack & Key Concepts
| Category | Details |
| :--- | :--- |
| **Language** | Java |
| **Data Persistence** | Java Serialization (`.ser` file) |
| **OOP Concepts** | Abstract classes (`Person`), Inheritance (`Student`, `Professor`), Custom Exceptions (`CourseFullException`), and Enums (`EnumRole`, `EnumGrade`, `EnumSem`). |
| **Data Structure** | `ArrayList` for storing `Person` and `Course` objects. |

## ✨ Features

The system is managed via a text-based menu interface and can perform the following key operations:

* **Student Management:** Add new students with unique IDs, joining year, and major.
* **Course Enrollment:** Enroll a student into a specific course using the `Manager` service.
* **Course Capacity Check:** Automatically throws a `CourseFullException` if the enrollment exceeds the `maxCapacity` of a course.
* **View Status:** Display detailed information for any person (Student or Professor) using their ID, demonstrating polymorphism and role-specific data.
* **Data Persistence:** Data (students, professors, and courses) is automatically loaded from the `university_data.ser` file on startup and saved on exit.
* **Course Categorization:** Courses are strictly tied to an `EnumSem` (Semester 1 to 8).

## 🚀 Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites
You need to have the **Java Development Kit (JDK)** installed on your machine.

### Installation and Execution (Using Command Line)

1.  **Clone the Repository (if applicable):**
    ```bash
    git clone [Your Repository URL]
    cd 24CSE1010-OOPS-Project
    ```
2.  **Organize Files (Crucial for Packages):**
    Ensure your `src` directory is set as the source root. All Java files must be inside their respective package directories (`com/university/app`, `com/university/model`, etc.).
3.  **Compile:**
    Run the `javac` command from the root directory (the directory containing the `src` folder):
    ```bash
    javac -d . src/com/university/app/Application.java src/com/university/service/Manager.java src/com/university/model/*.java src/com/university/enums/*.java src/com/university/exceptions/*.java
    ```
    *(Note: The command above is a simplified example; you may need a build tool or a different compile command depending on your environment).*
4.  **Run:**
    Execute the main class using its fully qualified name:
    ```bash
    java com.university.app.Application
    ```

## 🛠️ Usage

Upon running, the system presents a menu:

1.  **Add New Student:** Prompts for student name, major, ID, and joining year.
2.  **Enroll Student in Course:** Requires Student ID and Course Code (e.g., CS203) to register.
3.  **View Status:** Requires a Person ID (Student or Professor) to display detailed information.
4.  **Exit (0):** Saves all data to `university_data.ser` and closes the application.

## 👥 Author

* **[Bhimireddy Tej Deep Reddy]** - Initial development
