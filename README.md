![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
# Particle Universe Simulation

This Java project simulates the gravitational interaction between multiple particles in a 2D space, using Newtonian mechanics. It includes a graphical user interface (GUI) for real-time visualization of the simulation. The simulation reads initial particle configurations from data files.

##  Features

- Real-time 2D particle simulation with gravitational interaction
- Object-oriented structure with clear separation between geometry, physics, and GUI
- Support for loading multiple preset particle configurations
- Visual rendering using `JPanel` and `Graphics2D` with smooth animation

## Technologies Used and Relevant Concepts Used

- **Java 19+**
- **Swing** for GUI


## Core Concepts

- Each particle has position, velocity, mass, and radius.
- Forces between particles are computed using Newton's gravitational formula.
- Each frame updates the position and velocity based on resulting net forces.
- Rendering is scaled to fit all particles within the window regardless of universe radius.

## 📁 Project Structure

```
UniverseSimulation
├─ 📁data
│  └─ 📁universos
├─ 📁src
│  ├─ 📁main
│  │  ├─ 📁java
│  │  │  ├─ 📁gui
│  │  │  │  └─ 📄PanelUniverso.java
│  │  │  ├─ 📁rectas
│  │  │  │  ├─ 📄Implicita.java
│  │  │  │  ├─ 📄Punto.java
│  │  │  │  ├─ 📄Recta.java
│  │  │  │  └─ 📄Vector.java
│  │  │  ├─ 📁universo
│  │  │  │  ├─ 📄DatosUniverso.java
│  │  │  │  ├─ 📄DatosUniverso.java~
│  │  │  │  ├─ 📄Particula.java
│  │  │  │  └─ 📄Universo.java
│  │  │  └─ 📄MainFichero.java
│  │  └─ 📁resources
│  └─ 📁test
│     └─ 📁java
├─ 📄.gitignore
├─ 📄LICENSE
├─ 📄pom.xml
└─ 📄README.md
```

## 📂 Input Files

Input files are expected in the folder: `data/universos/`.

### Add new input files

Each file should have the following format:
```
<NUMBER_OF_PARTICLES> <UNIVERSE_RADIUS> <DELTA_TIME> <SLEEP_TIME>
<X1> <Y1> <VEL_X1> <VEL_Y1> <MASS1> <RADIUS1>
<X2> <Y2> <VEL_X2> <VEL_Y2> <MASS2> <RADIUS2>
...
<Xn> <Yn> <VEL_Xn> <VEL_Yn> <MASSn> <RADIUSn>
```
Where:
- NUMBER_OF_PARTICLES: integer – the total number of particles in the universe

- UNIVERSE_RADIUS: decimal – the radius of the simulation universe

- DELTA_TIME: decimal – time step for each simulation iteration

- SLEEP_TIME: integer – milliseconds to wait between steps

- For each particle:

    - X, Y: initial position coordinates

    - VEL_X, VEL_Y: velocity components

    - MASS: mass of the particle

    - RADIUS: radius of the particle (used for visualization and collisions)
## 🚀 How to Run

### 1. Compile the project

```bash
javac -d out $(find src -name "*.java")
```

### 2. Run the simulation

```bash
java -cp out MainFichero <input_file_name.txt>
```
Example:
```bash
java -cp out MainFichero atom.txt
```
Included configuration files:

- 📄8star-rotation.txt
- 📄atom.txt
- 📄awesome.txt
- 📄chaosblossom.txt
- 📄dance10.txt
- 📄entropy-universe.txt
- 📄fourellipses.txt
- 📄hypnosis.txt
- 📄illusion.txt
- 📄planetsparty.txt
- 📄spiral.txt

## 📸 Screenshots
![Awesome simulation](https://github.com/cberdejo/Universe-Simulation-Java/blob/e92edd161bad0fef4858a0d3253bc706780ba106/data/captures/awesome.png)
![Atomic detail](https://github.com/cberdejo/Universe-Simulation-Java/blob/e92edd161bad0fef4858a0d3253bc706780ba106/data/captures/atom.png)



##  License
This project is open-source and available under the MIT License.