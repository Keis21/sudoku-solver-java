# Sudoku Solver (Java + JavaFX)

This is a simple Java application that solves Sudoku puzzles using backtracking.  
The graphical user interface (GUI) is built with **JavaFX**, allowing users to input Sudoku puzzles and see the solution rendered interactively.

---

## 🚀 Features

- Clean JavaFX-based user interface
- Validates input Sudoku grid
- Uses recursive backtracking algorithm
- Instant solution display

---

## 🛠️ Technologies Used

- **Java 8 or higher** – Core programming language for application logic
- **JavaFX SDK** – Used to build the graphical user interface (GUI)
- **Eclipse IDE** – Recommended for development (can also be run from IntelliJ or command line)

---

## ✅ Prerequisites

1. **Java 8 or newer**
2. **JavaFX SDK**  
   - Download from: https://openjfx.io/
   - Extract it and note the path to the `lib/` folder (you'll need this in the next step)
3. **Eclipse IDE** (or other Java IDE like IntelliJ)

---

## 💻 How to Run (Eclipse Setup)

1. **Clone or download** this repository.
2. **Import into Eclipse** as an existing Java project.
3. **Add JavaFX SDK** to the project:
   - Right-click the project > `Properties > Java Build Path > Libraries` > Add External JARs...
   - Select all `.jar` files from `javafx-sdk/lib`
4. **Add VM arguments** to support JavaFX:
   - Go to `Run > Run Configurations > Arguments > VM Arguments`
   - Add this line (adjust the path):

     ```
     --module-path "C:\path\to\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml
     ```

5. Run `Main.java` as a JavaFX application.


---

## 🙋‍♂️ Author
[Keis](https://github.com/Keis21)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
