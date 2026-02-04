[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/LXc5UHtr)

```mermaid
%%{init: {'themeVariables': {
    'fontSize': '14px',
    'nodeSpacing': 80,
    'rankSpacing': 80
}}}%%
classDiagram
direction TB

class JPanel {
    placeholderPaddingToAvoidCutting
}

class BurndownChart {
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
    +paintComponent(Graphics g)
}

class Blackboard {
    +getActiveSprint() Sprint
    +getAllTasks() List~Task~
}

class Sprint {
    +getBeginning() Date
    +getExpiration() Date
}

class Task {
    +getCompletionDate() Date
}

JPanel <|-- BurndownChart
BurndownChart --> Blackboard
BurndownChart --> Sprint
BurndownChart ..> Task
```
