# Arithmetic Coding
This project presents an arithmetic coding interval bounds calculator implemented with a user-friendly Java Swing GUI. The calculator processes strings containing letters A and B, assuming equal probabilities for both symbols (P(A) = P(B) = 0.5). The input string length is limited to a maximum of 16 characters. The primary objective is to calculate and visualize the lower and higher bounds of the final interval in arithmetic coding.

Implementation:
The project involves a graphical user interface (GUI) built with Java Swing for seamless user interaction. Here are the key implementation steps:

Input Validation:

Ensure the input string comprises only letters A and B.
Limit the total length of the string to 16 characters.
Java Swing GUI:

Develop a user interface with input fields for the string and buttons to trigger the calculation.
Implement event listeners to capture user inputs and initiate the calculation process.
Integrate text areas to display the results, including the lower and higher bounds.
Interval Bounds Calculation:

Assign the initial interval [0, 1) to represent the entire probability space.
Divide the interval based on the equal probabilities of A and B.
Update the interval according to each symbol in the input string.
Output Display:

Integrate text areas within the GUI to dynamically display the lower and higher bounds of the final interval.
