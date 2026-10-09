package com.lab.gradebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradebookTest {

    private Gradebook gradebook;
    private Student alice;
    private Student bob;

    @BeforeEach
    void setUp() {
        gradebook = new Gradebook();
        alice = new Student("A1", "Alice");
        bob = new Student("B2", "Bob");
    }

    @Test
    void testAddScoreDoesNotThrowNPE() {
      
        assertDoesNotThrow(() -> alice.addScore(95.0));
        assertEquals(95.0, alice.calculateAverage(), 0.001);
    }

    @Test
    void testFindStudentByIdWithNewStringInstance() {
        alice.addScore(90.0);
        gradebook.addStudent(alice);

        // Forces non-interned String reference to expose Bug 2
        String searchId = new String("A1");
        Student found = gradebook.findStudentById(searchId);

        assertNotNull(found, "Student should be found by ID");
        assertEquals("Alice", found.getName());
    }

    @Test
    void testClassAveragePrecision() {
        alice.addScore(85.0);
        bob.addScore(86.0);
        gradebook.addStudent(alice);
        gradebook.addStudent(bob);

        // Expected: (85.0 + 86.0) / 2 = 85.5
        // Will fail due to integer truncation/division (Bug 3)
        assertEquals(85.5, gradebook.calculateClassAverage(), 0.001);
    }

    @Test
    void testGetTopPerformer() {
        alice.addScore(70.0);
        bob.addScore(95.0);
        gradebook.addStudent(alice);
        gradebook.addStudent(bob);

        // Will throw IndexOutOfBoundsException due to Bug 4 (i <= roster.size())
        Student top = gradebook.getTopPerformer();
        assertNotNull(top);
        assertEquals("Bob", top.getName());
    }
}