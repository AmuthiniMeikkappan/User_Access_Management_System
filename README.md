## User_Access_Management_System
# Project Overview
This project is a User Access Management System with role-based access for managing software requests within an organization. It is designed with three distinct  roles: Employee, Manager, and Admin, each having specific responsibilities:

Employee : Requests software applications.
Manager: Reviews and approves or rejects software requests.
Admin: Manages the software inventory by creating and updating available software options.
The system has been implemented using JSP, Java Servlets, and SQL, providing a robust backend for data handling and role management, with a simple frontend interface for easy navigation and usage.

# Features
Role-Based Access Control

Role-based permissions allow access to specific pages and functionalities based on the user's role.
Login and Signup

Users can register and log in securely. Sessions are maintained to ensure only logged-in users access restricted pages.
Software Request System

Employees can request software, and managers can view and manage these requests with options to approve or reject them.
Software Management

Admins can add or modify software details within the system to keep the application list up-to-date.
Technologies Used
Frontend: HTML, CSS, JSP
Backend: Java Servlets
Database: SQL (for user information, software details, and request status)
Installation and Setup
Clone the Repository:

bash
Copy code
git clone <repository-url>
Database Setup:

Create a SQL database and import the provided SQL file (schema.sql).
Configure the database connection details in the dbConfig file.
Run the Application:

Deploy the application on a servlet container (e.g., Apache Tomcat).
Access the application via http://localhost:<port>/UserAccessManagementSystem.
Usage
Signup: Register with a role (Employee, Manager, or Admin).
Login: Access your dashboard based on your assigned role.
Employee Portal:
Request software by selecting from available options.
Manager Portal:
Review pending requests and approve or reject as necessary.
Admin Portal:
Add or update software details.

# Directory Structure
|-- src
|   |-- servlet       # Java Servlet files
|   |-- model         # Database models and helper classes
|   |-- view          # JSP pages (login, signup, dashboards)
|-- web               # Web resources (CSS, JS, images)
|-- database          # SQL schema file
|-- README.md         # Project documentation
