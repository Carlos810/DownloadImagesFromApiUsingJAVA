# Console Image Downloader in Java

## 🚀 Overview
A robust **console application in Java** for downloading multiple images from a remote API to a local directory, featuring **clean architecture**, **design patterns**, and **modular code separation**.

---

## 🛠️ Key Features

- **User Input Handling**  
  Interactive console prompt for specifying the number of images to download.

- **Environment Configuration**  
  Externalized configuration for API URLs and download directories.

- **Database Integration**  
  Singleton-based Oracle database connection.

- **Batch Downloading**  
  Capability to download multiple images in a single execution.

- **Error Validation**  
  Input validation with meaningful exception messages.

---

## 🏗️ Design Patterns Implemented

### ✅ Singleton
`OracleConnection.getInstance()` ensures a single database connection instance across the application.

### ✅ Factory Method
The `devEnvironment` class acts as a factory for environment-specific configurations (API URL, local directory).

### ✅ Separation of Responsibilities

- **Main Class**  
  Handles program flow and user interaction.

- **Controller Class (`ImagenController`)**  
  Manages business logic for downloading images.

- **Environment Class (`devEnvironment`)**  
  Handles configuration and external dependencies.

- **Database Class (`OracleConnection`)**  
  Manages database connectivity independently.

---

## 📁 Project Structure

```text
Main.java                → Entry point, user interaction
ImagenController.java    → Core image download logic
devEnvironment.java
