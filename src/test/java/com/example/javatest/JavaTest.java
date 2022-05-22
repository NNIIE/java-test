package com.example.javatest;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class JavaTest {

    @Test
    @DisplayName("DisplayName Test")
    void create() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("limit은 0보다 커야합니다.", exception.getMessage());

        assertTimeout(Duration.ofMillis(100), () -> new Study(10));

        // timeout 실패 케이스
//        assertTimeout(Duration.ofMillis(100), () -> {
//            new Study(10);
//            Thread.sleep(300);
//        });

        Study study = new Study(10);

        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                        () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다."), // 메시지를 람다식으로 표현하는 이유는 람다식으로 표현하면 테스트가 실패했을 시에만 메시지 연산을 하기 때문
                () -> assertTrue(study.getLimit() > 0,
                        () -> "스터디 최대 참석 가능 인원은 0보다 커야한다")
        );
    }

    @Test
    @DisplayName("DisplayName Test 2")
    void create1() {
        System.out.println("create1");
    }

    @Test
    @DisplayName("Assumptions")
    void assumptions() {
        System.out.println(System.getenv("TEST_ENV"));
        assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));
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
