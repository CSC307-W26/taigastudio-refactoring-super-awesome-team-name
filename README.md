[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/LXc5UHtr)

> [!NOTE]
>
> Experimenting with a class diagram created in Mermaid.

```mermaid
%%{init: {'themeVariables': {
  'fontSize': '14px',
  'nodeSpacing': 80,
  'rankSpacing': 80
}}}%%
classDiagram
direction TB

class BurndownChart {
}

class JPanel
class Blackboard
class Sprint
class Task

%% ---- Style definitions ----
classDef ui fill:#D6EAF8,color:#0B3C5D,stroke:#1B4F72,stroke-width:2px
classDef dao fill:#D5F5E3,color:#145A32,stroke:#1E8449,stroke-width:2px
classDef swing fill:#FDEBD0,color:#7E5109,stroke:#CA6F1E,stroke-width:2px

%% ---- Apply styles ----
class BurndownChart ui
class Blackboard dao
class Sprint dao
class Task dao
class JPanel swing

JPanel <|-- BurndownChart
BurndownChart --> Blackboard
BurndownChart --> Sprint
BurndownChart ..> Task
```
