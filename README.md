# CareerNest — Backend Development Project

CareerNest is a backend-focused full stack development project built from scratch as part of an intensive learning journey to become an industry-ready Full Stack Software Developer.

The project simulates a career platform where Students and Recruiters can be managed through a structured backend system.

This repository documents the complete development progress, feature implementations, and backend architecture evolution.

---

## Tech Stack

Language: Java
Concepts: OOP, Collections, File Handling, Serialization
Architecture: Layered (Model → Service → App)
Storage: File System (Persistent)
Version Control: Git & GitHub

---

## Project Structure

CareerNest
│
├── src
│   ├── app        → Main execution layer
│   ├── model      → Entity classes
│   └── service    → Business logic
│
├── users.dat      → Persistent storage file
└── README.md

---

## Features Implemented

* Add Student
* Add Recruiter
* View All Users
* Search User by ID
* Delete User
* Update Email
* Email Validation
* Unique ID Validation
* Persistent Storage
* Object Serialization

---

# Development Progress Log

---

## Day 1 — Project Initialization

* Created CareerNest repository
* Designed project folder structure
* Set up Java package architecture (app, model, service)
* Implemented initial Main class

Concepts Learned:
Project structuring, Git initialization, Package design

---

## Day 2 — OOP Foundations

Created core entity models:

* User (Base class)
* Student (extends User)
* Recruiter (extends User)

Implemented constructors, fields, access modifiers, and displayInfo() method.

Concepts Learned:
Inheritance, Encapsulation, Class hierarchy design

---

## Day 3 — Service Layer Creation

Introduced business logic layer:

* Created UserService
* Added user storage (array-based)
* Implemented addUser() and displayAllUsers()

Concepts Learned:
Separation of concerns, Service architecture

---

## Day 4 — Menu Driven System

Enhanced console interaction:

* Built loop-driven menu
* Added user input handling
* Integrated service calls

Concepts Learned:
CLI system design, Scanner usage, Flow control

---

## Day 5 — Validation Layer

Implemented data validation:

* Unique ID check
* Email format validation

Concepts Learned:
Input validation, Data integrity enforcement

---

## Day 6 — Dynamic Input System

Upgraded system to accept runtime user data for Student and Recruiter creation.
Removed hardcoded values.

Concepts Learned:
Dynamic object creation, Real-time input processing

---

## Day 7 — Search Functionality

Added user lookup feature:

* Search user by ID
* Display matched records

Concepts Learned:
Linear search, Data traversal

---

## Day 8 — Delete Functionality

Implemented deletion logic:

* Remove user by ID
* Array element shifting

Concepts Learned:
Memory shifting, Data removal handling

---

## Day 9 — Update Operations

Added update feature:

* Update user email
* Integrated validation
* Introduced setter methods

Concepts Learned:
Encapsulation enforcement, Controlled data modification

---

## Day 10 — Storage Upgrade

Refactored backend storage from fixed array to dynamic ArrayList<User>.

Removed fixed size limitations, manual shifting, and count tracking.

Concepts Learned:
Java Collections Framework, Dynamic storage design

---

## Day 11 — File Persistence

Implemented file handling:

* Created users.txt
* Saved users to file
* Loaded users on system start

Concepts Learned:
BufferedWriter, BufferedReader, File I/O operations

---

## Day 12 — Object Persistence (Serialization)

Upgraded storage from text-based persistence to object-based persistence.

Implemented:

* Serializable model
* Binary storage (users.dat)
* ObjectOutputStream
* ObjectInputStream
* Full system state recovery

Now users persist even after system restart.

Concepts Learned:
Serialization, Deserialization, Binary file storage, Persistent backend systems

---

# Current Backend Capabilities

* Layered architecture
* OOP entity modeling
* Dynamic storage
* CRUD operations
* Validation system
* File persistence
* Object serialization

---

# Upcoming Enhancements

* Exception handling framework
* Logging system
* REST API integration
* Database connectivity
* Authentication system
* Frontend integration

---

# Author

Sakshi Sreenivas
Information Science Engineering Student
Aspiring Backend-Focused Full Stack Developer
