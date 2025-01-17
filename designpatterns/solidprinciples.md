Here’s a **README** format version of the SOLID principles explanation with code examples:

---

# SOLID Principles with Code Examples in Java

This document explains the five SOLID principles of object-oriented design and provides code examples to illustrate how to implement each principle in Java.

## 1. **Single Responsibility Principle (SRP)**

A class should have only one reason to change, meaning it should have only one job or responsibility.

### Example:
#### **Violation of SRP:**
```java
class UserService {
    public void registerUser(String username, String password) {
        // Registering user logic
    }

    public void sendEmail(String emailContent) {
        // Sending email logic
    }
}
```

#### **Following SRP:**
```java
class UserService {
    private EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void registerUser(String username, String password) {
        // Registering user logic
    }
}

class EmailService {
    public void sendEmail(String emailContent) {
        // Sending email logic
    }
}
```
- **Explanation:** We separated the email logic into an `EmailService` class so that `UserService` focuses only on user registration.

---

## 2. **Open/Closed Principle (OCP)**

Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

### Example:
#### **Violation of OCP:**
```java
class TaxCalculator {
    public double calculateTax(Employee employee) {
        if (employee.getType().equals("Manager")) {
            return employee.getSalary() * 0.2;
        } else if (employee.getType().equals("Developer")) {
            return employee.getSalary() * 0.1;
        }
        return 0;
    }
}
```

#### **Following OCP:**
```java
abstract class Employee {
    abstract double calculateTax();
}

class Manager extends Employee {
    @Override
    double calculateTax() {
        return getSalary() * 0.2;
    }
}

class Developer extends Employee {
    @Override
    double calculateTax() {
        return getSalary() * 0.1;
    }
}

class TaxCalculator {
    public double calculateTax(Employee employee) {
        return employee.calculateTax();
    }
}
```
- **Explanation:** We used inheritance to allow `Employee` subclasses to extend behavior and provide specific tax calculations.

---

## 3. **Liskov Substitution Principle (LSP)**

Objects of a superclass should be replaceable with objects of a subclass without affecting the functionality of the program.

### Example:
#### **Violation of LSP:**
```java
class Bird {
    public void fly() {
        // Flying logic
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches cannot fly");
    }
}
```

#### **Following LSP:**
```java
class Bird {
    public void move() {
        // Default moving logic
    }
}

class Sparrow extends Bird {
    @Override
    public void move() {
        // Flying logic
    }
}

class Ostrich extends Bird {
    @Override
    public void move() {
        // Running logic
    }
}
```
- **Explanation:** We created a `move()` method to allow both `Sparrow` and `Ostrich` to substitute `Bird` without breaking expected behavior.

---

## 4. **Interface Segregation Principle (ISP)**

Clients should not be forced to depend on interfaces they do not use. It's better to have several smaller, specific interfaces than one large, general-purpose interface.

### Example:
#### **Violation of ISP:**
```java
interface MultiFunctionPrinter {
    void print();
    void scan();
    void fax();
}

class Printer implements MultiFunctionPrinter {
    public void print() {
        // Print logic
    }

    public void scan() {
        // Scan logic
    }

    public void fax() {
        // Fax logic
    }
}

class OldPrinter implements MultiFunctionPrinter {
    public void print() {
        // Print logic
    }

    public void scan() {
        throw new UnsupportedOperationException();
    }

    public void fax() {
        throw new UnsupportedOperationException();
    }
}
```

#### **Following ISP:**
```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class AllInOnePrinter implements Printer, Scanner, Fax {
    public void print() {
        // Print logic
    }

    public void scan() {
        // Scan logic
    }

    public void fax() {
        // Fax logic
    }
}

class SimplePrinter implements Printer {
    public void print() {
        // Print logic
    }
}
```
- **Explanation:** We split the interfaces into smaller, more focused interfaces (`Printer`, `Scanner`, and `Fax`). Clients like `OldPrinter` can choose only the functionality they need.

---

## 5. **Dependency Inversion Principle (DIP)**

High-level modules should not depend on low-level modules. Both should depend on abstractions.

### Example:
#### **Violation of DIP:**
```java
class LightBulb {
    public void turnOn() {
        System.out.println("LightBulb: Turned ON");
    }

    public void turnOff() {
        System.out.println("LightBulb: Turned OFF");
    }
}

class Switch {
    private LightBulb bulb;

    public Switch(LightBulb bulb) {
        this.bulb = bulb;
    }

    public void operate() {
        bulb.turnOn();
    }
}
```

#### **Following DIP:**
```java
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("LightBulb: Turned ON");
    }

    public void turnOff() {
        System.out.println("LightBulb: Turned OFF");
    }
}

class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}
```
- **Explanation:** The `Switch` class no longer depends directly on a specific implementation like `LightBulb`. Instead, it depends on the `Switchable` abstraction, making it more flexible and extensible.

---

## Conclusion

These principles aim to make object-oriented systems more **maintainable**, **flexible**, and **scalable** by adhering to solid design patterns. Following SOLID principles ensures your software will be easier to modify, extend, and test.

---

Feel free to use this document as a reference when learning or working with object-oriented design principles!