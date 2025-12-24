# 🎓 OOP Course Registration Lab (Java)

A small **course registration simulator** built for learning Object-Oriented Programming (OOP).

This project started as a reflection on my **CSIS1175 (Introduction to Programming)** final exam. At the time, I struggled to understand _why logic should live inside domain classes_ and what my professor meant by “designing with responsibilities.”

After rebuilding the idea step-by-step (and iterating a lot), the code evolved into a clean learning playground where I can **taste real coordination** between:

- ✅ **Domain classes** (Student, Course, Registration)
- ✅ **Rule classes** (eligibility checks)
- ✅ **Factory** (creation + orchestration)
- ✅ **Basic state-like flow** (pass/fail gating via rules)
- ✅ **File I/O helper** (save/load records)
- ✅ **Custom exception** (FileHandlerException)
- ✅ **Basic unit tests** (JUnit)

> ⚠️ This is **not production code**.
> It’s a study project designed to practice _OOP thinking_, readability, and collaboration between classes.

---

## ✨ What this project demonstrates

### 🧱 OOP Foundations

- Encapsulation and responsibility separation
- Composition (Student has courseTaken, Course has prerequisite)
- Domain objects that represent “real things” (Student / Course / Registration)

### 🧠 Rule Engine (Eligibility Rules)

- Each rule implements a shared interface: `EligibilityRule`
- Rules return a consistent result object: `EligibilityResult`
- Registration is approved only if **all rules pass**

Rules included:

- **AlreadyRegisteredRule**: blocks duplicates for the same term
- **CreditRule**: checks completed credits
- **PrerequisiteRule**: checks prerequisite course

### 🏭 Factory Pattern

- `RegistrationFactory.create(...)` evaluates rules and decides success/failure
- Keeps “how to register” logic centralized and easy to test

### 💾 Persistence (File I/O)

- `FileHandler` saves and loads `RegistrationRecord` objects to a text file
- Uses try-with-resources
- Throws a custom runtime exception for clarity

### 🧪 Testing

- JUnit tests validate file behavior and exception handling

---

## 🗂️ project structure

```text
src/
      Main.java
      domain/
        Person.java
        Student.java
        Course.java
        Registration.java
        RegistrationRecord.java
      rules/
        EligibilityRule.java
        EligibilityResult.java
        CreditRule.java
        PrerequisiteRule.java
        AlreadyRegisteredRule.java
      services/
        RegistrationService.java
      factory/
        RegistrationFactory.java
      infra/
        FileHandler.java
        FileHandlerException.java

      test/
        FileHandlerTest.java
```

---

## ▶️ How it works

### Example flow

1. Create a `Student` and some `Course` objects
2. Call `RegistrationService.registerAndSave(student, course, term)`
3. Service builds rules → Factory evaluates rules → if OK, record is saved
4. Load and print saved registrations

---

## 🚀 Run

If you’re using IntelliJ:

1. Open as a Gradle/Maven project (or plain Java project)
2. Run `Main`

If you’re using command line (simple example):

```bash
javac Main.java
java Main
```

---

## ✅ Example output

```text
Registered (CSIS1280): Registration successful.
Register denied (CSIS3380): Insufficient credits.

=== Saved Registrations ===
30012342567,CSIS1280,2026Winter
```

---

## 🧩 Design notes

- **EligibilityResult** is intentionally simple and beginner-friendly.
- Rules are evaluated in order; the first failure stops the process.
- File format is CSV-like: `studentId,courseId,term`

---

## 🗺️ Roadmap (optional improvements)

If I want to keep evolving this as a learning project:

- Add a `RuleEngine` class (to manage rule ordering and reporting)
- Add more states (e.g., `PENDING`, `APPROVED`, `DENIED`) and track them
- Support multiple completed courses (instead of a single `courseTaken`)
- Switch file persistence to JSON for structured storage
- Add more tests (rules, factory flow, duplicate detection)
