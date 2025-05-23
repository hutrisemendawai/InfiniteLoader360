# InfiniteLoader

![Java](https://img.shields.io/badge/Java-17+-blue.svg) ![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)

**InfiniteLoader** is a lightweight Java Swing application that launches a full-screen, borderless window displaying an indeterminate loading bar. It’s perfect for demo screens, placeholders, or any scenario requiring an “infinite” loading animation. Close the window at any time using your platform’s standard shortcut (e.g., **Alt + F4** on Windows/Linux or **⌘ + W** on macOS).

---

## 📋 Table of Contents

1. [Features](#-features)
2. [Requirements](#-requirements)
3. [Installation](#-installation)
4. [Usage](#-usage)
5. [Project Structure](#-project-structure)
6. [Contributing](#-contributing)
7. [License](#-license)

---

## ✨ Features

* 🖥️ **Full-Screen, Borderless Window**: Launches in true full-screen mode when supported, or maximized as fallback.
* 🔄 **Infinite Loading Bar**: Uses Swing’s indeterminate `JProgressBar` for a smooth, looping animation.
* ⚡ **Lightweight**: Zero external dependencies; only requires JDK 17+.
* 🔑 **Easy to Close**: Standard close shortcut exits the application.

---

## 🛠️ Requirements

* **Java**: JDK 17 or higher installed and configured in your `PATH`.
* **Git**: (Optional) for cloning the repository.

---

## 🚀 Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/<your-username>/InfiniteLoader.git
   cd InfiniteLoader
   ```

2. **Compile the source**

   ```bash
   javac -d out src/com/example/loading/Main.java
   ```

   * Compiles `Main.java` into the `out/` directory.

3. **Run the application**

   ```bash
   java -cp out com.example.loading.Main
   ```

> Tip: In your IDE (IntelliJ, Eclipse, VS Code), import as a standard Java project and run `Main.java` directly.

---

## ▶️ Usage

1. Run the application as above.
2. The app enters full-screen mode with an indeterminate loading bar.
3. Close the app with **Alt + F4** (Windows/Linux) or **⌘ + W** (macOS).

---

## 🗂️ Project Structure

```
InfiniteLoader/
├── src/
│   └── com/example/loading/
│       └── Main.java   # Application entry point
├── out/                # Compiled .class files (after build)
└── README.md           # Project documentation
```

---

## 🤝 Contributing

Contributions are welcome! Please fork the repo, create a branch for your feature or bugfix, and submit a pull request.

1. Fork this repository
2. Create a feature branch: `git checkout -b feature/YourFeature`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/YourFeature`
5. Open a Pull Request

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
