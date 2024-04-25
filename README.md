# Traffic Management System

CSE 564 Team 7 Implementation- version 7
<br/><br/>
Our Traffic Management System provides a simulation of a modern traffic management system for a 4-way intersection. Using real-time data analysis and intelligent signal control, the system optimizes traffic flow, prioritizes safety, and minimizes congestion. Through this project, we aim to showcase the effectiveness of smart traffic management systems in urban environments.

## Table of Contents

- [About](#about)
- [Technologies](#technologies)
- [Installation](#installation)
- [Contributors](#contributors)

## About

The project aims to simulate a modern traffic light system for a 4-way intersection. Using camera analysis, the system determines the number of vehicles at each side of the intersection to regulate the switching of lights. Safety is a priority, with measures in place to prevent collisions by ensuring that opposite directions never have green lights simultaneously. Left turn signals and yellow lights are also included for added complexity.

The system operates with traffic light sensors communicating with a master thread to make switching decisions, ensuring safety. Simulated cars follow predefined rules, including restrictions on turning during red lights and passing only during green lights. No emergency vehicles are included in this simulation. An additional controller ensures the safety of traffic flow.

## Technologies

### List of technologies used in the project:

- Java
- JUnit (for testing)
- JaCoCo (for code coverage)

### Tools used in the project:

- IntelliJ IDEA (IDE)
- Visual Studio Code (IDE)
- Maven (build tool)

<img align="left" alt="Java" width="46px" style="margin-right: 12px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" />
<img align="left" alt="Maven" width="46px" style="margin-right: 12px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/maven/maven-original.svg"  />
<img align="left" alt="ΞΘνιτ" width="46px" style="margin-right: 12px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original-wordmark.svg"  />
<img align="left" alt="Eclipse" width="46px" style="margin-right: 12px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/eclipse/eclipse-original.svg"  />
<img align="left" alt="IntelliJ" width="46px" style="margin-right: 12px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg"  />
<img align="left" alt="VScode" width="46px" style="margin-right: 12px;" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vscode/vscode-original.svg"  />
<img align="left" alt="Github" width="46px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/github/github-original.svg"  />

<br/>
<br/>

## Installation

The project is developed using IntelliJ IDEA. For convenience, it is recommended to run this program using IntelliJ IDEA for minimal setup time.

### JetBrains IntelliJ IDEA

1. Clone the repository or download a zip file of the repository.

```sh
git clone https://github.com/CSE564-Team7-Project/Implementation_v7.git
```

2. Open IntelliJ IDEA.
3. Select `File` > `Open` and navigate to the cloned repository.
4. Click Open and then Next.
5. Click Next until you can click Finish.
6. Set up **Run/Debug Configurations**:
   1. Go to Run > Edit Configurations....
   2. Click the **+** icon and select Application.
   3. Name the configuration whatever you like, for example, _Main_.
   4. Choose JDK 17+ from the dropdown (JDK version 17 and newer).
   5. In the Main class field, select the main class of your application.
   6. Click OK.
7. Run the application using the configured **Run/Debug Configurations**.

### Eclipse IDE

1. Clone the repository or download a zip file of the repository.

```sh
git clone https://github.com/CSE564-Team7-Project/Implementation_v7.git
```

2. Open Eclipse IDE.
3. Select File > New > Java Project.
4. Enter a project name and click Finish.
5. Right-click on the src folder of the newly created Eclipse project.
6. Select Import.
7. Select General > File System and click Next.
8. Click Browse and navigate to the directory `Implementation_v7\traffic_management\src\traffic_management.`
9. Select the folder and click **Finish**.
10. Refresh the project in Eclipse by right-clicking on the project name and selecting **Refresh**.
11. Locate the **Main** class in the project explorer.
12. Right-click on `Main.java`.
13. Select **Run As** > **Java Application**.

## Contributors

- Michael Mathews / Juggernaut9434
- Albert Negoro / albertn89
- ChingChun Yuan / oliveyuan

![](https://private-user-images.githubusercontent.com/74038190/241765440-80728820-e06b-4f96-9c9e-9df46f0cc0a5.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTM5OTkxNjEsIm5iZiI6MTcxMzk5ODg2MSwicGF0aCI6Ii83NDAzODE5MC8yNDE3NjU0NDAtODA3Mjg4MjAtZTA2Yi00Zjk2LTljOWUtOWRmNDZmMGNjMGE1LmdpZj9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA0MjQlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNDI0VDIyNDc0MVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTIyZjMzMzkzNDMyZWNjMGViOGEwNDQwNDgxMGQ0YjdhNDAwYWNjMjc0MzAyYzM5ZDFmNWRiOWE4ZWVmZmEwYmQmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.RvDZGF8npv80z67Uq-fRM1_14huOlZRMqpzZj8ZTrRQ)
