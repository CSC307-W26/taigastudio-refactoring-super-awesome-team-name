[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/LXc5UHtr)

```mermaid
classDiagram
direction LR

class JPanel {
  <<Swing>>
}

class BurndownChart {
  <<Swing>>
  -Sprint currentSprint
  -Blackboard blackboard
  -int maxPoints
  -int sprintLengthDays
  -int leftPadding
  -int rightPadding
  -int topPadding
  -int bottomPadding
  -static int POINT_SIZE
  -static long MILLIS_PER_DAY

  +BurndownChart(Blackboard blackboard)
  +paintComponent(Graphics g) void

  -drawCompletionLine(Graphics g, List~Task~ allTasks) void
  -drawProjectedLine(Point origin, Graphics g) void
  -drawAxes(Graphics g) void
}

class Blackboard {
  <<dao>>
  +getActiveSprint() Sprint
  +getAllTasks() List~Task~
}

class Sprint {
  <<dao>>
  +getBeginning() Date
  +getExpiration() Date
}

class Task {
  <<dao>>
  +getCompletionDate() Date
}

class Graphics {
  <<awt>>
}

class Point {
  <<awt>>
}

class Dimension {
  <<awt>>
}

class Date {
  <<util>>
}

JPanel <|-- BurndownChart

BurndownChart --> Blackboard : uses
BurndownChart --> Sprint : holds currentSprint
BurndownChart ..> Task : processes
BurndownChart ..> Graphics : draws with
BurndownChart ..> Point : uses origin
BurndownChart ..> Dimension : reads size
Sprint ..> Date : returns
Task ..> Date : returns
```
