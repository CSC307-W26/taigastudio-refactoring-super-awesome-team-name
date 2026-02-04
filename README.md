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

class BurndownChart 
class JPanel
class Blackboard
class Sprint
class Task

JPanel <|-- BurndownChart
BurndownChart --> Blackboard
BurndownChart --> Sprint
BurndownChart ..> Task
```
