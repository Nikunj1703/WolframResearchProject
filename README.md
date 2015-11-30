# WolframResearchProject

Explanation for implementing the project using Page Factory Design Pattern.

Page Factory design pattern provides us an ability to reuse the variables (which are Page Factory Web elements in this
project) across different classes/methods while reducing multiple findElement
calls -by making use of Annotations. Moreover, it helped us to reduce code duplicity
in functional test cases (which cannot not be achieved –up to
much higher extent- through Page Object design). Also, it enables us to write
modular test cases (in much optimized manner) to conduct testing of various
web elements on HomeScreen (where I checked: if we click on New Button
dropdown link all the options should get enabled). In a nut-shell, since we can create more modular & scalable test cases and re-usable variables, I
chose Page Factory Design Pattern.

Coverage:
  1. Functional Testing
  2. Appearance/User Experience Testing

Technology:
  1. Java – Selenium Web Driver Automation

Framework:
  1. TestNG
  2. ReportNG

Design Pattern:
  1. Page Factory Design Pattern

Nikunj Ratnaparkhi
