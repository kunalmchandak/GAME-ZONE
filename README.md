# GAME ZONE

## Overview
GAME ZONE is a Java-based desktop gaming application developed using **Java Swing** and **AWT** for the UI, with **MySQL** as the backend for storing user data. It features multiple mini-games, including **Rock Paper Scissors** and **Tic Tac Toe**.

## Features
- Interactive **Splash Screen**
- **Home Screen** with game selection
- **Rock Paper Scissors** game
- **Tic Tac Toe** game
- User authentication (Login & Signup) using **MySQL database**
- Responsive UI with animations

## Technologies Used
- **Java Swing & AWT** (Graphical User Interface)
- **MySQL** (Database for storing user information)
- **JDBC** (Connecting Java application with MySQL)

## Installation
### Prerequisites:
- Java Development Kit (**JDK 8+**)
- MySQL Database
- Git (for version control)

### Steps:
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd GAME-ZONE
   ```
2. Configure the MySQL database:
   - Import `game_zone.sql` into MySQL
   - Update database credentials in `DatabaseConnection.java`
3. Compile and run the project:
   ```sh
   javac -d bin -sourcepath src src/com/project/demo/Main.java
   java -cp bin com.project.demo.Main
   ```

## Contributing
To contribute to this project:
1. Fork the repository
2. Create a new branch:
   ```sh
   git checkout -b feature-branch
   ```
3. Make your changes and commit:
   ```sh
   git commit -m "Added new feature"
   ```
4. Push changes and create a Pull Request:
   ```sh
   git push origin feature-branch
   ```

## Contributors
- **Kunal Chandak** ([Project Developer](https://github.com/kunalmchandak))
- **Ekta Khante** ([Project Developer](https://github.com/ektakhante))

## License
This project is licensed under the **MIT License**. Feel free to use and modify!

