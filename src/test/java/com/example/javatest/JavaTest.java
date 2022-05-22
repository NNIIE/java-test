package com.example.javatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaTest {

    @Test
    @DisplayName("DisplayName Test")
    void create() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @DisplayName("DisplayName Test 2")
    void create1() {
        System.out.println("create1");
    }

    // 테스트들이 실행되기 전에 딱 1번 실행되는 어노테이션
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    // 테스트들이 실행된 후 딱 1번 실행되는 어노테이션
    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    // 각각의 테스트들이 실행되기 이전에 1번씩 실행되는 어노테이션
    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    // 각각의 테스트들이 실행된 후 1번씩 실행되는 어노테이션
    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }

    // @Disabled - 실행하고 싶지 않을 때
}
