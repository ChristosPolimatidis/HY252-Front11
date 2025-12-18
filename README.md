# HY252-Front11 — Java Collection Framework (Frontistirio 11)

This repository contains runnable **Java 1.8 (JDK 8)** examples for the **Java Collection Framework** (Sets, Maps, Iterators, Generics, Stacks, etc.), packaged as a small console application with a **single entry point**.

When you run the project, you will see a menu (1–18). Typing a number executes the corresponding demo.

---

## Requirements

- **JDK 8 (Java 1.8)** installed
- Any of the following:
  - IntelliJ IDEA
  - Eclipse
  - NetBeans
  - VS Code
  - Terminal

**Main class:** `frontistirio11.MainMenu`

---

## Project Structure

```
src/main/java/
  frontistirio11/
    MainMenu.java               <-- main menu entry point
    examples/                   <-- each demo is a separate file
    stack/                      <-- stack implementation used by demos
    tiny/                       <-- Tiny interface + implementations
```

---

## How to Run

### 1) IntelliJ IDEA

1. **File → Open…** and select the folder `HY252-Front11`
2. Set **JDK 8**:
   - **File → Project Structure → Project SDK → Java 1.8**
3. Ensure sources are marked correctly:
   - Right click `src/main/java` → **Mark Directory as → Sources Root**
4. Open `src/main/java/frontistirio11/MainMenu.java`
5. Click the green ▶ (Run) next to `MainMenu` / `main()`.

---

### 2) Eclipse

1. **File → Import… → General → Existing Projects into Workspace**
2. Select the repo folder (`HY252-Front11`) → **Finish**
3. Set Java to **1.8**:
   - Right click project → **Properties**
   - **Java Compiler** → enable “Project specific settings” → set **1.8**
   - **Java Build Path** → ensure **JRE System Library** points to **Java 8**
4. If needed, mark sources:
   - Right click `src/main/java` → **Build Path → Use as Source Folder**
5. Run:
   - Open `frontistirio11/MainMenu.java`
   - Right click → **Run As → Java Application**

---

### 3) NetBeans

NetBeans sometimes prefers projects created via its wizard.

**Option A (recommended): Create a project from sources**
1. **File → New Project**
2. Choose **Java with Ant → Java Application** (or “Java Application”)
3. Use **JDK 8** as the Java Platform
4. Copy the contents of `src/main/java/frontistirio11` into your project’s `src/` folder  
   (keep the same package name: `frontistirio11`)
5. Set the **Main Class** to:
   - `frontistirio11.MainMenu`
6. Click **Run**

**Option B (quickest): run from Terminal** (see the Terminal section below).

---

### 4) VS Code

1. Install **JDK 8**
2. Install the extension:
   - **Extension Pack for Java** (by Microsoft)
3. **File → Open Folder…** → select `HY252-Front11`
4. Open `src/main/java/frontistirio11/MainMenu.java`
5. Click **Run** (or the **Run Java** link above `main()`).

---

### 5) Terminal

#### macOS / Linux

From the repo root:

```bash
# Compile (Java 8)
javac -encoding UTF-8 -source 1.8 -target 1.8 -d out $(find src/main/java -name "*.java")

# Run
java -cp out frontistirio11.MainMenu
```

#### Windows (PowerShell)

From the repo root:

```powershell
# Compile
$files = Get-ChildItem -Recurse -Filter *.java src\main\java | ForEach-Object { $_.FullName }
javac -encoding UTF-8 -source 1.8 -target 1.8 -d out $files

# Run
java -cp out frontistirio11.MainMenu
```

---

## Using the Menu

- The program prints a list of demos.
- Type a number (1–18) and press Enter to run the selected demo.
- Type **18** to exit.

---

## Troubleshooting

- **“Cannot find symbol / class not found” in IDE:** make sure `src/main/java` is marked as a **Sources Root** (or **Source Folder**).
- **Wrong Java version:** confirm the project is using **JDK 8** (Java 1.8).
- **No visible delay when using `Thread.sleep`:** print something before sleeping and call `System.out.flush()`.

---

## License

This project is licensed under the **MIT License**. See `LICENSE`.
