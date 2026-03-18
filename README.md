# ⚽ Football Player Manager (Doubly Linked List & File I/O)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

A comprehensive Command Line Interface (CLI) application that acts as a mini database for football player records. Instead of relying on built-in Java collections, this project implements a custom **Doubly Linked List** and a custom **Stack** to manage data efficiently.

## 🛠️ Core Technologies & Features

### 1. Custom Doubly Linked List (Auto-Sorting)
- Built from scratch using a custom `Node` class with `prev` and `next` pointers.
- **Alphabetical Insertion:** Every time a new player is added, the list traverses and automatically inserts the node in the correct alphabetical order based on Name (and Surname for duplicates).
- **Bidirectional Traversal:** Capable of printing the database from A-Z (using `head`) and Z-A (using `tail`).

### 2. File I/O (Data Persistence)
- **Reading:** Parses data from `players.txt`, securely handling string splitting and date conversions using a custom `Date` class.
- **Writing:** Saves the current state of the linked list back into a text file (`players_temp.txt`) before exiting, ensuring no data loss.

### 3. Custom Stack Implementation
- Includes a utility to deep-copy the current linked list into a custom Stack architecture, demonstrating **LIFO (Last-In-First-Out)** operations by popping and printing the records.

### 4. Full CRUD Operations
- **C**reate: Add new players via console.
- **R**ead: Search and print specific players by name/surname.
- **U**pdate/Sort: Maintains sorted state automatically.
- **D**elete: Securely removes nodes by re-linking `prev` and `next` pointers.

## 🚀 How to Run
1. Compile the package: `javac application/*.java`
2. Run the main app: `java application.Application`
3. Follow the interactive menu to load files, add records, or traverse the list.
