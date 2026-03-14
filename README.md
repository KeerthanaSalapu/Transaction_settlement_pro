# Trip Expense Settlement 

## Problem Statement

When a group of friends goes on a **trip**, many expenses happen during the journey. For example, one person may pay for **food**, another person may pay for **transportation**, and someone else may pay for **hotel rooms**. Sometimes one person may even pay multiple times while another person may **not pay anything at all**.

Even though different people pay at different times, the **total expense should be shared equally** among everyone in the group. At the end of the trip, it becomes confusing to calculate **how much each person actually owes and who should pay whom**.

For example, if three friends go on a trip and one person pays most of the expenses, the other two friends should **return the extra money** to that person so that everyone finally pays the **same amount**.

The goal of this program is to **solve this problem automatically**. The program takes the list of people and the expenses paid during the trip, calculates **how much each person should contribute**, and then prints the final payments required to **settle all debts**.

This problem is similar to what apps like **Splitwise** do.

---

## Objective of the Program

The main goals of this program are:

* Take input for the **number of people** going on the trip.
* Record the **name of each person**.
* Record all **expenses and who paid** for each expense.
* Calculate the **total expense of the trip**.
* Divide the total expense **equally among all people**.
* Find out **who owes money** and **who should receive money**.
* Print the **final settlement** showing **who should pay whom**.

---

## Example Scenario

Suppose three friends go on a trip:

* **Alice** pays for dinner and snacks.
* **Bob** pays for transportation.
* **Charlie** does not pay for anything.

Even though the payments were different, **all three friends should share the total cost equally**. The program calculates the difference and tells **who should pay whom** so that everyone ends up paying the **same amount**.

---

## Sample Input

```text
Enter number of people: 3

Enter name: Alice
Enter name: Bob
Enter name: Charlie

Enter number of expenses: 3

Expense 1
Who paid: Alice
Amount: 20

Expense 2
Who paid: Alice
Amount: 5

Expense 3
Who paid: Bob
Amount: 10
```

---

## Sample Output

```text
Each person should pay: 11.67

Settlement:

Bob needs to pay Alice : 1.67
Charlie needs to pay Alice : 11.67
```


 

---

## Algorithm Used – Greedy Algorithm

This program uses a **Greedy Algorithm** to settle debts.

A **Greedy Algorithm** works by always choosing the **best possible option at the current step**.

In this program the algorithm works like this:

1. Find the person who should **receive the most money** (**creditor**).
2. Find the person who **owes the most money** (**debtor**).
3. The debtor pays the creditor **as much as possible**.
4. Update their balances.
5. Repeat the process until **all balances become zero**.

This method helps **minimize the number of transactions** needed to settle the debts.

---

## Technologies Used

* **Java**
* **HashMap** (to store payment information)
* **Collections Framework**
* **BigDecimal** (for accurate decimal rounding)


 

---

## What This Project Demonstrates


* **Basic problem solving using Java**
* Understanding of **real-world expense sharing problems**
* Use of **HashMap and Collections in Java**
* Implementation of a **Greedy Algorithm**
* Ability to convert a **real-life problem into a working program**

